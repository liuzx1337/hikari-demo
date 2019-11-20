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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 第二数据源
 *
 * @author liuzixi
 * date 2019/11/19
 */
@Configuration
@MapperScan(basePackages = "com.qishao.api.dao.secondary", sqlSessionTemplateRef = "secondarySqlSessionTemplate")
@Slf4j
public class DataSourceSecondaryConfig {

    /**
     * 第二数据源配置
     */
    @Value("${mybatis.secondary.mapper-locations}")
    private String secondaryMapperLocationStr;

    /**
     * 第二数据源对象
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public HikariDataSource secondaryDataSource() {
        return new HikariDataSource();
    }

    /**
     * SqlSessionFactory
     * 对应第二数据源
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(secondaryMapperLocationStr));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 事务管理
     * 对应第二数据源
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * SqlSessionTemplate
     * 对应第二数据源
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate secondarySqlSessionTemplate(@Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        log.info("secondary数据源配置完成");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
