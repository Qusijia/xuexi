package com.bookmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com"})  //swagger扫描基类包
@MapperScan("com.bookmanage.mapper")
public class BookmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanageApplication.class, args);
    }

}
