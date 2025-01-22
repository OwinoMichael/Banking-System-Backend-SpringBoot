package com.mike.mike.Employee.queryHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEmployees implements Command<Void, List<Employee>> {

    private final EmployeeRepository employeeRepository;

    public GetAllEmployees(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<List<Employee>> execute(Void Input) {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }
}
