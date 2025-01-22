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
public class UpdatePerson implements Command<UpdatePersonParams, SuccessResponse> {

    final private PersonRepository personRepository;

    public UpdatePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdatePersonParams updatePersonParams) {
        Integer id = updatePersonParams.getId();
        Person person = updatePersonParams.getPerson();

        Optional<Person> updatePerson = personRepository.findById(id);
        if(updatePerson.isEmpty()){
            throw new ResourceNotFound("Person");
        }

        person.setId(id);
        personRepository.save(person);

        return ResponseEntity.ok(new SuccessResponse("true", "Person Updated Successfully"));
    }
}
