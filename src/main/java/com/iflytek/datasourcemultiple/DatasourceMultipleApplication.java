package com.iflytek.datasourcemultiple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.iflytek.datasourcemultiple.dao")
public class DatasourceMultipleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceMultipleApplication.class, args);
    }

}
