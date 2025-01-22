package com.mike.mike.Employee.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.Person.Person;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteEmployee implements Command<Integer, SuccessResponse> {

    private final EmployeeRepository employeeRepository;

    public DeleteEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Integer id) {
        Employee findEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee"));

        employeeRepository.delete(findEmployee);

        return ResponseEntity.ok(new SuccessResponse("true", "Employee Deleted Successfully"));


    }
}
