package com.example.springbootwebfluxtutorial.entity;

import com.example.springbootwebfluxtutorial.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;

    public Employee(EmployeeDto employeeDto) {
        this.firstname = employeeDto.firstname();
        this.lastname = employeeDto.lastname();
        this.email = employeeDto.email();
    }
}
