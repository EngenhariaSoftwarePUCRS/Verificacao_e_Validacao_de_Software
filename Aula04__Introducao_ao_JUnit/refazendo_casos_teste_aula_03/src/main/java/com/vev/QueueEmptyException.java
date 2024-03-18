package com.vev;

public class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        super("Queue is empty");
    }    
}
