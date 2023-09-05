package com.teaspoon.teamall.global.utll;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.spec.InvalidParameterSpecException;
import java.util.InputMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeException(RuntimeException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleNullPointerException(NullPointerException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalNumberFormatException(NumberFormatException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }
    @ExceptionHandler(InvalidParameterSpecException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidParameterSpecException(InvalidParameterSpecException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIBindException(BindException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }

    @ExceptionHandler(InputMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInputMismatchException(InputMismatchException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "/common/inputFailed";
    }
}
