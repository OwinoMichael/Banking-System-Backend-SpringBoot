package com.mike.mike.Customer;

import com.mike.mike.Customer.CommandHandler.AddCustomer;
import com.mike.mike.Customer.CommandHandler.DeleteCustomer;
import com.mike.mike.Customer.CommandHandler.UpdateCustomer;
import com.mike.mike.Customer.CommandHandler.UpdateCustomerParams;
import com.mike.mike.Customer.QueryHandler.GetAllCustomers;
import com.mike.mike.Customer.QueryHandler.GetCustomer;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final GetAllCustomers getAllCustomers;
    private final GetCustomer getCustomer;
    private final AddCustomer addCustomer;
    private final UpdateCustomer updateCustomer;
    private final DeleteCustomer deleteCustomer;

    public CustomerController(GetAllCustomers getAllCustomers, GetCustomer getCustomer, AddCustomer addCustomer, UpdateCustomer updateCustomer, DeleteCustomer deleteCustomer) {
        this.getAllCustomers = getAllCustomers;
        this.getCustomer = getCustomer;
        this.addCustomer = addCustomer;
        this.updateCustomer = updateCustomer;
        this.deleteCustomer = deleteCustomer;
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        return getAllCustomers.execute(null);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id){
        return getCustomer.execute(id);
    }

    @PostMapping("/add-customers")
    public ResponseEntity<SuccessResponse> addCustomer(@RequestBody Customer customer){
        return addCustomer.execute(customer);
    }

    @PutMapping("/update-customers/{id}")
    public ResponseEntity<SuccessResponse> updateCustomers(@PathVariable Integer id, @RequestBody Customer customer){
        UpdateCustomerParams customerParams = new UpdateCustomerParams();
        customerParams.setId(id);
        customerParams.setCustomer(customer);
        return updateCustomer.execute(customerParams);
    }

    @DeleteMapping("/delete-customers/{id}")
    public ResponseEntity<SuccessResponse> deleteCustomers(@PathVariable Integer id){
        return deleteCustomer.execute(id);
    }
}
