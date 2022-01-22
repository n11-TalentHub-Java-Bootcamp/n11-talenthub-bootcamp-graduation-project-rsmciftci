package com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TurkishIdentityNumberNot11CharactersException extends RuntimeException{
    public TurkishIdentityNumberNot11CharactersException(String message) {
        super(message);
    }
}
