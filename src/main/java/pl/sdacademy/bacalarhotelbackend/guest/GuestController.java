package pl.sdacademy.bacalarhotelbackend.guest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/guest-list")
public class GuestController {
    private final GuestRepository guestRepository;
    private PasswordEncoder passwordEncoder;

    public GuestController(GuestRepository guestRepository, PasswordEncoder passwordEncoder) {
        this.guestRepository = guestRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> findById(@PathVariable long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/only")
    public List<GuestOnly> findGuestsOnly() {
        return guestRepository.findAll()
                .stream()
                .map(guest -> new GuestOnly(
                        guest.getId(),
                        guest.getFirstName(),
                        guest.getLastName(),
                        guest.getEmail()))
                .collect(Collectors.toList());
    }

    @GetMapping("/find-by-first-name-part/{firstNamePart}")
    public List<Guest> getGuestsByFirstNameContaining(@PathVariable String firstNamePart) {
        return guestRepository.findGuestsByFirstNameContains(firstNamePart);
    }

    @GetMapping("/find-by-last-name-part/{lastNamePart}")
    public List<Guest> getGuestsByLastNameContaining(@PathVariable String lastNamePart) {
        return guestRepository.findGuestsByLastNameContains(lastNamePart);
    }

    @GetMapping("/find-by-email-part/{emailPart}")
    public List<Guest> getGuestsByEmailContaining(@PathVariable String emailPart) {
        return guestRepository.findGuestsByEmailContains(emailPart);
    }

    @GetMapping("/find-by-first-and-last-name-parts/{firstNamePart}/{lastNamePart}")
    public List<Guest> findGuestsByFirstNameContainsAndLastNameContains(
            @PathVariable String firstNamePart,
            @PathVariable String lastNamePart) {
        return guestRepository.findGuestsByFirstNameContainsAndLastNameContains(
                firstNamePart, lastNamePart);
    }

    @PostMapping
    public Guest addGuest(@RequestBody Guest guest) {
        guest.setPassword(passwordEncoder.encode(guest.getPassword()));
        guest.setRole("GUEST");
        return guestRepository.save(guest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable long id, @RequestBody Guest guestToUpdate) {
        if (!guestRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        guestRepository.findById(id)
                .ifPresent(guest -> {
                    guest.updateFrom(guestToUpdate);
                    guestRepository.save(guest);
                });
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/first-name-change")
    public ResponseEntity<Guest> patchFirstName(@PathVariable long id, @RequestBody String firstNameToUpdate) {
        if (!guestRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        guestRepository.findById(id)
                .ifPresent(f -> f.setFirstName(firstNameToUpdate));
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/last-name-change")
    public ResponseEntity<Guest> patchLastName(@PathVariable long id, @RequestBody String lastNameToUpdate) {
        if (!guestRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        guestRepository.findById(id)
                .ifPresent(l -> l.setLastName(lastNameToUpdate));
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/email-change")
    public ResponseEntity<Guest> patchEmail(@PathVariable long id, @RequestBody String emailToUpdate) {
        if (!guestRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        guestRepository.findById(id)
                .ifPresent(e -> e.setEmail(emailToUpdate));
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        guestRepository.deleteById(id);
    }
}
