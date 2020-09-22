package com.hkq.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huangkaiqiang
 * @version 1.0
 * @description
 * @date 2020/9/10 14:32
 */
@SpringBootApplication
@MapperScan("com.hkq.mybatisplus.mapper")
public class TestApp {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class,args);
    }
}
