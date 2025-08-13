package com.nu.department.service;

import com.nu.department.entity.Department;
import com.nu.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Department updateDepartment(Long id, Department departmentDetails) {
        return departmentRepository.findById(id)
                .map(dept -> {
                    dept.setName(departmentDetails.getName());
                    dept.setDescription(departmentDetails.getDescription());
                    return departmentRepository.save(dept);
                })
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
