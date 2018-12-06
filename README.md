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

