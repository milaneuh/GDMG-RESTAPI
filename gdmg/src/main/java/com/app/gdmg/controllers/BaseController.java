package com.app.gdmg.controllers;

import com.app.gdmg.models.ErrorResponseBean;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.app.gdmg.utils.ConstantesUtils.TRACE;

@RestController
@RequestMapping("/api")
public class BaseController {
    @Value("${reflectoring.trace:false}")
    private boolean printStackTrace;
    static Logger log = Logger.getLogger(BaseController.class.getName());

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseBean> handleItemNotFoundException(
            NoSuchElementException exception,
            WebRequest request
    ){
        log.log(Level.INFO,"Failed to find the requested element",exception);
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorResponseBean> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            WebRequest request
    ) {
        ErrorResponseBean errorResponse = new ErrorResponseBean(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation error. Check 'errors' field for details."
        );

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorResponse.addValidationError(fieldError.getField(),
                    fieldError.getDefaultMessage());
        }
        return ResponseEntity.unprocessableEntity().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseBean> handleAllUncaughtException(
            Exception exception,
            WebRequest request){
        log.log(Level.INFO,"Unknown error occurred", exception);
        return buildErrorResponse(
                exception,
                "Unknown error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    private ResponseEntity<ErrorResponseBean> buildErrorResponse(
            Exception exception,
            HttpStatus httpStatus,
            WebRequest request
    ) {
        return buildErrorResponse(
                exception,
                exception.getMessage(),
                httpStatus,
                request);
    }

    private ResponseEntity<ErrorResponseBean> buildErrorResponse(
            Exception exception,
            String message,
            HttpStatus httpStatus,
            WebRequest request
    ) {
        ErrorResponseBean errorResponse = new ErrorResponseBean(
                httpStatus.value(),
                exception.getMessage()
        );

        if(printStackTrace && isTraceOn(request)){
            errorResponse.setStackTrace(exception.getStackTrace().toString());
        }
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    private boolean isTraceOn(WebRequest request) {
        String [] value = request.getParameterValues(TRACE);
        return Objects.nonNull(value)
                && value.length > 0
                && value[0].contentEquals("true");
    }
}
