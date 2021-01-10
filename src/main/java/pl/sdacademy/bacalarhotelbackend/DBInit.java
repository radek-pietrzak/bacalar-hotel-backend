package pl.sdacademy.bacalarhotelbackend;

import org.springframework.stereotype.Component;
import pl.sdacademy.bacalarhotelbackend.room.Room;
import pl.sdacademy.bacalarhotelbackend.room.RoomRepository;

import javax.annotation.PostConstruct;

@Component
public class DBInit {
    private RoomRepository roomRepository;

    public DBInit(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void onInit() {
        Room room1 = new Room(1, 1, 0);
        Room room2 = new Room(2, 1, 0);
        Room room3 = new Room(3, 1, 0);
        Room room4 = new Room(4, 0, 1);
        Room room5 = new Room(5, 0, 1);
        Room room6 = new Room(6, 0, 1);
        Room room7 = new Room(7, 0, 1);
        Room room8 = new Room(8, 1, 1);
        Room room9 = new Room(9, 1, 1);
        Room room10 = new Room(10, 2, 1);
        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);
        roomRepository.save(room5);
        roomRepository.save(room6);
        roomRepository.save(room7);
        roomRepository.save(room8);
        roomRepository.save(room9);
        roomRepository.save(room10);


    }
}
