package com.pkr.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.spring.dto.request.QuestionRequestDto;
import com.pkr.spring.model.Question;
import com.pkr.spring.service.QuestionService;

@RestController
@RequestMapping("/quiz/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody QuestionRequestDto question){
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable Long id){
		return questionService.getQuestionById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateQuestion(@RequestBody QuestionRequestDto question){
		return questionService.updateQuestion(question);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteQuestion(@RequestBody QuestionRequestDto id){
		return questionService.deleteQuestion(id);
	}

}
