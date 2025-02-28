package com.mike.mike.Employee;

import com.mike.mike.Person.PersonResponseDTO;

import java.time.LocalDate;

public class EmployeeResponseDTO {
    private Integer id;
    private String position;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private PersonResponseDTO person;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(Integer id, String position, LocalDate createdAt, LocalDate updatedAt, PersonResponseDTO person) {
        this.id = id;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
