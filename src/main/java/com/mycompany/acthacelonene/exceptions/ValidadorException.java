package com.mycompany.acthacelonene.exceptions;


public class ValidadorException extends AppException {
    
    public ValidadorException( String message ) {
        super (message);
    }
    
    public ValidadorException( String message, Throwable cause ) {
        super(message, cause);
    }
}
