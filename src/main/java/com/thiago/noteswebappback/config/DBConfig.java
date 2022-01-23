package com.thiago.noteswebappback.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.thiago.noteswebappback.mapper"})
public class DBConfig {


    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.postgresql")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

