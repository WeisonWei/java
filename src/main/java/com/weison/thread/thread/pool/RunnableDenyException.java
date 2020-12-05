package com.weison.thread.thread.pool;

public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message) {
        super(message);
    }
}
