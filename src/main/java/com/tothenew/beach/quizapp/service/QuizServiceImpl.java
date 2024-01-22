package com.tothenew.beach.quizapp.service;

import com.tothenew.beach.quizapp.model.Question;
import com.tothenew.beach.quizapp.model.QuestionWrapper;
import com.tothenew.beach.quizapp.model.Quiz;
import com.tothenew.beach.quizapp.model.Response;
import com.tothenew.beach.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz createQuiz(String category, int numQ, String title) {
        List<Question> questionList = questionService.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        return quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuizQuestion(String quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        List<Question> questionList = quiz.get().getQuestionList();
        List<QuestionWrapper> questionWrapperList = new ArrayList<>();
        for (Question question : questionList) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionWrapperList.add(questionWrapper);
        }
        return questionWrapperList;
    }

    @Override
    public int calculateResult(String quizId, List<Response> responseList) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        List<Question> questionList = quiz.get().getQuestionList();
        int right = 0;
        int i = 0;
        for (Response response : responseList) {
            if (response.getResponses().equals(questionList.get(i).getRightAnswer())) {
                right++;
            }
            i++;
        }
        return right;
    }

    public void deleteQuizById(String quizId) {
        quizRepository.deleteById(quizId);
    }

}
