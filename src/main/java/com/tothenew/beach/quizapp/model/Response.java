package com.tothenew.beach.quizapp.model;

public class Response {

    private int id;
    private String responses;

    public Response() {
    }

    public Response(int id, String responses) {
        this.id = id;
        this.responses = responses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponses() {
        return responses;
    }

    public void setResponses(String responses) {
        this.responses = responses;
    }
}
