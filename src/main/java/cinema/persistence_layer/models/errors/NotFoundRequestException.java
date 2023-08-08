package cinema.persistence_layer.models.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundRequestException extends RuntimeException {

    public NotFoundRequestException(String message) {
        super(message);
    }
}
