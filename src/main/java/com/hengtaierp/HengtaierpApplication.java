package com.hengtaierp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.hengtaierp.mapper")
@SpringBootApplication
public class HengtaierpApplication {

	public static void main(String[] args) {
		SpringApplication.run(HengtaierpApplication.class, args);
	}

}
