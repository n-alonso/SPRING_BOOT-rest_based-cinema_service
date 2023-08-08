package cinema.persistence_layer.models.seats;

public class SeatDTO {

    private int row;
    private int column;

    public SeatDTO() {}

    public SeatDTO( int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
