package cinema.persistence_layer.models.seats;

import java.util.UUID;

public class SeatPurchase {

    private UUID token;
    private Seat ticket;

    public SeatPurchase(UUID token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}
