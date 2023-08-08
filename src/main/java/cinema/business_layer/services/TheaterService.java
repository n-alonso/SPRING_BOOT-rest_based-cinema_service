package cinema.business_layer.services;

import cinema.persistence_layer.models.seats.Seat;
import cinema.persistence_layer.models.seats.SeatDTO;
import cinema.persistence_layer.models.Theater;
import cinema.persistence_layer.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository repository;

    public List<Seat> getSeats() {
        return repository.getSeats();
    }

    public Seat purchaseSeat(SeatDTO dto) {
        return repository.purchaseSeat(dto);
    }

    public Seat refundSeat(UUID token) {
        return repository.refundSeat(token);
    }

    public Theater getInstance() {
        return repository.getInstance();
    }
}
