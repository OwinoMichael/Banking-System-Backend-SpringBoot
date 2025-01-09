package com.mike.mike.Person;

import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePerson(@PathVariable Integer id){
        Optional<Person> personDeleted = personRepository.findById(id);
        if(personDeleted.isEmpty()){
            throw new RuntimeException("Person Does not exist");
        }

        Person person = personRepository.findById(id).get();
        personRepository.delete(person);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Person Deleted Successfully");
        response.put("person", person.toString());

        return ResponseEntity.ok(response);
    }
}
