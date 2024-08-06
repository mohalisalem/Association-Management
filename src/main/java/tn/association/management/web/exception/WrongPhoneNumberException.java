package tn.association.management.web.exception;

public class WrongPhoneNumberException extends RuntimeException {
    public WrongPhoneNumberException() {
        super(" The phone Number must contains only numbers.");
    }
}
