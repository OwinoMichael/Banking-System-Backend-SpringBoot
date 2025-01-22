package com.mike.mike.Employee.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.Person.UserTypeEnum;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddEmployee implements Command<Employee, SuccessResponse> {

    private final EmployeeRepository employeeRepository;
    private final PersonRepository personRepository;

    public AddEmployee(EmployeeRepository employeeRepository, PersonRepository personRepository) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Employee employee) {
        employeeRepository.save(employee);

        Person person = employee.getPerson();

        if(person != null){
            person.setUserTypeEnum(UserTypeEnum.EMPLOYEE);

            personRepository.save(person);
        }

        return ResponseEntity.ok(new SuccessResponse("true", "Employee Added Successfully"));
    }
}
