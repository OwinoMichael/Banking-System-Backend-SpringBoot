package com.mike.mike.Employee.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddEmployee implements Command<Employee, SuccessResponse> {

    private final EmployeeRepository employeeRepository;

    public AddEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Employee employee) {
        employeeRepository.save(employee);

        return ResponseEntity.ok(new SuccessResponse("true", "Employee Added Successfully"));
    }
}
