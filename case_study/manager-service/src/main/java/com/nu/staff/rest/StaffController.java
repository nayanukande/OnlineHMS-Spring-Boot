package com.nu.staff.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nu.staff.entity.Staff;
import com.nu.staff.service.StaffService;
import java.util.List;

@RestController
@RequestMapping("/manager/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    //Add Staff
    @PostMapping("/addStaff")
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    //Update Staff
    @PutMapping("/{code}")
    public Staff updateStaff(@PathVariable String code, @RequestBody Staff staffDetails) {
        return staffService.updateStaff(code, staffDetails);
    }

    //Delete Staff
    @DeleteMapping("/{code}")
    public String deleteStaff(@PathVariable String code) {
        return staffService.deleteStaff(code);
    }

    //Get All Staff
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    //Get Staff by Code
    @GetMapping("/{code}")
    public Staff getStaffByCode(@PathVariable String code) {
        return staffService.getStaffByCode(code);
    }
}
