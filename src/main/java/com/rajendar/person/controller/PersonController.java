package com.rajendar.person.controller;

import com.rajendar.person.entity.Person;
import com.rajendar.person.service.PersonService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revenueNSW")
@Slf4j
public class PersonController {

  @Autowired
  private PersonService personService;

  @RequestMapping(value = "/persons", method = RequestMethod.POST)
  public ResponseEntity<Person> savePerson(@RequestBody Person person){
    log.info("Inside savePerson method of PersonController");
    Person personResponse = personService.savePerson(person);
    return new ResponseEntity<Person>(personResponse, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/persons", method = RequestMethod.GET)
  public ResponseEntity<List<Person>> findPersons(){
    log.info("Inside findPersons method of PersonController");
    List<Person> personsList = personService.findPersons();
    return new ResponseEntity<List<Person>>(personsList, HttpStatus.OK);
  }

  @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
  public ResponseEntity findPersonById(@PathVariable( value = "id") Long personId){
    log.info("Inside findPersonById method of PersonController");
    Person person = personService.findByPersonId(personId);
    return new ResponseEntity<Person>(person, HttpStatus.OK);
  }

}
