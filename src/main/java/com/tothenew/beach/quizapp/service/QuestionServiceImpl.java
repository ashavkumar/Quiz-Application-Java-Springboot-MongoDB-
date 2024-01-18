package com.tothenew.beach.quizapp.service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tothenew.beach.quizapp.exception.NoQuestionFoundException;
import com.tothenew.beach.quizapp.model.Question;
import com.tothenew.beach.quizapp.repository.QuestionRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Primary
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question raiseQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(String qid) throws NoQuestionFoundException {
        try {
            return questionRepository.findById(qid).get();
        } catch (Exception ex) {
            throw new NoQuestionFoundException();
        }
    }

    @Override
    public List<Question> searchByCategory(String category) {
        System.out.println("Category :" + category);
        final List<Question> questionList = new ArrayList<>();
        MongoDatabase database = client.getDatabase("ToTheNew");
        MongoCollection<Document> collection = database.getCollection("QuestionRaised");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", category).append("path", Arrays.asList("difficultLevel", "category", "questionTitle"))))));

        result.forEach(doc -> questionList.add(converter.read(Question.class, doc)));
        return questionList;
    }

    @Override
    public List<Question> findRandomQuestionByCategory(String category, int numQ) {
        final List<Question> questionList = new ArrayList<>();
        MongoDatabase database = client.getDatabase("ToTheNew");
        MongoCollection<Document> collection = database.getCollection("QuestionRaised");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", category).append("path", Arrays.asList("difficultLevel", "category", "questionTitle")))),
                new Document("$limit", numQ)));

        result.forEach(doc -> questionList.add(converter.read(Question.class, doc)));
        return questionList;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
