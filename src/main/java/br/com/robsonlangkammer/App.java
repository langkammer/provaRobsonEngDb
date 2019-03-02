package br.com.robsonlangkammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@SpringBootApplication
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


//    @Bean
//    public DataSource dataSource(){
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("driverClassName"));
//        dataSource.setUrl(env.getProperty("url"));
//        dataSource.setUsername(env.getProperty("user"));
//        dataSource.setPassword(env.getProperty("password"));
//        return dataSource;
//    }

}
