package com.peyman.exceptions;

import lombok.extern.log4j.Log4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
@Log4j
class GlobalControllerExceptionHandler {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity handleRecordNotFound(EmptyResultDataAccessException ex, HttpServletRequest request) {
        log.debug("Record not found: {}");

        return new ResponseEntity("message Record not found", HttpStatus.BAD_REQUEST);
    }
}