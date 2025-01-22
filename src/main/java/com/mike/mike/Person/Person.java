package com.mike.mike.Person;

import com.mike.mike.Customer.Customer;
import com.mike.mike.Employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "tax_identifier")
    private String taxIdentifier;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserTypeEnum userTypeEnum;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Employee employee;

    public Person() {
    }

    public Person(Integer id, String lastName, String firstName, LocalDate dob, String email, String phoneNumber, String address, String taxIdentifier, LocalDate createdAt, LocalDate updatedAt, UserTypeEnum userTypeEnum, Customer customer) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.taxIdentifier = taxIdentifier;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userTypeEnum = userTypeEnum;
        this.customer = customer;
    }

    public Person(Integer id, String lastName, String firstName, LocalDate dob, String email, String phoneNumber, String address, String taxIdentifier, LocalDate createdAt, LocalDate updatedAt, UserTypeEnum userTypeEnum, Employee employee) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.taxIdentifier = taxIdentifier;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userTypeEnum = userTypeEnum;
        this.employee = employee;
    }

    public Person(Integer id, String lastName, String firstName, LocalDate dob, String email, String phoneNumber, String address, String taxIdentifier, LocalDate createdAt, LocalDate updatedAt, UserTypeEnum userTypeEnum, Customer customer, Employee employee) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.taxIdentifier = taxIdentifier;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userTypeEnum = userTypeEnum;
        this.customer = customer;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxIdentifier() {
        return taxIdentifier;
    }

    public void setTaxIdentifier(String taxIdentifier) {
        this.taxIdentifier = taxIdentifier;
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

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(dob, person.dob) && Objects.equals(email, person.email) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(address, person.address) && Objects.equals(taxIdentifier, person.taxIdentifier) && Objects.equals(createdAt, person.createdAt) && Objects.equals(updatedAt, person.updatedAt) && userTypeEnum == person.userTypeEnum && Objects.equals(customer, person.customer) && Objects.equals(employee, person.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, dob, email, phoneNumber, address, taxIdentifier, createdAt, updatedAt, userTypeEnum, customer, employee);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", taxIdentifier='" + taxIdentifier + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userTypeEnum=" + userTypeEnum +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}
