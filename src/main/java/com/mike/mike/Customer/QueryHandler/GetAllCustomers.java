package com.mike.mike.Customer.QueryHandler;

import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCustomers implements Query<Void, List<Customer>> {

    private final CustomerRepository customerRepository;

    public GetAllCustomers(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<List<Customer>> execute(Void input) {
        List<Customer> customers = customerRepository.findAll();

        return ResponseEntity.ok(customers);
    }
}
