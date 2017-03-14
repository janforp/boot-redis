使用
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
之后，可以在项目中直接使用
 @Autowired
 private StringRedisTemplate template;

 默认使用本机的redis，若本地redis服务没有启动，则会报错
 如果需要指定redis主机，则需要配置文件