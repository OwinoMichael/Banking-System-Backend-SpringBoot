package com.mike.mike.Person.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePerson implements Command<Integer, SuccessResponse> {

    final private PersonRepository personRepository;

    public DeletePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Integer id) {
        Optional<Person> personDeleted = personRepository.findById(id);
        if(personDeleted.isEmpty()){
            throw new ResourceNotFound("Person");
        }

        Person person = personRepository.findById(id).get();
        personRepository.delete(person);

        return ResponseEntity.ok(new SuccessResponse("true", "Person deleted successfully"));
    }
}
