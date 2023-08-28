package com.example.springbootwebfluxtutorial.service;

import com.example.springbootwebfluxtutorial.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDto> createEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String id);
    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(String id, EmployeeDto employeeDto);
    Mono<Void> deleteEmployee(String id);
}
