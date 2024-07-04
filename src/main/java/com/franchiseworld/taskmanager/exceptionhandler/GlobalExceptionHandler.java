package com.franchiseworld.taskmanager.exceptionhandler;

import com.franchiseworld.taskmanager.customexception.ProjectNotFoundException;
import com.franchiseworld.taskmanager.customexception.UserNameNotFoundException;
import com.franchiseworld.taskmanager.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UserNameNotFoundException.class})
    public ResponseEntity<ApiError> handleException(UserNameNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ProjectNotFoundException.class})
    public ResponseEntity<ApiError> handleExceptionn(ProjectNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
