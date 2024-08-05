package tn.association.management.web.exception;

public class EntityAlreadyExistsException extends RuntimeException {

    public final String message;

    public EntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

}
