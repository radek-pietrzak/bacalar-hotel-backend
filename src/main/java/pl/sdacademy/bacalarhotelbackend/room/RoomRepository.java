package pl.sdacademy.bacalarhotelbackend.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findRoomsByRoomNumber(int roomNumber);

    List<Room> findRoomsByNumberOfSingleBed(int numberOfSingleBed);

    List<Room> findRoomsByNumberOfDoubleBed(int numberOfDoubleBed);

    List<Room> findRoomsByNumberOfPerson(int numberOfPerson);

    @Query("select r from Room r where r.numberOfPerson >= :minimumNumberOfPerson")
    List<Room> findRoomsByMinimumNumberOfPerson(@Param("minimumNumberOfPerson") int minimumNumberOfPerson);
}
