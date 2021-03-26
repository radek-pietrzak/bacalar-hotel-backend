package pl.sdacademy.bacalarhotelbackend.room;

import pl.sdacademy.bacalarhotelbackend.reservation.Reservation;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    private int numberOfSingleBed;
    private int numberOfDoubleBed;
    private int numberOfPerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Reservation> reservations;

    public Room() {
    }

    public Room(int roomNumber, int numberOfSingleBed, int numberOfDoubleBed) {
        this.roomNumber = roomNumber;
        this.numberOfSingleBed = numberOfSingleBed;
        this.numberOfDoubleBed = numberOfDoubleBed;
        this.numberOfPerson = numberOfSingleBed + numberOfDoubleBed * 2;
    }

    public Long getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfSingleBed() {
        return numberOfSingleBed;
    }

    public void setNumberOfSingleBed(int numberOfSingleBed) {
        this.numberOfSingleBed = numberOfSingleBed;
    }

    public int getNumberOfDoubleBed() {
        return numberOfDoubleBed;
    }

    public void setNumberOfDoubleBed(int numberOfDoubleBed) {
        this.numberOfDoubleBed = numberOfDoubleBed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }



    public void updateFrom(Room source) {
        roomNumber = source.roomNumber;
        numberOfSingleBed = source.numberOfSingleBed;
        numberOfDoubleBed = source.numberOfDoubleBed;
        numberOfPerson = source.numberOfSingleBed + source.numberOfDoubleBed * 2;
    }

}
