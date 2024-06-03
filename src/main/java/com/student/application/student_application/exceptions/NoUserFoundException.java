package com.student.application.student_application.exceptions;

import java.util.function.Supplier;

public class NoUserFoundException extends RuntimeException {

    public NoUserFoundException() {
    }

    public NoUserFoundException(String message) {
        super(message);
    }

    public NoUserFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserFoundException(Throwable cause) {
        super(cause);
    }

    public NoUserFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
