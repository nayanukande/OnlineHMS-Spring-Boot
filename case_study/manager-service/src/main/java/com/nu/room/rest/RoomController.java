package com.nu.room.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.nu.room.entity.Room;
import com.nu.room.service.RoomService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    //Add Room
    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }
    
    @GetMapping("/getById")
    public Optional<Room> getRoomById(@RequestParam Long id) {
        return roomService.getRoomById(id);
    }

    //Update Room
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    //Delete Room
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

    //Get All Rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    //Search Available Rooms
    @GetMapping("/search")
    public List<Room> searchAvailableRooms(
        @RequestParam("checkInDate") String checkInDate,
        @RequestParam("checkOutDate") String checkOutDate,
        @RequestParam("guestCount") int guestCount) {

        LocalDate checkIn = LocalDate.parse(checkInDate);
        LocalDate checkOut = LocalDate.parse(checkOutDate);

        return roomService.searchRooms(checkIn, checkOut, guestCount);
    }
}
