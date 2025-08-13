package com.nu.guest.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.nu.guest.entity.Guest;
import com.nu.guest.service.GuestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receptionist/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    // Add Guest
    @PostMapping("/addGuest")
    public Guest addGuest(@Valid @RequestBody Guest guest) {
        return guestService.addGuest(guest);
    }

    // Update Guest
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @Valid @RequestBody Guest guest) {
        return guestService.updateGuest(id, guest);
    }

    // Delete Guest
    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable Long id) {
        return guestService.deleteGuest(id);
    }
}
