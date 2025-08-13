package com.nu.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nu.room.entity.Room;
import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    //Find rooms available for booking
    @Query("SELECT r FROM Room r WHERE r.available = true " +
    	       "AND r.capacity >= :guestCount " +
    	       "AND (r.checkInDate IS NULL OR r.checkOutDate < :checkInDate)")
    List<Room> findAvailableRooms(
    	@Param("checkInDate") LocalDate checkInDate, 
    	@Param("checkOutDate") LocalDate checkOutDate, 
    	@Param("guestCount") int guestCount);

}