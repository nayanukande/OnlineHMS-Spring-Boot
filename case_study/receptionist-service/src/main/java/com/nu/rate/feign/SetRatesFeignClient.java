package com.nu.rate.feign;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nu.rate.dto.SetRatesDTO;

@FeignClient(name = "manager-service", contextId = "setRatesClient")
public interface SetRatesFeignClient {
    @GetMapping("/manager/set-rates/check")
    Optional<SetRatesDTO> getSpecialRate(
            @RequestParam("checkInDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOutDate,
            @RequestParam("numGuests") int numGuests,
            @RequestParam("roomType") String roomType
        );
}
