package pl.sdacademy.bacalarhotelbackend.reservation;

import pl.sdacademy.bacalarhotelbackend.guest.Guest;
import pl.sdacademy.bacalarhotelbackend.room.Room;

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
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Reservation() {
    }

    public Reservation(LocalDate date, Room room, Guest guest) {
        this.date = date;
        this.room = room;
        this.guest = guest;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void updateFrom(Reservation source) {
        date = source.date;
        room = source.room;
        guest = source.guest;
    }
}
