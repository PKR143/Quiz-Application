package com.pkr.spring.dto.request;


import lombok.Getter;

@Getter
public class QuestionRequestDto{
	private Long id;
	private String difficultyLevel;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
}
