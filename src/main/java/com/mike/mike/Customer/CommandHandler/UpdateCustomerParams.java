package com.mike.mike.Customer.CommandHandler;

import com.mike.mike.Customer.Customer;

public class UpdateCustomerParams {

    private Integer id;
    private Customer customer;

    public UpdateCustomerParams(Integer id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public UpdateCustomerParams() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
