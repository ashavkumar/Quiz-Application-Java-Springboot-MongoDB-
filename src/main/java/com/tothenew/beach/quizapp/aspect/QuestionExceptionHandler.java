package com.tothenew.beach.quizapp.aspect;

import com.tothenew.beach.quizapp.exception.CustomResponse;
import com.tothenew.beach.quizapp.exception.NoQuestionFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuestionExceptionHandler {

    @ExceptionHandler(NoQuestionFoundException.class)
    public ResponseEntity<CustomResponse> handleRequestAlreadySentException(Exception e) {
        CustomResponse response = new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Question found.");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
