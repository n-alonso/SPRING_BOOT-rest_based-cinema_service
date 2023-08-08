package cinema.persistence_layer.models.seats;

import java.util.UUID;

public class TokenDTO {

    private UUID token;

    public TokenDTO() {}

    public TokenDTO(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
