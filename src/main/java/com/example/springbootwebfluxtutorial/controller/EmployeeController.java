package com.example.springbootwebfluxtutorial.controller;

import com.example.springbootwebfluxtutorial.dto.EmployeeDto;
import com.example.springbootwebfluxtutorial.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceImpl;

    //Build reactive REST API to create an employee
    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeServiceImpl.createEmployee(employeeDto);
    }

    //Build reactive REST API to get an employee by id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<EmployeeDto> getEmployee(@PathVariable String id) {
        return employeeServiceImpl.getEmployee(id);
    }

    //Build reactive REST API to get all employees
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<EmployeeDto> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    //Build reactive REST API to update an employee
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<EmployeeDto> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
        return employeeServiceImpl.updateEmployee(id, employeeDto);
    }

    //Build reactive REST API to delete an employee
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteEmployee(@PathVariable String id) {
        return employeeServiceImpl.deleteEmployee(id);
    }

}
