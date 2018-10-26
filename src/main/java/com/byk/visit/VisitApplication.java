package com.byk.visit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.byk.visit.boke.mapper")
@ServletComponentScan
@EnableScheduling    //定时器
public class VisitApplication {


	// extends SpringBootServletInitializer
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		// 注意这里要指向原先用main方法执行的Application启动类
//		return builder.sources(MybokeApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(VisitApplication.class, args);
	}
}
