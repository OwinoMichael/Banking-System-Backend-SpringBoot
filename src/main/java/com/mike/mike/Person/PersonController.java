package com.mike.mike.Person;

import com.mike.mike.Person.commandHandler.AddPerson;
import com.mike.mike.Person.commandHandler.DeletePerson;
import com.mike.mike.Person.commandHandler.UpdatePerson;
import com.mike.mike.Person.commandHandler.UpdatePersonParams;
import com.mike.mike.Person.queryHandler.GetAllPersons;
import com.mike.mike.Person.queryHandler.GetPerson;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final GetPerson fetchPerson;
    private final GetAllPersons fetchAllPersons;
    private final AddPerson addPerson;
    private final UpdatePerson updatePerson;
    private final DeletePerson deletePerson;

    public PersonController(GetPerson fetchPerson,
                            GetAllPersons fetchAllPersons,
                            AddPerson addPerson,
                            UpdatePerson updatePerson,
                            DeletePerson deletePerson) {
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
        UpdatePersonParams updatePersonParams = new UpdatePersonParams(id, person);

        return updatePerson.execute(updatePersonParams);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deletePerson(@PathVariable Integer id){
        return deletePerson.execute(id);
    }
}
