package com.mike.mike.Person.queryHandler;

import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPerson implements Query<Integer, Person> {

    private final PersonRepository personRepository;

    public GetPerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<Person> execute(Integer id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Person"));
        return ResponseEntity.ok(person);
    }
}
