package com.empresa.porhacer.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PorHacerExceptions extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public PorHacerExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
