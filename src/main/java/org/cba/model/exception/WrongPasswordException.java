package org.cba.model.exception;

/**
 * Created by adam on 28/02/2017.
 */
public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
