package com.nu.staff.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(unique = true, nullable = false)
    private String code;  // Unique staff code

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private String employeeAddress;

    @Column(nullable = false, unique = true)
    private String nic; // National Identity Card number

    @Column(nullable = false)
    private double salary;

    @Min(18)
    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String occupation;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    public Staff() {}

    public Staff(String code, String employeeName, String employeeAddress, String nic, double salary, int age, String occupation, String email) {
        this.code = code;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.nic = nic;
        this.salary = salary;
        this.age = age;
        this.occupation = occupation;
        this.email = email;
    }

    //Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getEmployeeAddress() { return employeeAddress; }
    public void setEmployeeAddress(String employeeAddress) { this.employeeAddress = employeeAddress; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
