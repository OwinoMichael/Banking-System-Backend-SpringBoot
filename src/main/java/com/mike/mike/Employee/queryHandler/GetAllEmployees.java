package com.mike.mike.Employee.queryHandler;

import com.mike.mike.Branch.Branch;
import com.mike.mike.Command;
import com.mike.mike.Employee.Employee;
import com.mike.mike.Employee.EmployeeRepository;
import com.mike.mike.Employee.EmployeeResponseDTO;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllEmployees implements Command<Void, List<EmployeeResponseDTO>> {

    private final EmployeeRepository employeeRepository;

    public GetAllEmployees(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<List<EmployeeResponseDTO>> execute(Void input) {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeDTOs = employees.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(employeeDTOs);
    }

    private EmployeeResponseDTO convertToDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setPosition(employee.getPosition());
        dto.setCreatedAt(employee.getCreatedAt());
        dto.setUpdatedAt(employee.getUpdatedAt());
        dto.setBranch(employee.getBranch());

        Person person = employee.getPerson();
        if (person != null) {
            PersonResponseDTO personDTO = new PersonResponseDTO();
            personDTO.setPersonId(person.getId());
            personDTO.setLastName(person.getLastName());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setEmail(person.getEmail());
            personDTO.setPhoneNumber(person.getPhoneNumber());
            personDTO.setAddress(person.getAddress());
            dto.setPerson(personDTO);
        }



        return dto;
    }
}
