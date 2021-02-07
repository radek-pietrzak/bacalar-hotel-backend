package pl.sdacademy.bacalarhotelbackend.room;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> updateRoom(@PathVariable long id, @RequestBody Room roomToUpdate) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.findById(id)
                .ifPresent(room -> {
                    room.updateFrom(roomToUpdate);
                    roomRepository.save(room);
                });
        return ResponseEntity.noContent().build();
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<?> patchRoomNumber(@PathVariable long id, @RequestBody int roomNumberToUpdate) {
//        if (!roomRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        roomRepository.getOne(id).setRoomNumber(roomNumberToUpdate);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        roomRepository.deleteById(id);
    }
}
