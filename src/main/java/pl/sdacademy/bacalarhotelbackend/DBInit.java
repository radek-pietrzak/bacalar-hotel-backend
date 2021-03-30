//package pl.sdacademy.bacalarhotelbackend;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import pl.sdacademy.bacalarhotelbackend.guest.Guest;
//import pl.sdacademy.bacalarhotelbackend.guest.GuestRepository;
//import pl.sdacademy.bacalarhotelbackend.reservation.Reservation;
//import pl.sdacademy.bacalarhotelbackend.reservation.ReservationRepository;
//import pl.sdacademy.bacalarhotelbackend.room.Room;
//import pl.sdacademy.bacalarhotelbackend.room.RoomRepository;
//
//import javax.annotation.PostConstruct;
//import java.time.LocalDate;
//
//@Component
//public class DBInit {
//    private final RoomRepository roomRepository;
//    private final GuestRepository guestRepository;
//    private final ReservationRepository reservationRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public DBInit(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, PasswordEncoder passwordEncoder) {
//        this.roomRepository = roomRepository;
//        this.guestRepository = guestRepository;
//        this.reservationRepository = reservationRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostConstruct
//    public void onInit() {
//        Room room1 = new Room(1, 1, 0);
//        Room room2 = new Room(2, 1, 0);
//        Room room3 = new Room(3, 1, 0);
//        Room room4 = new Room(4, 0, 1);
//        Room room5 = new Room(5, 0, 1);
//        Room room6 = new Room(6, 0, 1);
//        Room room7 = new Room(7, 0, 1);
//        Room room8 = new Room(8, 1, 1);
//        Room room9 = new Room(9, 1, 1);
//        Room room10 = new Room(10, 2, 1);
//        roomRepository.save(room1);
//        roomRepository.save(room2);
//        roomRepository.save(room3);
//        roomRepository.save(room4);
//        roomRepository.save(room5);
//        roomRepository.save(room6);
//        roomRepository.save(room7);
//        roomRepository.save(room8);
//        roomRepository.save(room9);
//        roomRepository.save(room10);
//
//        Guest guest1 = new Guest("Radek", "Pietrzak", "radekpietrzak102@gmail.com", passwordEncoder.encode("radek"));
//        Guest guest2 = new Guest("Agata", "Pietrzak", "agata_dz@wp.pl", passwordEncoder.encode("agata"));
//        Guest guest3 = new Guest("Albert", "Einstein", "albi.ein@gmail.com", passwordEncoder.encode("albert"));
//        Guest guest4 = new Guest("Adam", "Mickiewicz", "a.mickiewicz@onet.pl", passwordEncoder.encode("adam"));
//        Guest guest5 = new Guest("Stefan", "Batory", "setfciu.bat@interia.eu", passwordEncoder.encode("stefan"));
//        Guest guest6 = new Guest("Arnold", "Schwarzenegger", "arniebiceps@gmail.com", passwordEncoder.encode("arnie"));
//        Guest guest7 = new Guest("Donald", "Trump", "ihaveneverlostelections@yahoo.com", passwordEncoder.encode("donald"));
//        Guest guest8 = new Guest("Edyta", "Górniak", "niema.covid@edzia.pl", passwordEncoder.encode("edzia"));
//        Guest guest9 = new Guest("Vladimir", "Putin", "war@forever.ru", passwordEncoder.encode("wally"));
//        Guest guest10 = new Guest("Bruce", "Wayne", "love.batman@gmail.com", passwordEncoder.encode("bruce"));
//        guestRepository.save(guest1);
//        guestRepository.save(guest2);
//        guestRepository.save(guest3);
//        guestRepository.save(guest4);
//        guestRepository.save(guest5);
//        guestRepository.save(guest6);
//        guestRepository.save(guest7);
//        guestRepository.save(guest8);
//        guestRepository.save(guest9);
//        guestRepository.save(guest10);
//
//        Reservation reservation1 = new Reservation(LocalDate.of(2021, 5, 1),room1 , guest1);
//        Reservation reservation2 = new Reservation(LocalDate.of(2021, 5, 2), room2, guest2);
//        Reservation reservation3 = new Reservation(LocalDate.of(2021, 5, 3), room3, guest3);
//        Reservation reservation4 = new Reservation(LocalDate.of(2021, 5, 4), room4, guest4);
//        Reservation reservation5 = new Reservation(LocalDate.of(2021, 5, 5), room5, guest5);
//        Reservation reservation6 = new Reservation(LocalDate.of(2021, 5, 6), room6, guest6);
//        Reservation reservation7 = new Reservation(LocalDate.of(2021, 5, 7), room7, guest7);
//        Reservation reservation8 = new Reservation(LocalDate.of(2021, 5, 8), room8, guest8);
//        Reservation reservation9 = new Reservation(LocalDate.of(2021, 5, 9), room9, guest9);
//        Reservation reservation10 = new Reservation(LocalDate.of(2021, 5, 10), room10, guest10);
//        reservationRepository.save(reservation1);
//        reservationRepository.save(reservation2);
//        reservationRepository.save(reservation3);
//        reservationRepository.save(reservation4);
//        reservationRepository.save(reservation5);
//        reservationRepository.save(reservation6);
//        reservationRepository.save(reservation7);
//        reservationRepository.save(reservation8);
//        reservationRepository.save(reservation9);
//        reservationRepository.save(reservation10);
//
//    }
//}
