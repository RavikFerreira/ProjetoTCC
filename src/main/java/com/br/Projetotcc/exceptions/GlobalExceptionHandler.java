package com.br.Projetotcc.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(MesasResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleMesasResourceNotFoundException(MesasResourceNotFoundException ex, HttpServletRequest request) {
        String error = "Não existe mesa com esse id!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(PedidoResourceNotFoundException.class)
    public ResponseEntity<StandardError> handlePedidoResourceNotFoundException(PedidoResourceNotFoundException ex, HttpServletRequest request) {
        String error = "Não existe pedido com esse id!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(CannotDeleteABusyTable.class)
    public ResponseEntity<StandardError> handleCannotDeleteABusyTable(CannotDeleteABusyTable ex, HttpServletRequest request) {
        String error = "Não é possível deletar uma mesa ocupada! ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(UnableToDeleteAnOrderFromATable.class)
    public ResponseEntity<StandardError> handleUnableToDeleteAnOrderFromATable(UnableToDeleteAnOrderFromATable ex, HttpServletRequest request) {
        String error = "Não é possível excluir um pedido de uma mesa! ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(UnableToEditAnOrderFromATable.class)
    public ResponseEntity<StandardError> handleUnableToEditAnOrderFromATable(UnableToEditAnOrderFromATable ex, HttpServletRequest request) {
        String error = "Não é possível editar um pedido de uma mesa! ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(CannotCreateATableWithTheSameId.class)
    public ResponseEntity<StandardError> handleCannotCreateATableWithTheSameId(CannotCreateATableWithTheSameId ex, HttpServletRequest request) {
        String error = "Não é possível criar uma mesa com o mesmo id! ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(ItIsNotPossibleToAddAProductToTheMenuWithTheSameId.class)
    public ResponseEntity<StandardError> handleItIsNotPossibleToAddAProductToTheMenuWithTheSameId(ItIsNotPossibleToAddAProductToTheMenuWithTheSameId ex, HttpServletRequest request) {
        String error = "Não é possível adicionar ao menu um produto com o mesmo identificador! ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(status.value() ,error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
