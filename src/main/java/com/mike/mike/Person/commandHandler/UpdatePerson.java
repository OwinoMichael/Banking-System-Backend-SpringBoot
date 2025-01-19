package com.mike.mike.Person.commandHandler;

import com.mike.mike.Command;
import com.mike.mike.Person.Person;
import com.mike.mike.Person.PersonRepository;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePerson implements Command<UpdatePersonCommand, SuccessResponse> {

    final private PersonRepository personRepository;

    public UpdatePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdatePersonCommand updatePersonCommand) {
        Integer id = updatePersonCommand.getId();
        Person person = updatePersonCommand.getPerson();

        Optional<Person> updatePerson = personRepository.findById(id);
        if(updatePerson.isEmpty()){
            throw new RuntimeException("Person Not Found");
        }

        person.setId(id);
        personRepository.save(person);

        return ResponseEntity.ok(new SuccessResponse("true", "Person Updated Successfully"));
    }
}
