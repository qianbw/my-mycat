/**
 * (C) 2014-2016 Webank Group Holding Limited.
 * <p>
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 */
package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class ApplicationConfigurations {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfigurations.class);

    // JDBC相关
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${jdbc.initialSize}")
    private int jdbcInitialSize;

    @Value("${jdbc.minIdle}")
    private int jdbcMinIdle;

    @Value("${jdbc.maxActive}")
    private int jdbcMaxActive;

    @Value("${jdbc.maxWait}")
    private int jdbcMaxWait;

    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private long jdbcTimeBetweenEvictionRunsMillis;

    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private long jdbcMinEvictableIdleTimeMillis;

    @Value("${jdbc.validationQuery}")
    private String jdbcValidationQuery;

    @Value("${jdbc.validationQueryTimeout}")
    private int jdbcValidationQueryTimeout;

    @Value("${jdbc.testWhileIdle}")
    private boolean jdbcTestWhileIdle;

    @Value("${jdbc.testOnBorrow}")
    private boolean jdbcTestOnBorrow;

    @Value("${jdbc.testOnReturn}")
    private boolean jdbcTestOnReturn;

    @Value("${jdbc.preparedStatements}")
    private boolean jdbcPreparedStatements;

    @Value("${jdbc.maxPoolPreparedStatementPerConnectionSize}")
    private int jdbcMaxPoolPreparedStatementPerConnectionSize;

    @Value("${jdbc.filters}")
    private String jdbcFilters;

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() {
        try {
            DruidDataSource ds = new DruidDataSource();
            ds.setUrl(jdbcUrl);
            ds.setUsername(jdbcUsername);

            ResourceLoader resourceLoader = new DefaultResourceLoader();
            ds.setPassword(jdbcPassword);
            ds.setInitialSize(jdbcInitialSize);
            ds.setMinIdle(jdbcMinIdle);
            ds.setMaxActive(jdbcMaxActive);
            ds.setMaxWait(jdbcMaxWait);
            ds.setTimeBetweenEvictionRunsMillis(jdbcTimeBetweenEvictionRunsMillis);
            ds.setMinEvictableIdleTimeMillis(jdbcMinEvictableIdleTimeMillis);
            ds.setValidationQuery(jdbcValidationQuery);
            ds.setValidationQueryTimeout(jdbcValidationQueryTimeout);
            ds.setTestWhileIdle(jdbcTestWhileIdle);
            ds.setTestOnBorrow(jdbcTestOnBorrow);
            ds.setTestOnReturn(jdbcTestOnReturn);
            ds.setPoolPreparedStatements(jdbcPreparedStatements);
            ds.setMaxPoolPreparedStatementPerConnectionSize(jdbcMaxPoolPreparedStatementPerConnectionSize);
            ds.setFilters(jdbcFilters);

            return ds;
        } catch (Exception e) {
            LOGGER.error("", e);
            return null;
        }
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory() {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        factory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
        try {
            return factory.getObject();
        } catch (Exception e) {
            LOGGER.error("", e);
            return null;
        }
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
