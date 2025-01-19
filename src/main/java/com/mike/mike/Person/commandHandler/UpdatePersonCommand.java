package com.mike.mike.Person.commandHandler;

import com.mike.mike.Person.Person;
import jakarta.persistence.Entity;

public class UpdatePersonCommand {
    private Integer id;
    private Person person;

    public UpdatePersonCommand() {
    }

    public UpdatePersonCommand(Integer id, Person person) {
        this.id = id;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
