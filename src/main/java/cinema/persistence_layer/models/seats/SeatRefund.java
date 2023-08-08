package cinema.persistence_layer.models.seats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatRefund {

    @JsonProperty("returned_ticket")
    private Seat returnedTicket;

    public SeatRefund(Seat returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public Seat getReturnedTicket() {
        return returnedTicket;
    }
}
