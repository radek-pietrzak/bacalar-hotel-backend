package pl.sdacademy.bacalarhotelbackend.room;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

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
