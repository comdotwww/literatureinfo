$(function(){
    /*------------初始化&获得元素-------- */
    Date.prototype.format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    //当前被选中的tab tag
    var cur_tab_tag = $(".Paper-tab").find(".active");
    //当前被选中的是第几个tab tag
    var cur_tab_tag_idx = 1;

    var today = new Date();
    today.setDate(today.getDate());
    var cur_date_str = today.format("yyyy-MM-dd");//初始化时间：今天
    
    cur_date_str = "2021-04-07";

    //查询限制
    var limit_l = 0;
    var limit_r = 20;

    //初始化时显示当天页面的paper
    //var test_date_str = "2021-04-01";
    getMsgByTagAndDate(cur_tab_tag.find("a").text(),cur_date_str);

    /*-------------------------------- */
    
    /*------------LayDate------------ */
    /*1.根据分类标签和时间加载paper */
    var paper_tab = $(".Paper-tab-tags"); 
    //var $paper_tab_tags = paper_tab.find(".active").find("a").text();

    //执行一个laydate实例
    laydate.render({
      elem: '#PaperList-Calender' //指定元素
      ,value: cur_date_str
      ,done: function(value,date){
            cur_date_str = date.year+"-"+date.month+"-"+date.date;
            var cur_tab_tag_str = cur_tab_tag.find("a").text();
            getMsgByTagAndDate(cur_tab_tag_str,cur_date_str);
        }
    });

    /*2.根据点击相应的tag标签查询相关paper*/
    /*给tab上的tag绑定相关的点击事件*/
    $(".PaperList").delegate(".Paper-tab-tags","click",function(){
        var $this = $(this);
        var click_tag_str = $this.find("a").text();

        var cur_tab_tag_str = cur_tab_tag.find("a").text();
        if(click_tag_str == cur_tab_tag_str) return false;

        $this.addClass("active");
        cur_tab_tag.removeClass("active");
        cur_tab_tag = $this;

        cur_tab_tag_idx = $this.index();

        getMsgByTagAndDate(click_tag_str,cur_date_str);
    });

    /*给tab上的左箭头绑定相关的事件*/
    $(".PaperList").delegate(".Paper-tab-tags-larrow","click",function(){
        cur_tab_tag_idx -= 1;
        if(cur_tab_tag_idx < 1) cur_tab_tag_idx = 5;
        $(".Paper-tab").find("li").eq(cur_tab_tag_idx).trigger("click");
    });

    /*给tab上的右箭头绑定相关的事件*/
    $(".PaperList").delegate(".Paper-tab-tags-rarrow","click",function(){
        cur_tab_tag_idx += 1;
        if(cur_tab_tag_idx > 5) cur_tab_tag_idx = 1;
        $(".Paper-tab").find("li").eq(cur_tab_tag_idx).trigger("click");
    });
    

    /*3.根据查询类型，和搜索框输入查询相关paper */
    /*输入框回车响应事件*/
    $("body").on("keypress",function(event){
        if(event.keyCode == 13)      
        {  
            $(".Paper-search-btn").trigger("click");
            return false;
        }  
        
    });

    /*给搜索按钮绑定相关的点击事件*/
    $("body").delegate(".Paper-search-btn","click",function(){
        //搜索下拉框
        var paper_select = $(".Paper-select");
        var $paper_search_type = paper_select.find("Option:selected").text();
       
        //搜索栏
        var paper_search = $(".Paper-search");
        var $paper_search_words = paper_search.val();
        
        if($paper_search_type == "标题"){
            getMsgByTitle($paper_search_words);
        }else if($paper_search_type == "作者"){
            getMsgByAuthor($paper_search_words);
        }

    });

    /*--------------函数部分----------- */
    /*根据作者进行查*/
    function getMsgByAuthor(author){
        deleteAllPaperCardsAndTabs();
        //查询限制
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/paper",
            data: {
                "author": author,
                "limitStart": limit_l,
                "limitEnd": limit_r
            },
            success: function(msg) {
                console.log("网络状况良好！");
                var obj = eval(msg);
                useMsgCreatePaperCard(obj);
            },
            error:function(xhr){
                alert("网络情况不良！");
            }
        });
    }

    /*根据标题进行查找*/
    function getMsgByTitle(title){
        deleteAllPaperCardsAndTabs();

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/paper",
            data: {
                "title": title,
                "limitStart": limit_l,
                "limitEnd": limit_r
            },
            success: function(msg) {
                console.log("网络状况良好！");
                var obj = eval(msg);
                useMsgCreatePaperCard(obj);
            },
            error:function(xhr){
                alert("网络情况不良！");
            }
        });
    }


    /*根据请求服务器返回的信息创建card*/
    function getMsgByTagAndDate(tag,date){
        /*先清除paper cards */
        deleteAllPaperCards();
        
        tag = tagExchange(tag);

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/paper",
            data: {
                "tag": tag,
                "date": date,
                "limitStart": limit_l,
                "limitEnd": limit_r
            },
            success: function(msg) {
                console.log("网络状况良好！");
                var obj = eval(msg);

                useMsgCreatePaperCard(obj);
            },
            error:function(xhr){
                alert("网络情况不良！");
            }
        });
    }


    function useMsgCreatePaperCard(obj){  
        // console.log(obj["message"]);
        // if(obj["message"] == "数据获取失败"){
        //     alert("数据获取失败!");
        //     return false;
        // }

        $.each(obj["paper"],function(index,paper_info){
            var paper = paper_info["paper"];

            var author_str = "";
            $.each(paper_info["author"],function(index,name){
                author_str += name["name"]+",";
            });
            author_str=(author_str.substring(author_str.length-1)==',')?author_str.substring(0,author_str.length-1):author_str;
            var paper_id = ""+paper["id"];
            paper_id = paper_id.replace(/[\ |\~|\`|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\-|\_|\+|\=|\||\\|\[|\]|\{|\}|\;|\:|\"|\'|\,|\<|\.|\>|\/|\?]/g,""); 

            var paper_date = paper["date"].split(" ");
            var paper_date_arr = paper_date[0].split("-");
            var paper_date_str = parseInt(paper_date_arr[0])+"年"+parseInt(paper_date_arr[1])+"月"+parseInt(paper_date_arr[2])+"日";

            var $paper_card = createElem({
                date: paper_date_str,
                title: paper.title,
                url: paper.pdf_url,
                authors: author_str,
                paper_id: paper_id,
                abstract: paper.abstract_content,
                tags: paper_info["tag"]
            });
            
            $("#PaperList-content").append($paper_card);
        });
    }


    function deleteAllPaperCardsAndTabs(){
        $(".PaperList-header").empty();
        deleteAllPaperCards();
    }

    /*清空所有PaperCard*/
    function deleteAllPaperCards(){
        $("#PaperList-content").empty();
    }

    function createElem(obj){
        /*url:pdf的链接地址 */
        var $paper_card = $("<div class=\"PaperCard thumbnail\" id=\"PaperCard\">"+
            "<div class=\"PaperCard-time\">"+obj.date+"</div>"+
            "<div class=\"PaperCard-title\">"+
            "    <a target=\"_blank\" href="+obj.url+">"+obj.title+"</a>"+
            "</div>"+
            "<div class=\"PaperCard-author\">"+
            "    <span>"+obj.authors+"</span>"+
            "</div>"+
            "<div class=\"PaperCard-abstract\">"+
            "    <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"collapse\" data-target=#"+obj.paper_id+">"+
            "        Abstract"+
            "        <span class=\"caret\"></span>"+
            "    </button>"+
            "    <div class=\"PaperCard-tags-arr\">"+
            "    </div>"+
            "    <div id="+obj.paper_id+" class=\"collapse in\">"+
            "        "+obj.abstract+
            "    </div>"+
            "</div>"+
        "</div>");

    // <button id=\"Paper-tag\" class=\"btn btn-primary\" type=\"submit\">CV</button>
    var tags_arr=$paper_card.find(".PaperCard-tags-arr");

    $.each(obj.tags,function(index,tag){
        var tag_str = tagExchange(tag["name"]);
        if(tag_str != ""){
            var $tag = $("<button id=\"Paper-tag\" class=\"btn btn-primary\" type=\"submit\">"+tag_str+"</button>");
            $tag.css("color",tagExchangeColor(tag_str));
            tags_arr.append($tag);
        }
    });
    return $paper_card;
    }

    function tagExchangeColor(tag){
        var color = "#fff";
        switch(tag){
            case "CV":
                color = "#f93";
                break;
            case "NLP":
                color = "#56aff4";
                break;
            case "ML":
                color = "#72af2f";
                break;
            case "AI":
                color = "#F4606C";
                break;
            case "NE":
                color = "#D1BA74";
                break;
        }
        return color;
    }

    /*标签替换*/
    function tagExchange(tag){
        var newtag="";
        switch(tag){
            case "cs.CV": 
                newtag = "CV";
                break;
            case "cs.CL":
                newtag = "NLP";
                break;
            case "cs.LG":
                newtag = "ML";
                break;
            case "cs.AI":
                newtag = "AI";
                break;
            case "cs.NE":
                newtag = "NE";
                break;
            case "CV":
                newtag = "cs.CV";
                break;
            case "NLP":
                newtag = "cs.CL";
                break;
            case "ML":
                newtag = "cs.LG";
                break;
            case "AI":
                newtag = "cs.AI";
                break;
            case "NE":
                newtag = "cs.NE";
                break;
            case "CV":
                newtag = "cs.CV";
                break;
        }
        return newtag;
    }


    /*-----------------*/

});