package com.tothenew.beach.quizapp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "CreateQuiz")
public class Quiz {
    @MongoId(FieldType.OBJECT_ID)
    private String quizId;
    private String title;
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(String quizId, String title, List<Question> questionList) {
        this.quizId = quizId;
        this.title = title;
        this.questionList = questionList;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id='" + quizId + '\'' +
                ", title='" + title + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
