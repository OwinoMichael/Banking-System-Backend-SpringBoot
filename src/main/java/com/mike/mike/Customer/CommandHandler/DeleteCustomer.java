package com.mike.mike.Customer.CommandHandler;

import com.mike.mike.Command;
import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomer implements Command<Integer, SuccessResponse> {

    private final CustomerRepository customerRepository;

    public DeleteCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<SuccessResponse> execute(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer"));

        customerRepository.delete(customer);

        return ResponseEntity.ok(new SuccessResponse("true", "Customer deleted successfully"));
    }
}
