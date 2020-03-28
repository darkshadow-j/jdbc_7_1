package pl.pawel.jdbcfirst.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DBConfig {



        @Bean
        public DataSource getDataSource(){
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/pojazd");
            dataSourceBuilder.username("root");
            dataSourceBuilder.password("");
            dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
            return dataSourceBuilder.build();
        }

        @Bean
        public JdbcTemplate getJdbcTemplate(){
            return new JdbcTemplate(getDataSource());
        }




}
