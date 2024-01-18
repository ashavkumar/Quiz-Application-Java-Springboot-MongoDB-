package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.model.Question;
import com.tothenew.beach.quizapp.model.Quiz;
import com.tothenew.beach.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz createQuiz(String category, int numQ, String title) {
        List<Question> questionList = questionService.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        return quizRepository.save(quiz);
    }
}
