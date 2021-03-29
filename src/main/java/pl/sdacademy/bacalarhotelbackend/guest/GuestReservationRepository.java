package pl.sdacademy.bacalarhotelbackend.guest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestReservationRepository extends JpaRepository<GuestReservation, Long> {
}
