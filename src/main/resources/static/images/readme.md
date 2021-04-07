把静态资源放到该文件夹下：resources/static  


对应的访问地址为：localhost:8080/fimename.filetype



Spring boot默认对/**的访问可以直接访问四个目录下的文件（默认配置，无需再进行配置）: 

- classpath:/public/
- classpath:/resources/
- classpath:/static/
- classpath:/META-INFO/resouces/