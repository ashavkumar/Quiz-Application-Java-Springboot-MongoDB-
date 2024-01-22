package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.model.QuestionWrapper;
import com.tothenew.beach.quizapp.model.Quiz;
import com.tothenew.beach.quizapp.model.Response;

import java.util.List;

public interface QuizService {
    public Quiz createQuiz(String category, int numQ, String title);

    public List<QuestionWrapper> getQuizQuestion(String quizId);

    public int calculateResult(String quizId, List<Response> responseList);

    public void deleteQuizById(String quizId);
}
