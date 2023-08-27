package com.example.springbootwebfluxtutorial.dto;

import com.example.springbootwebfluxtutorial.entity.Employee;

public record EmployeeDto(
        String id,
        String firstname,
        String lastname,
        String email
) {
    public EmployeeDto(Employee employee) {
        this(employee.getId(), employee.getFirstname(), employee.getLastname(), employee.getEmail());
    }
}
