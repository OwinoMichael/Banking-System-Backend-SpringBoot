package com.mike.mike.Person.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddPerson implements Command<Person, SuccessResponse> {

    private final PersonRepository personRepository;

    public AddPerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Person person) {
        personRepository.save(person);
        return ResponseEntity.ok(new SuccessResponse("true", "Person added Successfully"));
    }
}
