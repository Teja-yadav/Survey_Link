package com.edutech.progressive.exception;

public class NoWarehouseFoundForSupplierException extends RuntimeException {
<<<<<<< HEAD
    public NoWarehouseFoundForSupplierException(String message) {
        super(message);
    }
=======
    public NoWarehouseFoundForSupplierException() {
        super();
    }
    public NoWarehouseFoundForSupplierException(String message) {
        super(message);
    }
    public NoWarehouseFoundForSupplierException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoWarehouseFoundForSupplierException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}