package com.crudspring.api.Exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crudspring.api.DTOs.ErrorDatails;

@ControllerAdvice
public class GlobalExceptionhandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(ResourceNotFountException.class)
        public ResponseEntity<ErrorDatails> handleResourceNotFoundException(ResourceNotFountException exception,
                        WebRequest webreques) {
                ErrorDatails errordatails = new ErrorDatails(new Date(), exception.getMessage(),
                                webreques.getDescription(false));

                return new ResponseEntity<>(errordatails, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(BlogAppExceptions.class)
        public ResponseEntity<ErrorDatails> handleBlogAppException(BlogAppExceptions exception,
                        WebRequest webreques) {
                ErrorDatails errordatails = new ErrorDatails(new Date(), exception.getMessage(),
                                webreques.getDescription(false));

                return new ResponseEntity<>(errordatails, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDatails> handlerGlobalException(Exception exception,
                        WebRequest webreques) {
                ErrorDatails errordatails = new ErrorDatails(new Date(), exception.getMessage(),
                                webreques.getDescription(false));

                return new ResponseEntity<>(errordatails, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                        HttpHeaders headers, HttpStatus status, WebRequest request) {
                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String nameField = ((FieldError) error).getField();
                        String message = error.getDefaultMessage();
                        errors.put(nameField, message);
                });
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

}
