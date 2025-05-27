package com.pkr.spring.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pkr.spring.dto.request.QuestionRequestDto;
import com.pkr.spring.model.Question;
import com.pkr.spring.repository.QuestionRepo;
import com.pkr.spring.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionRepo questionRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);
	
	@Override
	public ResponseEntity<String> addQuestion(QuestionRequestDto question){
		
		try {
			
			Question newQuestion = new Question();
			newQuestion.setDifficultyLevel(question.getDifficultyLevel());
			newQuestion.setQuestionTitle(question.getQuestionTitle());
			newQuestion.setAnswer(question.getAnswer());
			newQuestion.setOption1(question.getOption1());
			newQuestion.setOption2(question.getOption2());
			newQuestion.setOption3(question.getOption3());
			newQuestion.setOption4(question.getOption4());
			questionRepo.save(newQuestion);
			return new ResponseEntity<>("Question Added Successfully!", HttpStatus.CREATED);
		}catch(Exception e) {
			logger.error("error while adding question {}",e.getMessage());
			return null;
		}
	}
	@Override
	public ResponseEntity<List<Question>> getAllQuestions(){
		
		try {
			
			return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
			
		}catch(Exception e) {
			
			logger.error("error: {}",e.getMessage());
			return null;
		}
		
	}
	
	@Override
	public ResponseEntity<Question> getQuestionById(Long id) {
		
		try {
			return new ResponseEntity<>(questionRepo.findById(id).orElse(null),HttpStatus.FOUND);
		}catch(Exception e) {
			logger.error("Error: {} ",e.getMessage());
			return null;
		}
		
	}
	
	@Override
	public ResponseEntity<String> updateQuestion(QuestionRequestDto question){
		
		try {
			
			Optional<Question> oldQuestion = questionRepo.findById(question.getId());
			if(oldQuestion.isPresent()) {
				System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
				Question newQuestion = oldQuestion.get();
				newQuestion.setDifficultyLevel(question.getDifficultyLevel());
				newQuestion.setQuestionTitle(question.getQuestionTitle());
				newQuestion.setAnswer(question.getAnswer());
				newQuestion.setOption1(question.getOption1());
				newQuestion.setOption2(question.getOption2());
				newQuestion.setOption3(question.getOption3());
				newQuestion.setOption4(question.getOption4());
				questionRepo.save(newQuestion);
				return new ResponseEntity<>("updated successfully",HttpStatus.ACCEPTED);
			}
			else {
				return new ResponseEntity<>("Question not found!!!",HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			logger.error("Error while updating the question : {}",e.getMessage());
			return null;
		}
		
	}
	
	@Override
	public ResponseEntity<String> deleteQuestion(QuestionRequestDto question){
		
		try {
			Optional<Question> toDeleteQuestion = questionRepo.findById(question.getId());
			if(toDeleteQuestion.isPresent()) {
				questionRepo.delete(toDeleteQuestion.get());
				return new ResponseEntity<>("Question deleted Successfully",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Question not found",HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			logger.error("error found while deleting question {}",e.getMessage());
			return null;
		}
		
	}
	
}
