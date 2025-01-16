package com.mike.mike.Person;

import com.mike.mike.SuccessResponse.SuccessResponse;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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

    @PostMapping("/add-person")
    public ResponseEntity<SuccessResponse> addPerson(@RequestBody Person person){
        personRepository.save(person);
        return ResponseEntity.ok(new SuccessResponse("true", "Record added successfully"));
    }

    @PutMapping("/update-person/{id}")
    public ResponseEntity<SuccessResponse> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        Optional<Person> findPerson = personRepository.findById(id);
        if(findPerson.isEmpty()){
            throw new RuntimeException("Person not found");
        }

        person.setId(id);
        personRepository.save(person);



        return ResponseEntity.ok(new SuccessResponse("true", "Person updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deletePerson(@PathVariable Integer id){
        Optional<Person> personDeleted = personRepository.findById(id);
        if(personDeleted.isEmpty()){
            throw new RuntimeException("Person Does not exist");
        }

        Person person = personRepository.findById(id).get();
        personRepository.delete(person);

        return ResponseEntity.ok(new SuccessResponse("true", "Person deleted successfully"));
    }
}
