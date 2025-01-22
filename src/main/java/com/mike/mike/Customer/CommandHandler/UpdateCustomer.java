package com.mike.mike.Customer.CommandHandler;

import com.mike.mike.Command;
import com.mike.mike.Customer.Customer;
import com.mike.mike.Customer.CustomerRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomer implements Command<UpdateCustomerParams, SuccessResponse> {

    private final CustomerRepository customerRepository;

    public UpdateCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdateCustomerParams customerParams) {
        Integer id = customerParams.getId();
        Customer customer = customerParams.getCustomer();

        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer"));

        customerRepository.save(customer);

        return ResponseEntity.ok(new SuccessResponse("true", "Customer Updated"));
    }
}
