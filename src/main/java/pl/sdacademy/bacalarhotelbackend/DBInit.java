package pl.sdacademy.bacalarhotelbackend;

import org.springframework.stereotype.Component;
import pl.sdacademy.bacalarhotelbackend.guest.Guest;
import pl.sdacademy.bacalarhotelbackend.guest.GuestRepository;
import pl.sdacademy.bacalarhotelbackend.room.Room;
import pl.sdacademy.bacalarhotelbackend.room.RoomRepository;

import javax.annotation.PostConstruct;

@Component
public class DBInit {
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;

    public DBInit(RoomRepository roomRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
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

        Guest guest1 = new Guest("Radek", "Pietrzak", "radekpietrzak102@gmail.com");
        Guest guest2 = new Guest("Agata", "Pietrzak", "agata_dz@wp.pl");
        Guest guest3 = new Guest("Albert", "Einstein", "albi.ein@gmail.com");
        Guest guest4 = new Guest("Adam", "Mickiewicz", "a.mickiewicz@onet.pl");
        Guest guest5 = new Guest("Stefan", "Batory", "setfciu.bat@interia.eu");
        Guest guest6 = new Guest("Arnold", "Schwarzenegger", "ariniebiceps@gmail.com");
        Guest guest7 = new Guest("Donald", "Trump", "ihaveneverlostelections@yahoo.com");
        Guest guest8 = new Guest("Edyta", "Górniak", "niema.covid@edzia.pl");
        Guest guest9 = new Guest("Vladimir", "Putin", "war@forever.ru");
        Guest guest10 = new Guest("Bruce", "Wayne", "love.batman@gmail.com");
        guestRepository.save(guest1);
        guestRepository.save(guest2);
        guestRepository.save(guest3);
        guestRepository.save(guest4);
        guestRepository.save(guest5);
        guestRepository.save(guest6);
        guestRepository.save(guest7);
        guestRepository.save(guest8);
        guestRepository.save(guest9);
        guestRepository.save(guest10);
    }
}
