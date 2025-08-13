package com.nu.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.guest.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
