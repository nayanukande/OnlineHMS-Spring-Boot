package com.nu.guest.service;

import com.nu.guest.entity.Guest;

public interface GuestService {
	Guest addGuest(Guest guest);
    Guest updateGuest(Long id, Guest guest);
    String deleteGuest(Long id);

}