package com.topdoc.exercise.authenticationapp.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author TAYYAB
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserException extends Exception {

    private int code;
    private String message;

    public UserException() {
        super();
    }

    public UserException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
