package com.mike.mike.Customer;

import com.mike.mike.Person.PersonResponseDTO;

import java.time.LocalDate;

public class CustomerResponseDTO {
    private Integer id;
    private String customerType;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private PersonResponseDTO person;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(Integer id, String customerType, LocalDate createdAt, LocalDate updatedAt, PersonResponseDTO person) {
        this.id = id;
        this.customerType = customerType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PersonResponseDTO getPerson() {
        return person;
    }

    public void setPerson(PersonResponseDTO person) {
        this.person = person;
    }
}
