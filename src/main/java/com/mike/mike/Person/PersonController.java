package com.mike.mike.Person;

import com.mike.mike.Person.commandHandler.AddPerson;
import com.mike.mike.Person.queryHandler.GetAllPersons;
import com.mike.mike.Person.queryHandler.GetPerson;
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
    private final GetPerson fetchPerson;
    private final GetAllPersons fetchAllPersons;
    private final AddPerson addPerson;

    public PersonController(PersonRepository personRepository, GetPerson fetchPerson, GetAllPersons fetchAllPersons, AddPerson addPerson) {
        this.personRepository = personRepository;
        this.fetchPerson = fetchPerson;
        this.fetchAllPersons = fetchAllPersons;
        this.addPerson = addPerson;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){

        return fetchAllPersons.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Integer id){
        return fetchPerson.execute(id);
    }

    @PostMapping("/add-person")
    public ResponseEntity<SuccessResponse> addPerson(@RequestBody Person person){
        return addPerson.execute(person);
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
