package com.edutech.progressive.exception;

<<<<<<< HEAD
public class InsufficientCapacityException extends RuntimeException{
    public InsufficientCapacityException(String message) {
        super(message);
    }
=======
public class InsufficientCapacityException extends RuntimeException {
    public InsufficientCapacityException() {
        super();
    }
    public InsufficientCapacityException(String message) {
        super(message);
    }
    public InsufficientCapacityException(String message, Throwable cause) {
        super(message, cause);
    }
    public InsufficientCapacityException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}