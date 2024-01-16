package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.model.Question;

import java.util.List;

public interface QuestionService {

    public Question raiseQuestion(Question question);

    public Question getQuestion(String qid);

    public List<Question> searchByCategory(String category);

    public List<Question> getAllQuestions();
}