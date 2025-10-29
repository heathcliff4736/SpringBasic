package com.ssg.springwebmvc.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//스프링 컨트롤러에서 발생하는 예외를 처리하는 일반적인 방식
@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptNumber(NumberFormatException numberFormatException) {
        log.error("numberFormatException", numberFormatException.getMessage());
        return "Number Format Exception";
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }

}
