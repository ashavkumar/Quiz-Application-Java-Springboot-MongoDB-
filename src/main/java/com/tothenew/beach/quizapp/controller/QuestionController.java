package com.tothenew.beach.quizapp.controller;

import com.tothenew.beach.quizapp.model.Question;
import com.tothenew.beach.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "/raiseQuestion")
    public ResponseEntity<?> raiseQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.raiseQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{qid}")
    public ResponseEntity<?> getQuestion(@PathVariable String qid) {
        return new ResponseEntity<>(questionService.getQuestion(qid), HttpStatus.OK);
    }

    @GetMapping(value = "/category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category) {
        return new ResponseEntity<>(questionService.searchByCategory(category), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/allQuestions")
    public ResponseEntity<?> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

}
