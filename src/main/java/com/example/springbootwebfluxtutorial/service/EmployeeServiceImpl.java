package com.example.springbootwebfluxtutorial.service;

import com.example.springbootwebfluxtutorial.dto.EmployeeDto;
import com.example.springbootwebfluxtutorial.entity.Employee;
import com.example.springbootwebfluxtutorial.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> createEmployee(EmployeeDto employeeDto) {
        // Convert EmployeeDto to Employee
        Employee employee = new Employee(employeeDto);
        // Save Employee in DB
        Mono<Employee> savedEmployee =  employeeRepository.save(employee);
        return savedEmployee.map((Employee emp) -> new EmployeeDto(emp));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String id) {
        Mono<Employee> employee = employeeRepository.findById(id);
        return employee.map((Employee emp) -> new EmployeeDto(emp));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employees = employeeRepository.findAll();
        return employees.map((Employee emp) -> new EmployeeDto(emp));
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(String id, EmployeeDto employeeDto) {
        Mono<Employee> employee = employeeRepository.findById(id);
        Mono<Employee> updatedEmployee = employee.flatMap((Employee emp) -> {
            emp.setFirstname(employeeDto.firstname());
            emp.setLastname(employeeDto.lastname());
            emp.setEmail(employeeDto.email());
            return employeeRepository.save(emp);
        });
        return updatedEmployee.map((Employee emp) -> new EmployeeDto(emp));
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }


}
