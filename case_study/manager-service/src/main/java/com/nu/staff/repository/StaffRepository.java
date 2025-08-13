package com.nu.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.staff.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {
}
