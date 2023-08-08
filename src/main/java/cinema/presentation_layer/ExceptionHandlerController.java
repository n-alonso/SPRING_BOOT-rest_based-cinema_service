package cinema.presentation_layer;

import cinema.persistence_layer.models.errors.BadRequestException;
import cinema.persistence_layer.models.errors.ErrorMessageStructure;
import cinema.persistence_layer.models.errors.NotFoundRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    Logger logger;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessageStructure> handleBadRequests(BadRequestException exception) {
        logger.warn(exception.getMessage());
        ErrorMessageStructure body = new ErrorMessageStructure(
                LocalDateTime.now(),
                400,
                exception.getMessage()
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(NotFoundRequestException.class)
    public ResponseEntity<ErrorMessageStructure> handleNotFoundRequests(NotFoundRequestException exception) {
        logger.warn(exception.getMessage());
        ErrorMessageStructure body = new ErrorMessageStructure(
                LocalDateTime.now(),
                404,
                exception.getMessage()
        );
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
