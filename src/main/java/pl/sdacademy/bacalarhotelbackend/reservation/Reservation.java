package pl.sdacademy.bacalarhotelbackend.reservation;

import pl.sdacademy.bacalarhotelbackend.guest.Guest;
import pl.sdacademy.bacalarhotelbackend.guest.GuestReservation;
import pl.sdacademy.bacalarhotelbackend.room.RoomReservation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "room_reservation_id")
    private RoomReservation roomReservation;
    @ManyToOne
    @JoinColumn(name = "guest_reservation_id")
    private GuestReservation guestReservation;

    public Reservation() {
    }

    public Reservation(LocalDate date, RoomReservation roomReservation, GuestReservation guestReservation) {
        this.date = date;
        this.roomReservation = roomReservation;
        this.guestReservation = guestReservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RoomReservation getRoomReservation() {
        return roomReservation;
    }

    public void setRoomReservation(RoomReservation roomReservation) {
        this.roomReservation = roomReservation;
    }

    public GuestReservation getGuestReservation() {
        return guestReservation;
    }

    public void setGuestReservation(GuestReservation guestReservation) {
        this.guestReservation = guestReservation;
    }

    public void updateFrom(Reservation source) {
        date = source.date;
        roomReservation = source.roomReservation;
        guestReservation = source.guestReservation;
    }
}
