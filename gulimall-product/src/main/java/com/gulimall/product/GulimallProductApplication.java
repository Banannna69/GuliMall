package com.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1。整合mybatis-plus
 		1)导入依赖
         1)import com.
 	    2)配置
 			配置数据源
 		3)配置mybatis-plus
 			使用@MapperScan
 			告诉Mybatis-plus

 *2。整合
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
