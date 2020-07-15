package com.changgou.service.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.service.goods.dao"})
public class ServiceGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceGoodsApplication.class);
    }
}
