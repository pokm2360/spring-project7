package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 리스너 기능 활성화 시키기(이벤트를 감지)
@SpringBootApplication
public class Project7Application {

	public static void main(String[] args) {
		SpringApplication.run(Project7Application.class, args);
	}

}
