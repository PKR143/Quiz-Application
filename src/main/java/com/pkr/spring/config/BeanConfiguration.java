package com.pkr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pkr.spring.service.QuestionService;
import com.pkr.spring.serviceImpl.QuestionServiceImpl;

@Configuration
public class BeanConfiguration {
	
	@Bean
	QuestionService getQuestionService() {
		return new QuestionServiceImpl();
	}
	
}
