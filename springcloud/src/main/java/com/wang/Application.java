package com.wang;

import org.mybatis.spring.annotation.MapperScan;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
 
@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.wang.dao")//扫描
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//服务发现
//添加对熔断支持
@EnableCircuitBreaker
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ServletRegistrationBean hystrixMetricsStreamServlet(){
		ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new HystrixMetricsStreamServlet());
	
		servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
		return  servletRegistrationBean;
	}

}
