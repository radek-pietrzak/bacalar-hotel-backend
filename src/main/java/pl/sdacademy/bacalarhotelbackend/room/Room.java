package pl.sdacademy.bacalarhotelbackend.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    private int numberOfSingleBed;
    private int numberOfDoubleBed;
    private int numberOfPerson;

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

    public void setId(Long id) {
        this.id = id;
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
}
