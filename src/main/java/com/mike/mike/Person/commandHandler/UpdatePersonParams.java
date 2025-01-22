package com.mike.mike.Person.commandHandler;

import com.mike.mike.Person.Person;

public class UpdatePersonParams {
    private Integer id;
    private Person person;

    public UpdatePersonParams() {
    }

    public UpdatePersonParams(Integer id, Person person) {
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
