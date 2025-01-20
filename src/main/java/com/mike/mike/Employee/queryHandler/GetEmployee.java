package com.mike.mike.Employee.queryHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetEmployee implements Command<Integer, Employee> {

    private final EmployeeRepository employeeRepository;

    public GetEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<Employee> execute(Integer entity) {
        return null;
    }
}
