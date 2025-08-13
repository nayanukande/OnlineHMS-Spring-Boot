package com.nu.guest.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.nu.guest.entity.Guest;
import com.nu.guest.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(Long id, Guest newGuest) {
        return guestRepository.findById(id).map(guest -> {
            guest.setName(newGuest.getName());
            guest.setEmail(newGuest.getEmail());
            guest.setGender(newGuest.getGender());
            guest.setPhone(newGuest.getPhone());
            guest.setAddress(newGuest.getAddress());
            guest.setCompany(newGuest.getCompany());
            return guestRepository.save(guest);
        }).orElseThrow(() -> new RuntimeException("Guest not found!"));
    }

    @Override
    public String deleteGuest(Long id) {
        guestRepository.deleteById(id);
        return "Guest Deleted Successfully!";
    }

}
