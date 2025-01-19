package com.mike.mike.Person;

import com.mike.mike.Person.commandHandler.AddPerson;
import com.mike.mike.Person.commandHandler.DeletePerson;
import com.mike.mike.Person.commandHandler.UpdatePerson;
import com.mike.mike.Person.commandHandler.UpdatePersonCommand;
import com.mike.mike.Person.queryHandler.GetAllPersons;
import com.mike.mike.Person.queryHandler.GetPerson;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;
    private final GetPerson fetchPerson;
    private final GetAllPersons fetchAllPersons;
    private final AddPerson addPerson;
    private final UpdatePerson updatePerson;
    private final DeletePerson deletePerson;

    public PersonController(PersonRepository personRepository,
                            GetPerson fetchPerson,
                            GetAllPersons fetchAllPersons,
                            AddPerson addPerson,
                            UpdatePerson updatePerson,
                            DeletePerson deletePerson) {
        this.personRepository = personRepository;
        this.fetchPerson = fetchPerson;
        this.fetchAllPersons = fetchAllPersons;
        this.addPerson = addPerson;
        this.updatePerson = updatePerson;
        this.deletePerson = deletePerson;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){

        return fetchAllPersons.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return fetchPerson.execute(id);
    }

    @PostMapping("/add-person")
    public ResponseEntity<SuccessResponse> addPerson(@RequestBody Person person){
        return addPerson.execute(person);
    }

    @PutMapping("/update-person/{id}")
    public ResponseEntity<SuccessResponse> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        UpdatePersonCommand updatePersonCommand = new UpdatePersonCommand(id, person);

        return updatePerson.execute(updatePersonCommand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deletePerson(@PathVariable Integer id){
        return deletePerson.execute(id);
    }
}
