package com.mike.mike.Employee.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployee implements Command<UpdateEmployeeCommand, SuccessResponse> {

    private final EmployeeRepository employeeRepository;

    public UpdateEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdateEmployeeCommand entity) {
        return null;
    }
}
