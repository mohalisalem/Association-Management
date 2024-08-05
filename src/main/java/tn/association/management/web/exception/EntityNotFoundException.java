package tn.association.management.web.exception;

public class EntityNotFoundException extends RuntimeException {

    public final String message;

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}