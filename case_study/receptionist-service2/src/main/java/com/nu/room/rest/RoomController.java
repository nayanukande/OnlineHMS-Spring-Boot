package com.nu.room.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.nu.room.dto.RoomDTO;
import com.nu.room.feign.RoomFeignClient;
import java.util.List;

@RestController
@RequestMapping("/receptionist/rooms")
public class RoomController {
    
    @Autowired
    private RoomFeignClient roomFeignClient;

    @GetMapping("/search")
    public List<RoomDTO> searchAvailableRooms(
        @RequestParam("checkInDate") String checkInDate,
        @RequestParam("checkOutDate") String checkOutDate,
        @RequestParam("guestCount") int guestCount) {

        return roomFeignClient.searchAvailableRooms(checkInDate, checkOutDate, guestCount);
    }
}
