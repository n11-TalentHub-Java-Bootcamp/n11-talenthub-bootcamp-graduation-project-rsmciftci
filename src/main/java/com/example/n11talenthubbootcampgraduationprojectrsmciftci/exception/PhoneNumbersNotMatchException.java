package com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PhoneNumbersNotMatchException extends RuntimeException {
    public PhoneNumbersNotMatchException(String message) {
        super(message);
    }
}