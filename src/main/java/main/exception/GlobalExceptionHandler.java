package main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RunTimeExceptionSearchGetByIdNotExist.class)
      public ResponseEntity<Map<String,String>> tratarPacoteNaoEncontrado(
              RunTimeExceptionSearchGetByIdNotExist ex
    ){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem",ex.getMessage()));
    }
    @ExceptionHandler(RunTimeExceptionDuplicationById.class)
    public ResponseEntity<Map<String,String>> tratarPacoteDuplicado(
            RunTimeExceptionDuplicationById ex
    ){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem",ex.getMessage()));
    }
}
