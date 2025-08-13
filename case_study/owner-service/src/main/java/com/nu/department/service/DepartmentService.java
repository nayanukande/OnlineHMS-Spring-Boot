package com.nu.department.service;

import com.nu.department.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department departmentDetails);
    void deleteDepartment(Long id);
}

