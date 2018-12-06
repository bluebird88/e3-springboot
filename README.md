### 项目说明
这是个著名的spring-boot 和电商项目 demo
我fork它，并完成搭建，截至当前，功能基本可用：
- 主站：http://116.62.17.124:8082/   -- 登录信息存在问题
- 管理平台 ：http://116.62.17.124:8081  -- ok
- 搜索 http://116.62.17.124:8083      -- ok
- 商品详情 http://116.62.17.124:8084    -- ok
- sso http://116.62.17.124:8085/page/login /register  -- 登录存在问题，cookie未写入！见后续说明

- order http://116.62.17.124:8087   -- 登录存在问题
- order http://116.62.17.124:8087   -- 同上

- 图片服务器：http://116.62.16.229:8080/group1/M00/00/00/rBB9KFwGiSGABGuIAAU2HQnqFrw516.jpg  -- ok

已知问题中，主要是登录问题：
- 登录后，cookie未写入，简单看是cookie写入依赖于domain name，而开发环境没有配置domain，而是采用ip+端口的形式进行module的区分
- 解决方案：nginx+proxy方式，本地修改hosts，fake一个域名，该方案待测试

另外，activemq触发的页面静态化未测试，需要进一步测试，这也依赖于nginx



----
#### fake domain name :
8082: www.e3mall.com
8083: search.e3mall.com
8084: detail.e3mall.com
8085: sso.e3mall.com
8086: cart.e3mall.com
8087: order.e3mall.com


*** 结果 ***：
- 经过上述改造后，经验证登录可以工作，由于cookie导致的问题已经修复。
- 相关nginx 虚拟主机定义文件如下： $root/nginx/conf.d/e3mall.conf
```
## main server for e3mall ...
server {
        listen       8888;
        server_name *.e3mall.com;

        if ($host ~* "^(.*?)\.e3mall\.com$") {    #正则表达式
                set $domain $1;                     #设置变量
        }


        location / {
            if ($domain ~* "www") {
               proxy_pass http://localhost:8082;      #域名中有shop，转发到3001端口
            }
            if ($domain ~* "search") {
               proxy_pass http://localhost:8083;      #域名中有mail，转发到3002端口
            }

            if ($domain ~* "detail") {
               proxy_pass http://localhost:8084;      #域名中有mail，转发到3002端口
            }
            if ($domain ~* "sso") {
               proxy_pass http://localhost:8085;      #域名中有mail，转发到3002端口
            }
            if ($domain ~* "cart") {
               proxy_pass http://localhost:8086;      #域名中有mail，转发到3002端口
            }
            if ($domain ~* "order") {
               proxy_pass http://localhost:8087;      #域名中有mail，转发到3002端口
            }
            tcp_nodelay     on;
            proxy_set_header Host            $host;
            proxy_set_header X-Real-IP       $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
##            root   /var/www/e3mall/staticfiles;
            index  index.php index.html index.htm;
 ##           charset utf-8;
        }
        access_log  usr/local/var/log/www.access.log  main;
        access_log  usr/local/var/log/www.error.log  main;
}

```

-为了便于调试，本地定义的域名关系如下（/etc/hosts):
```$xslt

116.62.17.124 e3mall.com

116.62.17.124 www.e3mall.com
116.62.17.124 search.e3mall.com
116.62.17.124 detail.e3mall.com
116.62.17.124 sso.e3mall.com
116.62.17.124 order.e3mall.com
116.62.17.124 cart.e3mall.com
```
