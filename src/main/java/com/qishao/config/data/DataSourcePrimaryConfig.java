package com.qishao.config.data;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 第一数据源
 *
 * @author liuzixi
 * date 2019/11/19
 */
@Configuration
@MapperScan(basePackages = "com.qishao.api.dao.primary", sqlSessionFactoryRef = "primarySqlSessionFactory")
@Slf4j
public class DataSourcePrimaryConfig {

    /**
     * 第一数据源配置
     */
    @Value("${mybatis.primary.mapper-locations}")
    private String primaryMapperLocationStr;

    /**
     * 第一数据源对象
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public HikariDataSource primaryDataSource() {
        return new HikariDataSource();
    }

    /**
     * SqlSessionFactory
     * 对应第一数据源
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(primaryMapperLocationStr));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SqlSessionTemplate
     * 对应第一数据源
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        log.info("primary数据源配置完成");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
