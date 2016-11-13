package com.pantrychef.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * This class handle all exceptions on controllers translating to proper format for the APIs
 * pattern.
 *
 * @author Tiago Dolphine (tiago.dolphine@ifood.com.br)
 * @author Adriano Rodrigues (adriano.rodrigues@ifood.com.br)
 */
@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger logger = Logger.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handleBadParameter(Exception exception, HttpServletRequest request, HttpServletResponse response) {
    }

    @ExceptionHandler()
    public void handleGeneric(Exception exception, HttpServletResponse response) throws IOException {
        logger.error("Handling the exception on controller: " + exception.getMessage(), exception);
    }
}
