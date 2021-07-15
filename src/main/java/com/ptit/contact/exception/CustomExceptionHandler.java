package com.ptit.contact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse hanlderNotFoundException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse hanlderLoginFailedException(LoginFailedException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse hanlderAccountAlreadyExistException(AccountAlreadyExistsException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleValidationExceptions(MethodArgumentNotValidException ex)
    {
        Map<String,Object> map = new HashMap<>();
        Map<String,String> errors = new HashMap<>();
        ex.getAllErrors().forEach(x->{
            String fieldName = ((FieldError) x).getField();
            String errorMessage = x.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        map.put("message",errors);
        return map;
    }
}
