package com.olgaruban.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

@ControllerAdvice
public class ExceptionHandlerController extends DefaultHandlerExceptionResolver {

    @ExceptionHandler
    void handlePatternSyntaxException(PatternSyntaxException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(400, "Invalid format for regular expression: " + e.getMessage());
    }

}
