package com.rajendar.person.service;

import com.rajendar.person.entity.Person;
import com.rajendar.person.repository.PersonRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public Person savePerson(Person person) {
    log.info("Inside savePerson method of PersonService");
    return personRepository.save(person);
  }

  public Person findByPersonId(Long personId) {
    log.info("Inside findPersonById method of PersonService");
   return personRepository.findByPersonId(personId);

  }

  public List<Person> findPersons() {
    log.info("Inside findPersons method of PersonService");
    return personRepository.findAll();
  }
}
