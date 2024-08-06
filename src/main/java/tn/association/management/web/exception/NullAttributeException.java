package tn.association.management.web.exception;

public class NullAttributeException extends RuntimeException {
    public NullAttributeException(String message) {
        super("The " + message + " must be not null");
    }
}