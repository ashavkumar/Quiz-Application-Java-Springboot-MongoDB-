package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.model.Quiz;

public interface QuizService {
    public Quiz createQuiz(String category, int numQ, String title);
}
