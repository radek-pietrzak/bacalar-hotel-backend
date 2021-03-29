package pl.sdacademy.bacalarhotelbackend;

import org.springframework.stereotype.Component;
import pl.sdacademy.bacalarhotelbackend.guest.Guest;
import pl.sdacademy.bacalarhotelbackend.guest.GuestRepository;
import pl.sdacademy.bacalarhotelbackend.guest.GuestReservation;
import pl.sdacademy.bacalarhotelbackend.guest.GuestReservationRepository;
import pl.sdacademy.bacalarhotelbackend.reservation.Reservation;
import pl.sdacademy.bacalarhotelbackend.reservation.ReservationRepository;
import pl.sdacademy.bacalarhotelbackend.room.Room;
import pl.sdacademy.bacalarhotelbackend.room.RoomRepository;
import pl.sdacademy.bacalarhotelbackend.room.RoomReservation;
import pl.sdacademy.bacalarhotelbackend.room.RoomReservationRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DBInit {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationRepository roomReservationRepository;
    private final GuestReservationRepository guestReservationRepository;

    public DBInit(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, RoomReservationRepository roomReservationRepository, GuestReservationRepository guestReservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomReservationRepository = roomReservationRepository;
        this.guestReservationRepository = guestReservationRepository;
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
        Guest guest6 = new Guest("Arnold", "Schwarzenegger", "arniebiceps@gmail.com");
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

        GuestReservation guestReservation1 = new GuestReservation(guest1);
        GuestReservation guestReservation2 = new GuestReservation(guest2);
        GuestReservation guestReservation3 = new GuestReservation(guest3);
        GuestReservation guestReservation4 = new GuestReservation(guest4);
        GuestReservation guestReservation5 = new GuestReservation(guest5);
        GuestReservation guestReservation6 = new GuestReservation(guest6);
        GuestReservation guestReservation7 = new GuestReservation(guest7);
        GuestReservation guestReservation8 = new GuestReservation(guest8);
        GuestReservation guestReservation9 = new GuestReservation(guest9);
        GuestReservation guestReservation10 = new GuestReservation(guest10);
        guestReservationRepository.save(guestReservation1);
        guestReservationRepository.save(guestReservation2);
        guestReservationRepository.save(guestReservation3);
        guestReservationRepository.save(guestReservation4);
        guestReservationRepository.save(guestReservation5);
        guestReservationRepository.save(guestReservation6);
        guestReservationRepository.save(guestReservation7);
        guestReservationRepository.save(guestReservation8);
        guestReservationRepository.save(guestReservation9);
        guestReservationRepository.save(guestReservation10);

        RoomReservation roomReservation1 = new RoomReservation(room1);
        RoomReservation roomReservation2 = new RoomReservation(room2);
        RoomReservation roomReservation3 = new RoomReservation(room3);
        RoomReservation roomReservation4 = new RoomReservation(room4);
        RoomReservation roomReservation5 = new RoomReservation(room5);
        RoomReservation roomReservation6 = new RoomReservation(room6);
        RoomReservation roomReservation7 = new RoomReservation(room7);
        RoomReservation roomReservation8 = new RoomReservation(room8);
        RoomReservation roomReservation9 = new RoomReservation(room9);
        RoomReservation roomReservation10 = new RoomReservation(room10);
        roomReservationRepository.save(roomReservation1);
        roomReservationRepository.save(roomReservation2);
        roomReservationRepository.save(roomReservation3);
        roomReservationRepository.save(roomReservation4);
        roomReservationRepository.save(roomReservation5);
        roomReservationRepository.save(roomReservation6);
        roomReservationRepository.save(roomReservation7);
        roomReservationRepository.save(roomReservation8);
        roomReservationRepository.save(roomReservation9);
        roomReservationRepository.save(roomReservation10);

        Reservation reservation1 = new Reservation(LocalDate.of(2021, 5, 1), roomReservation1, guestReservation1);
        Reservation reservation2 = new Reservation(LocalDate.of(2021, 5, 2), roomReservation2, guestReservation2);
        Reservation reservation3 = new Reservation(LocalDate.of(2021, 5, 3), roomReservation3, guestReservation3);
        Reservation reservation4 = new Reservation(LocalDate.of(2021, 5, 4), roomReservation4, guestReservation4);
        Reservation reservation5 = new Reservation(LocalDate.of(2021, 5, 5), roomReservation5, guestReservation5);
        Reservation reservation6 = new Reservation(LocalDate.of(2021, 5, 6), roomReservation6, guestReservation6);
        Reservation reservation7 = new Reservation(LocalDate.of(2021, 5, 7), roomReservation7, guestReservation7);
        Reservation reservation8 = new Reservation(LocalDate.of(2021, 5, 8), roomReservation8, guestReservation8);
        Reservation reservation9 = new Reservation(LocalDate.of(2021, 5, 9), roomReservation9, guestReservation9);
        Reservation reservation10 = new Reservation(LocalDate.of(2021, 5, 10), roomReservation10, guestReservation10);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);
        reservationRepository.save(reservation6);
        reservationRepository.save(reservation7);
        reservationRepository.save(reservation8);
        reservationRepository.save(reservation9);
        reservationRepository.save(reservation10);
    }
}
