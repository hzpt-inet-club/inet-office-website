package com.example.inetofficewebsite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(value = "com.example.inetofficewebsite.mapper")
public class InetOfficeWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(InetOfficeWebsiteApplication.class, args);
    }

}
