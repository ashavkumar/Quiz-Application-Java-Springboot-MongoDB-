package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.exception.NoQuestionFoundException;
import com.tothenew.beach.quizapp.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl2 implements QuestionService {
    @Override
    public Question raiseQuestion(Question question) {
        return null;
    }

    @Override
    public Question getQuestionById(String qid) throws NoQuestionFoundException {
        return null;
    }

    @Override
    public List<Question> searchByCategory(String category) {
        return null;
    }

    @Override
    public List<Question> findRandomQuestionByCategory(String category, int numQ) {
        return null;
    }

    @Override
    public List<Question> getAllQuestions() {
        return null;
    }
}
