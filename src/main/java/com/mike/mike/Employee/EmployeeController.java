package com.mike.mike.Employee;

import com.mike.mike.Employee.commandHandler.AddEmployee;
import com.mike.mike.Employee.commandHandler.DeleteEmployee;
import com.mike.mike.Employee.commandHandler.UpdateEmployee;
import com.mike.mike.Employee.commandHandler.UpdateEmployeeCommand;
import com.mike.mike.Employee.queryHandler.GetAllEmployees;
import com.mike.mike.Employee.queryHandler.GetEmployee;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final GetAllEmployees getAllEmployees;
    private final GetEmployee getEmployee;
    private final AddEmployee addEmployee;
    private final UpdateEmployee updateEmployee;
    private final DeleteEmployee deleteEmployee;

    public EmployeeController(GetAllEmployees getAllEmployees, GetEmployee getEmployee, AddEmployee addEmployee, UpdateEmployee updateEmployee, DeleteEmployee deleteEmployee) {
        this.getAllEmployees = getAllEmployees;
        this.getEmployee = getEmployee;
        this.addEmployee = addEmployee;
        this.updateEmployee = updateEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return getAllEmployees.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        return getEmployee.execute(id);
    }

    @PostMapping("/add-employee")
    public ResponseEntity<SuccessResponse> addEmployee(@RequestBody Employee employee){
        return addEmployee.execute(employee);
    }

    @PutMapping("/update-employee/{id}")
    public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        UpdateEmployeeCommand updateCommand = new UpdateEmployeeCommand(id, employee);
        return updateEmployee.execute(updateCommand);
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable Integer id){
        return deleteEmployee.execute(id);
    }
}
