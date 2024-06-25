package com.clients.api.clients_api.exception;

import com.clients.api.clients_api.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {
    private HttpStatus code;
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> clientNotFound(ClientNotFoundException ex) {
        this.code = HttpStatus.NOT_FOUND;
        ErrorMessage message = new ErrorMessage(this.code, ex.getMessage());
        return ResponseEntity.status(this.code).body(message);
    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> badRequest(BadRequestException ex) {
        this.code = HttpStatus.BAD_REQUEST;
        ErrorMessage message = new ErrorMessage(this.code, ex.getMessage());
        return ResponseEntity.status(this.code).body(message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        this.code = HttpStatus.NOT_FOUND;
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(this.code).body(errors);
    }
}
