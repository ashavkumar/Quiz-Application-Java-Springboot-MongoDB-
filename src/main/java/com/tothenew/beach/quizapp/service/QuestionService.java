package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.exception.NoQuestionFoundException;
import com.tothenew.beach.quizapp.model.Question;

import java.util.List;

public interface QuestionService {

    public Question raiseQuestion(Question question);

    public Question getQuestionById(String qid) throws NoQuestionFoundException;

    public List<Question> searchByCategory(String category);

    public List<Question> findRandomQuestionByCategory(String category, int numQ);

    public List<Question> getAllQuestions();

    public void deleteQuestionById(String quesId);
}