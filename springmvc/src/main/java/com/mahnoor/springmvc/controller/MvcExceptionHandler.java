package com.mahnoor.springmvc.controller;

import org.hibernate.StaleObjectStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> handleException(ConstraintViolationException e){
        ArrayList<String> errors=new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleException(BindException b){
        ArrayList<String> errors=new ArrayList<>();
        b.getAllErrors().forEach(bindingException->{
            errors.add(bindingException.getObjectName() +" : "+ bindingException.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(StaleObjectStateException.class)
    public ResponseEntity<String> handleException(StaleObjectStateException staleObjectStateException){



        return new ResponseEntity<>(staleObjectStateException.getEntityName()+":"+staleObjectStateException.getMessage(), HttpStatus.BAD_REQUEST);

    }



}
