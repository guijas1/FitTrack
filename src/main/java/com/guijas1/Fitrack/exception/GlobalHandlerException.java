package com.guijas1.Fitrack.exception;

import com.guijas1.Fitrack.dto.errorDto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(FutureDateException.class)
    public ResponseEntity<ErrorResponseDTO> handleFutureException(FutureDateException ex){
           ErrorResponseDTO error = new ErrorResponseDTO(
                   ex.getMessage(),
                   ex.getStatus().value(),
                   LocalDateTime.now()
           );

           return ResponseEntity.status(ex.getStatus()).body(error);
    }
}
