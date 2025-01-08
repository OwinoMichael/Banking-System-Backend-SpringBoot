package com.mike.mike.Person;

import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Integer id){
        Optional<Person> person = personRepository.findById(id);
        return ResponseEntity.ok(person);
    }
}
