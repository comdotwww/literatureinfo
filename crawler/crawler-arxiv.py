import requests
import json
import pymysql
from bs4 import BeautifulSoup as bs
from datetime import datetime

url = 'http://www.arxiv-sanity.com/toptwtr?timefilter=month'

res = requests.get(url)
text = res.text
soup=bs(text, "html.parser")
extract=soup.select('script')[6]

target = extract.decode().split('var papers = ')[1]
target2 = target.replace("}, {","}xxx{").replace('[{','{').replace('}];','}')
target3 = target2.split('var pid')[0]

# with open('data.text','w') as f:
#     f.write(target3)
# with open('data.txt','r') as f:
#     target3 = f.read()

final = target3.split('xxx')
print(len(final))

connect = pymysql.connect(host='localhost',user='root',password='xxxxxx',port=3306,db='arxiv',charset='utf8')
cursor = connect.cursor()

for i in range(len(final)):
    d = json.loads(final[i])
    paperid = d['rawpid']
    print(paperid)
    title = d['title']
    abstract_content = d['abstract'].replace('\n',' ')
    pdf_url = d['link'].replace('abs','pdf')+".pdf"
    paper_date = datetime.strptime(d['published_time'],'%m/%d/%Y')
    comment = d['comment']

    paper_query_sql = 'select * from `paper` where `paper_id`='+paperid
    paper_insert_sql = 'INSERT INTO `paper` (`paper_id`, `title`,`abstract_content`,`pdf_url`,`date`,`comment`) VALUES (%s, %s,%s,%s,%s,%s)'
    paper_res = cursor.execute(paper_query_sql)
    if(paper_res==0):
        cursor.execute(paper_insert_sql,(paperid,title,abstract_content,pdf_url,paper_date,comment))
        print('one paper had inserted!')
    # print(paperid,title,abstract_content,pdf_url,paper_date,comment)

    authors = d['authors']
    # print(authors)
    for author in authors:
        print(author)
        if author.find("'")!=-1:
            continue
        author_query_sql = 'select * from `author` where `author_name`= "{}"'.format(author) 
        author_insert_sql = 'INSERT INTO `author` (`author_name`) VALUES (%s)'
        author_res = cursor.execute(author_query_sql)
        if(author_res==0):
            cursor.execute(author_insert_sql,(author))
            print('one author had inserted!')
        paper_author_query_sql = 'select * from `paper_author` where `author_name`='+ "'" + author + "'" + 'and `paper_id` = '+ paperid
        paper_author_query_res = cursor.execute(paper_author_query_sql)
        if paper_author_query_res == 0:
            paper_author_insert_sql = 'INSERT INTO `paper_author` (`paper_id`,`author_name`) VALUES (%s,%s)'
            cursor.execute(paper_author_insert_sql,(paperid,author))
            print('one paper-author had inserted!')

    tags = d['tags']
    # print(tags)
    if type(tags) !=list:
        tags = [tags]
    if len(tags)>1:
        print("-------------------------")
    for tag in tags:
        tag_query_sql = 'select * from `tag` where `tag_name`='+ "'" +tag + "'"
        tag_insert_sql = 'INSERT INTO `tag` (`tag_name`) VALUES (%s)'
        tag_res = cursor.execute(tag_query_sql)
        if(tag_res==0):
            cursor.execute(tag_insert_sql,(tag))
            print('one tag had inserted!')
        paper_tag_query_sql = 'select * from `paper_tag` where `tag_name`='+ "'" + tag + "'" + 'and `paper_id` = '+ paperid
        paper_tag_query_res = cursor.execute(paper_tag_query_sql)
        if paper_tag_query_res == 0:
            paper_tag_insert_sql = 'INSERT INTO `paper_tag` (`paper_id`,`tag_name`) VALUES (%s,%s)'
            cursor.execute(paper_tag_insert_sql,(paperid,tag))
            print('one paper-tag had inserted!')

cursor.close()
connect.commit()
connect.close()
