package com.yafdev.oms.productmicroservice.errorhandler;

import com.mongodb.MongoWriteException;
import com.yafdev.oms.productmicroservice.exception.ErrorDatabaseResponse;
import com.yafdev.oms.productmicroservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MongoDBExceptionHandler {

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<ErrorDatabaseResponse> handleDuplicateKeyException(MongoWriteException ex) {
        String fieldName = ex.getLocalizedMessage().split("index: ")[1].split("dup key")[0].trim();
        String message = "The value of the '" + fieldName + "' is already in use.";

        ErrorDatabaseResponse errorResponse = new ErrorDatabaseResponse(HttpStatus.BAD_REQUEST.value(), message, fieldName);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException ex) {
        ApiError errorResponse = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
