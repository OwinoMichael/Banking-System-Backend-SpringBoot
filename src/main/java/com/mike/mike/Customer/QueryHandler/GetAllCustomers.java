package com.mike.mike.Customer.QueryHandler;

import com.mike.mike.Account.Account;
import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.Customer.CustomerResponseDTO;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonResponseDTO;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCustomers implements Query<Void, List<CustomerResponseDTO>> {

    private final CustomerRepository customerRepository;

    public GetAllCustomers(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<List<CustomerResponseDTO>> execute(Void input) {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerDTOs = customers.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(customerDTOs);
    }

    private CustomerResponseDTO convertToDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setCustomerType(customer.getCustomerType());
        dto.setCreatedAt(customer.getCreatedAt());
        dto.setUpdatedAt(customer.getUpdatedAt());

        Person person = customer.getPerson();
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

        List<Long> accountIds = customer.getAccounts().stream()
                .map(Account::getAccountId)  // Ensure Account has a getAccountId() method
                .collect(Collectors.toList());

        dto.setAccounts(accountIds);

        return dto;
    }

}



