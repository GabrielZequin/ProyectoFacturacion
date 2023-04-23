package com.trabajoFinalGabi2.ControllerAdvice;

import com.trabajoFinalGabi2.Exception.ClienteException;
import com.trabajoFinalGabi2.Exception.FacturaException;
import com.trabajoFinalGabi2.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ClienteException.class)
    public ResponseEntity<ErrorDto> clienteExceptionHandler(ClienteException ex) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }

   @ExceptionHandler(value = FacturaException.class)
    public ResponseEntity<ErrorDto> facturaExceptionHandler(ClienteException ex) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDto> Exceptions(Exception ex) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }
}
