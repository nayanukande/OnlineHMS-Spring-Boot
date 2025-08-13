package com.nu.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nu.staff.entity.Staff;
import com.nu.staff.repository.StaffRepository;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff addStaff(Staff staff) {
        if (staffRepository.existsById(staff.getCode())) {
            throw new IllegalArgumentException("Staff with code " + staff.getCode() + " already exists.");
        }
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(String code, Staff staffDetails) {
        Staff staff = staffRepository.findById(code)
            .orElseThrow(() -> new IllegalArgumentException("Staff not found with code: " + code));

        staff.setEmployeeName(staffDetails.getEmployeeName());
        staff.setEmployeeAddress(staffDetails.getEmployeeAddress());
        staff.setSalary(staffDetails.getSalary());
        staff.setAge(staffDetails.getAge());
        staff.setOccupation(staffDetails.getOccupation());
        staff.setEmail(staffDetails.getEmail());

        return staffRepository.save(staff);
    }

    @Override
    public String deleteStaff(String code) {
        if (!staffRepository.existsById(code)) {
            throw new IllegalArgumentException("Staff not found with code: " + code);
        }
        staffRepository.deleteById(code);
        return "Staff deleted successfully.";
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffByCode(String code) {
        return staffRepository.findById(code)
            .orElseThrow(() -> new IllegalArgumentException("Staff not found with code: " + code));
    }
}
