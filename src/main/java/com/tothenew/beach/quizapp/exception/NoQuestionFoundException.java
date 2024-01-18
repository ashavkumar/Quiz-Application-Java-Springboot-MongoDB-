package com.tothenew.beach.quizapp.exception;

public class NoQuestionFoundException extends Exception {
    public NoQuestionFoundException() {
        super();
    }

    public NoQuestionFoundException(String message) {
        super(message);
    }

    public NoQuestionFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoQuestionFoundException(Throwable cause) {
        super(cause);
    }

    protected NoQuestionFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
