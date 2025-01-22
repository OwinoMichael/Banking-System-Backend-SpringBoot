package com.mike.mike.Customer.CommandHandler;

import com.mike.mike.Command;
import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddCustomer implements Command<Customer, SuccessResponse> {

    private final CustomerRepository customerRepository;

    public AddCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Customer customer) {

        customerRepository.save(customer);

        return ResponseEntity.ok().body(new SuccessResponse("true", "Customer added successfully"));
    }
}
