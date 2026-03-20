package com.edutech.progressive.exception;

public class SupplierAlreadyExistsException extends RuntimeException {
<<<<<<< HEAD
    public SupplierAlreadyExistsException(String message) {
        super(message);
    }
=======
    public SupplierAlreadyExistsException() {
        super();
    }
    public SupplierAlreadyExistsException(String message) {
        super(message);
    }
    public SupplierAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
    public SupplierAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}