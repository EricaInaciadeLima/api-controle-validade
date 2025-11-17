package com.api.controlevalidade.exception;

import com.api.controlevalidade.exception.custom.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro de integridade: dado duplicado ou violação de restrição única.");
    }

    @ExceptionHandler(PerfilNotFoundException.class)
    public ResponseEntity<String> handlePerfilNotFound(PerfilNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PerfilJaExisteException.class)
    public ResponseEntity<String> handlePerfilJaExiste(PerfilJaExisteException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(CnpjDuplicadoException.class)
    public ResponseEntity<String> handleCnpjDuplicado(CnpjDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<String> handleAcessoNegado(AcessoNegadoException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(CredenciaisInvalidasException.class)
    public ResponseEntity<String> handleCredenciaisInvalidas(CredenciaisInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<String> handleCategoriaNotFound(CategoriaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDenied(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Acesso negado: você não tem permissão para realizar esta ação.");
    }
    @ExceptionHandler(EmpresaNotFoundException.class)
    public ResponseEntity<String> handleEmpresaNotFound(EmpresaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        ex.printStackTrace(); // imprime no console
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno inesperado. Por favor, tente novamente mais tarde.");
    }
}