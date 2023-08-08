package cinema.persistence_layer.models;

import cinema.persistence_layer.models.seats.Seat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class Theater {

    @JsonProperty("total_rows")
    private int totalRows = 9;

    @JsonProperty("total_columns")
    private int totalColumns = 9;

    @JsonProperty("available_seats")
    private List<Seat> availableSeats = Collections.synchronizedList(new ArrayList<>());

    @JsonIgnore
    private List<Seat> purchasedSeats = Collections.synchronizedList(new ArrayList<>());

    public Theater() {}

    public Theater(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public List<Seat> getPurchasedSeats() {
        return purchasedSeats;
    }
}
