package com.ojcarlos.springmongo.resources.exception;


import com.ojcarlos.springmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest req){

        HttpStatus st = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), st.value(), "Not Found", e.getMessage(), req.getRequestURI() );
        return ResponseEntity.status(st).body(err);
    }
}
