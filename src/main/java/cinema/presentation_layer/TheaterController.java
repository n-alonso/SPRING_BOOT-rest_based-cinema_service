package cinema.presentation_layer;

import cinema.business_layer.services.TheaterService;
import cinema.persistence_layer.models.seats.*;
import cinema.persistence_layer.models.Theater;
import cinema.persistence_layer.models.errors.BadRequestException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TheaterController {

    @Autowired
    Logger logger;

    @Autowired
    private TheaterService theaterService;

    @GetMapping("/seats")
    public ResponseEntity<Theater> getSeats() {
        logger.info("Request received at /seats");
        return ResponseEntity.ok(theaterService.getInstance());
    }

    @PostMapping("/purchase")
    public ResponseEntity<SeatPurchase> purchaseSeat(@RequestBody SeatDTO dto) {
        logger.info("Request received at /purchase");

        if (dto.getColumn() > 9 || dto.getColumn() < 1 || dto.getRow() > 9 || dto.getRow() < 1) {
            throw new BadRequestException("The number of a row or a column is out of bounds!");
        }

        Seat seat = theaterService.purchaseSeat(dto);
        if (seat == null) {
            throw new BadRequestException("The ticket has been already purchased!");
        }

        SeatPurchase purchase = new SeatPurchase(seat.getToken(), seat);
        return ResponseEntity.ok(purchase);
    }

    @PostMapping("/return")
    public ResponseEntity<SeatRefund> refundSeat(@RequestBody TokenDTO dto) {
        logger.info("Request received at /return");

        Seat seat = theaterService.refundSeat(dto.getToken());
        if (seat == null) {
            throw new BadRequestException("Wrong token!");
        }

        SeatRefund refund = new SeatRefund(seat);
        return ResponseEntity.ok(refund);
    }
}
