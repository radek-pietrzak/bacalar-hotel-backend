package pl.sdacademy.bacalarhotelbackend.room;

public class RoomOnly {
    private Long id;
    private int roomNumber;
    private int numberOfSingleBed;
    private int numberOfDoubleBed;
    private int numberOfPerson;

    public RoomOnly() {
    }

    public RoomOnly(Long id, int roomNumber, int numberOfSingleBed, int numberOfDoubleBed, int numberOfPerson) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.numberOfSingleBed = numberOfSingleBed;
        this.numberOfDoubleBed = numberOfDoubleBed;
        this.numberOfPerson = numberOfPerson;
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

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }
}
