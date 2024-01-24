package com.tothenew.beach.quizapp.controller;

import com.tothenew.beach.quizapp.model.QuestionWrapper;
import com.tothenew.beach.quizapp.model.Response;
import com.tothenew.beach.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping(value = "quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping(value = "/createQuiz")
    public ResponseEntity<?> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.CREATED);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable String id) {
        return new ResponseEntity<>(quizService.getQuizQuestion(id), HttpStatus.OK);
    }

    @PostMapping(value = "/submit/{quizId}")
    public ResponseEntity submitQuiz(@PathVariable String quizId, @RequestBody List<Response> responseList) {
        return new ResponseEntity<>(quizService.calculateResult(quizId, responseList), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{quizId}")
    public ResponseEntity<?> deleteQuizById(@PathVariable String quizId) {
        quizService.deleteQuizById(quizId);
        return new ResponseEntity<>("Quiz deleted successfully", HttpStatus.OK);
    }
}
