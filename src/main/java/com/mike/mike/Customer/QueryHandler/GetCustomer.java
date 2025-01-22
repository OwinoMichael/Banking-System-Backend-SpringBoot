package com.mike.mike.Customer.QueryHandler;


import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCustomer implements Query<Integer, Customer> {

    private final CustomerRepository customerRepository;

    public GetCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Customer> execute(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer"));

        return ResponseEntity.ok(customer);
    }
}
