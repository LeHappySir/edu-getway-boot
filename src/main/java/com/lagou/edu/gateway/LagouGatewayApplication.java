package com.lagou.edu.gateway;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * LagouGatewayApplication
 *
 * @author xianhongle
 * @data 2022/1/9 10:40 下午
 **/
@SpringBootApplication(scanBasePackages = "com.lagou.edu",exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lagou.edu")
@EnableMethodCache(basePackages = "com.lagou.edu")
@EnableCreateCacheAnnotation
public class LagouGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagouGatewayApplication.class, args);
    }

}
