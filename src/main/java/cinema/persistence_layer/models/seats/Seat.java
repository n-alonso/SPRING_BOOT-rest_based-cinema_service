package cinema.persistence_layer.models.seats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Seat {

    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private UUID token;

    public Seat () {}

    public Seat (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UUID getToken() {
        return this.token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
