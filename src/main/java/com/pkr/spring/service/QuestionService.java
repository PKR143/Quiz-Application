package com.pkr.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pkr.spring.dto.request.QuestionRequestDto;
import com.pkr.spring.model.Question;

@Service
public interface QuestionService {
		public ResponseEntity<String> addQuestion(QuestionRequestDto question);
		public ResponseEntity<List<Question>> getAllQuestions();
		public ResponseEntity<Question> getQuestionById(Long id);
		public ResponseEntity<String> updateQuestion(QuestionRequestDto question);
		public ResponseEntity<String> deleteQuestion(QuestionRequestDto id);
}
