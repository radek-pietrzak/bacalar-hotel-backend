package pl.sdacademy.bacalarhotelbackend.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.bacalarhotelbackend.guest.Guest;
import pl.sdacademy.bacalarhotelbackend.guest.GuestReservation;
import pl.sdacademy.bacalarhotelbackend.room.RoomReservation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/reservation-list")
public class ReservationController {
    private ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable long id) {
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long id, @RequestBody Reservation reservationToUpdate) {
        if (!reservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservationRepository.findById(id)
                .ifPresent(res -> {
                    res.updateFrom(reservationToUpdate);
                    reservationRepository.save(res);
                });
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/date-change")
    public ResponseEntity<Reservation> patchDate(@PathVariable long id, @RequestBody LocalDate dateToUpdate) {
        if (!reservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservationRepository.findById(id)
                .ifPresent(d -> d.setDate(dateToUpdate));
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/room-change")
    public ResponseEntity<Reservation> patchRoom(@PathVariable long id, @RequestBody RoomReservation roomReservationToUpdate) {
        if (!reservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservationRepository.findById(id)
                .ifPresent(r -> r.setRoomReservation(roomReservationToUpdate));
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/guest-change")
    public ResponseEntity<Reservation> patchGuest(@PathVariable long id, @RequestBody GuestReservation guestToUpdate) {
        if (!reservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservationRepository.findById(id)
                .ifPresent(g -> g.setGuestReservation(guestToUpdate));
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        reservationRepository.deleteById(id);
    }
}
