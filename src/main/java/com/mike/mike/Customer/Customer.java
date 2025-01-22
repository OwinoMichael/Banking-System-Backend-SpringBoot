package com.mike.mike.Customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mike.mike.Person.Person;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_type")
    private String customerType;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @MapsId
    @JoinColumn(name = "id")
    private Person person;

    public Customer() {
    }

    public Customer(int id, String customerType, LocalDate createdAt, LocalDate updatedAt, Person person) {
        this.id = id;
        this.customerType = customerType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(customerType, customer.customerType) && Objects.equals(createdAt, customer.createdAt) && Objects.equals(updatedAt, customer.updatedAt) && Objects.equals(person, customer.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerType, createdAt, updatedAt, person);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType='" + customerType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", person=" + person +
                '}';
    }
}
