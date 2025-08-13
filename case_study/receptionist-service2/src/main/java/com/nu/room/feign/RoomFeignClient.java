package com.nu.room.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.nu.room.dto.RoomDTO;

@FeignClient(name = "manager-service")
public interface RoomFeignClient {
    @GetMapping("/manager/rooms/search")
    List<RoomDTO> searchAvailableRooms(
        @RequestParam("checkInDate") String checkInDate,
        @RequestParam("checkOutDate") String checkOutDate,
        @RequestParam("guestCount") int guestCount
    );
}
