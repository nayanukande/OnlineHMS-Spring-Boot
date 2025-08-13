package com.nu.room.service;

import com.nu.room.entity.Room;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room addRoom(Room room);
    Optional<Room> getRoomById(Long id);
    Room updateRoom(Long id, Room updatedRoom);
    void deleteRoom(Long id);
    List<Room> getAllRooms();
    List<Room> searchRooms(LocalDate checkInDate, LocalDate checkOutDate, int guestCount);
}
