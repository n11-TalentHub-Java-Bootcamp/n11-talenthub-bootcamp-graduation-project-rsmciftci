package com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);


        com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse exceptionResponse =
                new com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse(errorDate, message, description);
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(ProductNotFoundException ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse exceptionResponse =
                new com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(TurkishIdentityNumberNot11CharactersException ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse exceptionResponse =
                new com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(SalaryNotMatchException ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse exceptionResponse =
                new com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.CONFLICT);
    }


}
