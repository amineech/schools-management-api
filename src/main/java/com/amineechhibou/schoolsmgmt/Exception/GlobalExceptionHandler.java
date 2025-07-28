package com.amineechhibou.schoolsmgmt.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<?> handlingMethodArgumentNotValidException(MethodArgumentNotValidException excep) {
        var errors = new HashMap<String, String>();
        excep.getBindingResult().getAllErrors().forEach(error -> {
            var fieldError = ((FieldError)error).getField();
            var message = error.getDefaultMessage();  
            errors.put(fieldError, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    } 
    
}
