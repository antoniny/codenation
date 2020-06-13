package com.challenge.endpoints.adivice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponseDto handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(fieldName +" -> "+ errorMessage);
        });


        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(ex.getLocalizedMessage(), errors);

        return exceptionResponseDto;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception ex) {
        return "Internal Server Error: " + ex.getMessage();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponseDto handleResourceNotFoundException(ResourceNotFoundException ex) {


        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(ex.getLocalizedMessage(), "Not Found");

        return exceptionResponseDto;
    }


}
