package com.mike.mike.Employee.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployee implements Command<UpdateEmployeeParams, SuccessResponse> {

    private final EmployeeRepository employeeRepository;

    public UpdateEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdateEmployeeParams updateEmployee) {
        Integer id = updateEmployee.getId();
        Employee employee = updateEmployee.getEmployee();

        Employee findPerson = employeeRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFound("Employee"));

        employee.setId(id);
        employeeRepository.save(employee);

        return ResponseEntity.ok(new SuccessResponse("true", "Employee Update Successfully"));
    }
}
