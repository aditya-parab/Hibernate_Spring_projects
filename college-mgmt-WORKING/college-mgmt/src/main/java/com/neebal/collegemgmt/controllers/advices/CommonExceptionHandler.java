package com.neebal.collegemgmt.controllers.advices;


import com.neebal.collegemgmt.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFound(ResourceNotFoundException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handelMethodArgumentNotValidException(
            MethodArgumentNotValidException ex){
        HashMap<String,String> map = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(objectError ->{
                    String f = ((FieldError)objectError).getField();
                    String m = objectError.getDefaultMessage();
                    map.put(f,m);
                });
        return map;
    }
}
