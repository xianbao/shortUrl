# shortUrl
transform long url to short url
项目实现两个功能，将长地址转换为短地址，并将其存储在数据库；传入短地址重定向到长地址。
1、长地址使用md5值计算方法计算短地址，可以传入key作为盐值
2、进行短链的跳转时，查询数据库与之匹配的长链，然后重定向到长链的地址
