package com.nu.staff.service;

import com.nu.staff.entity.Staff;
import java.util.List;

public interface StaffService {
    Staff addStaff(Staff staff);
    Staff updateStaff(String code, Staff staffDetails);
    String deleteStaff(String code);
    List<Staff> getAllStaff();
    Staff getStaffByCode(String code);
}
