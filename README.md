# hikari-demo

- 采用Spring Boot 2.2的默认连接池Hikari，也可换成Druid等其他类型连接池
- 配置双数据源，可在此基础上扩展读写分离

### 注意事项

- 多数据源的@MapperScan注解，需要分别对应各自的SqlSessionTemplate
- Primary的DataSource可依赖druid-starter（不手写），但其他数据源的各项配置和Bean一定要注意名称区分