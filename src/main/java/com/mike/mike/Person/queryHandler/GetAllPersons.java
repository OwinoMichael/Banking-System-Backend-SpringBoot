package com.mike.mike.Person.queryHandler;

import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPersons implements Query<Void, List<Person>> {
    private final PersonRepository personRepository;

    public GetAllPersons(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public ResponseEntity<List<Person>> execute(Void input) {
        List<Person> person = personRepository.findAll();
        return ResponseEntity.ok(person);
    }

}
