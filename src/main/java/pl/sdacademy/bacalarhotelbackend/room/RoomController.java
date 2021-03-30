package pl.sdacademy.bacalarhotelbackend.room;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/room-list")
public class RoomController {
    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable long id) {
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/only")
    public List<RoomOnly> findRoomsOnly() {
        return roomRepository.findAll()
                .stream()
                .map(room -> new RoomOnly(
                        room.getId(),
                        room.getRoomNumber(),
                        room.getNumberOfSingleBed(),
                        room.getNumberOfDoubleBed(),
                        room.getNumberOfPerson()))
                .collect(Collectors.toList());
    }
    @GetMapping("only/string")
    public List<String> findRoomsOnlyInStringList() {
        return roomRepository.findAll()
                .stream()
                .map(r -> ("id: " + r.getId()
                + "room number: " + r.getRoomNumber() + " "
                + "number of single bed: " + r.getNumberOfSingleBed() + " "
                + "number of double bed: " + r.getNumberOfDoubleBed() + " "
                + "number of person: " + r.getNumberOfPerson()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/find-rooms-by-room-number/{roomNumber}")
    public List<Room> findRoomsByRoomNumber(@PathVariable int roomNumber) {
        return roomRepository.findRoomsByRoomNumber(roomNumber);
    }

    @GetMapping("/find-rooms-by-number-of-single-bed/{numberOfSingleBed}")
    public List<Room> findRoomsByNumberOfSingleBed(@PathVariable int numberOfSingleBed) {
        return roomRepository.findRoomsByNumberOfSingleBed(numberOfSingleBed);
    }

    @GetMapping("/find-rooms-by-number-of-double-bed/{numberOfDoubleBed}")
    public List<Room> findRoomsByNumberOfDoubleBed(@PathVariable int numberOfDoubleBed) {
        return roomRepository.findRoomsByNumberOfDoubleBed(numberOfDoubleBed);
    }

    @GetMapping("/find-rooms-by-number-of-person/{numberOfPerson}")
    public List<Room> findRoomsByNumberOfPerson(@PathVariable int numberOfPerson) {
        return roomRepository.findRoomsByNumberOfPerson(numberOfPerson);
    }

    @GetMapping("/find-rooms-by-minimum-number-of-person/{numberOfPerson}")
    public List<Room> findRoomsByMinimumNumberOfPerson(@PathVariable int numberOfPerson) {
        return roomRepository.findRoomsByMinimumNumberOfPerson(numberOfPerson);
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        room.setNumberOfPerson(room.getNumberOfSingleBed() + room.getNumberOfDoubleBed() * 2);
        return roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable long id, @RequestBody Room roomToUpdate) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.findById(id)
                .ifPresent(room -> {
                    room.updateFrom(roomToUpdate);
                    roomRepository.save(room);
                });
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<Room> patchRoomNumber(@PathVariable long id, @RequestBody int roomNumberToUpdate) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.findById(id)
                .ifPresent(r -> r.setRoomNumber(roomNumberToUpdate));
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/single-bed-change")
    public ResponseEntity<Room> patchNumberOfSingleBed(@PathVariable long id, @RequestBody int numberOfSingleBedToUpdate) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.findById(id)
                .ifPresent(s -> {
                    s.setNumberOfSingleBed(numberOfSingleBedToUpdate);
                    s.setNumberOfPerson(numberOfSingleBedToUpdate + s.getNumberOfDoubleBed() * 2);
                });
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PatchMapping("/{id}/double-bed-change")
    public ResponseEntity<Room> patchNumberOfDoubleBed(@PathVariable long id, @RequestBody int numberOfDoubleBedToUpdate) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.findById(id)
                .ifPresent(d -> {
                    d.setNumberOfDoubleBed(numberOfDoubleBedToUpdate);
                    d.setNumberOfPerson(d.getNumberOfSingleBed() + numberOfDoubleBedToUpdate * 2);
                });
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        roomRepository.deleteById(id);
    }
}
