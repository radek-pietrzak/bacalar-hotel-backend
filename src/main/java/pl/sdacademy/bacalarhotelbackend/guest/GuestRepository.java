package pl.sdacademy.bacalarhotelbackend.guest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest>findGuestsByFirstNameContains(String firstNamePart);
    List<Guest>findGuestsByLastNameContains(String lastNamePart);
    List<Guest>findGuestsByEmailContains(String emailPart);
    List<Guest>findGuestsByFirstNameContainsAndLastNameContains(String firstNamePart, String lastNamePart);
    Optional<Guest> findByEmail(String email);
}
