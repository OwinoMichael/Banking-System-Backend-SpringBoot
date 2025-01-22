package com.mike.mike.Customer.CommandHandler;

import com.mike.mike.Command;
import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.Person.UserTypeEnum;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddCustomer implements Command<Customer, SuccessResponse> {

    private final CustomerRepository customerRepository;
    private final PersonRepository personRepository;

    public AddCustomer(CustomerRepository customerRepository, PersonRepository personRepository) {
        this.customerRepository = customerRepository;
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Customer customer) {

        customerRepository.save(customer);

        Person person = customer.getPerson();

        if(person != null){
            person.setUserTypeEnum(UserTypeEnum.CUSTOMER);

            personRepository.save(person);
        }

        return ResponseEntity.ok().body(new SuccessResponse("true", "Customer added successfully"));
    }
}
