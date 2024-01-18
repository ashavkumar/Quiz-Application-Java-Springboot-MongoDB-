package com.tothenew.beach.quizapp.controller;

import com.tothenew.beach.quizapp.exception.NoQuestionFoundException;
import com.tothenew.beach.quizapp.model.Question;
import com.tothenew.beach.quizapp.service.QuestionService;
import com.tothenew.beach.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "question")
public class QuestionController {

    @Autowired
    //@Qualifier("questionServiceImpl2")
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping(value = "/raiseQuestion")
    public ResponseEntity<?> raiseQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.raiseQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{qid}")
    public ResponseEntity<?> getQuestionById(@PathVariable String qid) throws NoQuestionFoundException {
        return new ResponseEntity<>(questionService.getQuestionById(qid), HttpStatus.OK);
    }

    @GetMapping(value = "/category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category) {
        return new ResponseEntity<>(questionService.searchByCategory(category), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/allQuestions")
    public ResponseEntity<?> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping(value = "/createQuiz")
    public ResponseEntity<?> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.CREATED);
    }

}
