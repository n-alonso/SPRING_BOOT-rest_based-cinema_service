package cinema.persistence_layer.repositories;


import cinema.persistence_layer.models.seats.Seat;
import cinema.persistence_layer.models.seats.SeatDTO;
import cinema.persistence_layer.models.Theater;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


// FIXME (Convert to interface that extends CrudRepo when possible,
//  and convert Theater instance to DB)
@Repository
public class TheaterRepository {

    private Theater theater = new Theater();

    {
        init();
    }

    public void init() {
        // Create a matrix of 9x9 representing the seats in the theater,
        int[][] seatsGrid = new int[9][9];
        // Populate the seats iterating over their indexes
        for (int i = 0; i < seatsGrid.length; i++) {
            for (int j = 0; j < seatsGrid[i].length; j++) {
                int price = i + 1 <= 4 ? 10 : 8;

                Seat seat = new Seat();
                seat.setRow(i + 1);
                seat.setColumn(j + 1);
                seat.setPrice(price);

                theater.getAvailableSeats().add(seat);
            }
        }
    }

    public Theater getInstance() {
        return theater;
    }

    public List<Seat> getSeats() {
        return theater.getAvailableSeats();
    }

    public List<Seat> getPurchasedSeats() { return theater.getPurchasedSeats(); }

    public Seat purchaseSeat(SeatDTO dto) {
        List<Seat> seats = getSeats();
        List<Seat> purchasedSeats = getPurchasedSeats();

        synchronized (seats) {
            for (Seat seat : seats) {
                if (seat.getColumn() == dto.getColumn() && seat.getRow() == dto.getRow()) {
                    seat.setToken(UUID.randomUUID());
                    seats.remove(seat);
                    purchasedSeats.add(seat);
                    return seat;
                }
            }
        }

        return null;
    }

    public Seat refundSeat(UUID token) {
        List<Seat> seats = getSeats();
        List<Seat> purchasedSeats = getPurchasedSeats();

        synchronized (purchasedSeats) {
            for (Seat seat : purchasedSeats) {
                if (seat.getToken().equals(token)) {
                    seat.setToken(null);
                    purchasedSeats.remove(seat);
                    seats.add(seat);
                    return seat;
                }
            }
        }

        return null;
    }
}
