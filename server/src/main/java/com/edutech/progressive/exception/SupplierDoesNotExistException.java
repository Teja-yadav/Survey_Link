package com.edutech.progressive.exception;

public class SupplierDoesNotExistException extends RuntimeException {
<<<<<<< HEAD
    public SupplierDoesNotExistException(String message) {
        super(message);
    }
=======
    public SupplierDoesNotExistException() {
        super();
    }
    public SupplierDoesNotExistException(String message) {
        super(message);
    }
    public SupplierDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public SupplierDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}