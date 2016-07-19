package com.runrong.creditscore.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class DbConfig {

    public static String jdbcUrl;
    public static String userName;
    public static String password;
    public static String driverClass;
    public static int maxActive = 50;

    public static void init() throws IOException {
        InputStream in;
        File file = new File("./config/db.properties");
        if(file.exists()){

            in = new FileInputStream(file);
        }else {
            in = DbConfig.class.getClassLoader().getResourceAsStream("config/db.properties");
        }

        Properties properties = new Properties();
        properties.load(in);
        in.close();


        jdbcUrl = properties.getProperty("url");
        userName = properties.getProperty("username");
        password = properties.getProperty("password");
        driverClass = properties.getProperty("driverClass");
        if(properties.getProperty("maxActive") != null){
            maxActive = Integer.parseInt( properties.getProperty("maxActive") );
        }



//        jdbcUrl2 = properties.getProperty("url2");
//        userName2 = properties.getProperty("username2");
//        password2 = properties.getProperty("password2");
//        driverClass2 = properties.getProperty("driverClass2");
    }
    
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(DbConfig.driverClass);
        dataSource.setUrl(DbConfig.jdbcUrl);
        dataSource.setUsername(DbConfig.userName);
        dataSource.setPassword(DbConfig.password);
        dataSource.setMaxActive(DbConfig.maxActive);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return namedParameterJdbcTemplate;
    }
    
    @Bean
    public ServletRegistrationBean druidStatRegistration(){
        HttpServlet servlet = new StatViewServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
        registration.addUrlMappings("/druid/*");
        registration.addInitParameter("loginUsername","admin");
        registration.addInitParameter("loginPassword","12345");
        //registration.addInitParameter("allow","192.168.0.1/16");
        return registration;
    }

}
