package cinema.persistence_layer.models.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ErrorMessageStructure {

    private LocalDateTime timeStamp;

    private int statusCode;

    @JsonProperty("error")
    private String message;

    public ErrorMessageStructure(LocalDateTime timeStamp, int statusCode, String message) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
