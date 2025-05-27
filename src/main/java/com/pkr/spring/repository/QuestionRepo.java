package com.pkr.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkr.spring.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long>{

}
