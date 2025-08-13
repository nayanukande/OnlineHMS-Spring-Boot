package com.nu.room.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import com.nu.room.entity.Room;
import com.nu.room.repository.RoomRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        return roomRepository.findById(id).map(room -> {
            room.setType(updatedRoom.getType());
            room.setPrice(updatedRoom.getPrice());
            room.setAvailable(updatedRoom.isAvailable());
            room.setCapacity(updatedRoom.getCapacity());
            room.setCheckInDate(updatedRoom.getCheckInDate());
            room.setCheckOutDate(updatedRoom.getCheckOutDate());
            return roomRepository.save(room);
        }).orElseThrow(() -> new RuntimeException("Room not found!"));
    }
    
    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> searchRooms(LocalDate checkInDate, LocalDate checkOutDate, int guestCount) {
        return roomRepository.findAvailableRooms(checkInDate, checkOutDate, guestCount);
    }
}
