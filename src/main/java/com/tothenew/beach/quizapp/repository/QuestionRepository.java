package com.tothenew.beach.quizapp.repository;

import com.tothenew.beach.quizapp.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
}
