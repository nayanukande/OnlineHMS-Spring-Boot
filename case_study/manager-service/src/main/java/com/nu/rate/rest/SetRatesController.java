package com.nu.rate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nu.rate.entity.SetRates;
import com.nu.rate.service.SetRatesService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager/set-rates")
public class SetRatesController {
    @Autowired
    private SetRatesService setRatesService;

    //Add Special Rates
    @PostMapping("/addSetRates")
    public SetRates addSetRates(@RequestBody SetRates setRates) {
        return setRatesService.addSetRates(setRates);
    }

    //Get All Rates
    @GetMapping
    public List<SetRates> getAllSetRates() {
        return setRatesService.getAllSetRates();
    }

    //Check if a Special Rate Exists for Room Type
    @GetMapping("/check")
    public Optional<SetRates> getSpecialRate(
            @RequestParam LocalDate checkInDate,
            @RequestParam LocalDate checkOutDate,
            @RequestParam int numGuests,
            @RequestParam String roomType) {
        return setRatesService.getSpecialRate(checkInDate, checkOutDate, numGuests, roomType);
    }
}
