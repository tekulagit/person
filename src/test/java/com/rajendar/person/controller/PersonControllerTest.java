package com.rajendar.person.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.rajendar.person.entity.Person;
import com.rajendar.person.service.PersonService;
import com.rajendar.person.util.TestConstants;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

  @Mock
  private PersonService personService;

  @InjectMocks
  private PersonController personController;

  Person person;

  @BeforeEach
  void setUp() {
    person = new Person(123L, "Rajendar", "Tekula", "Sydney");
  }

  @Test
  void savePerson() {
    when(personService.savePerson(Mockito.any())).thenReturn(person);
    assertThat(personController.savePerson(person)).isEqualTo( new ResponseEntity<Person>(person,
        HttpStatus.CREATED));
  }

  @Test
  void findPersons() {
    List<Person> personList = TestConstants.createPersonList();
    when(personService.findPersons()).thenReturn(personList);
    assertThat(personController.findPersons().getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(personController.findPersons().getBody().size()).isEqualTo(3);
  }

  @Test
  void findPersonById() {
    when(personService.findByPersonId(Mockito.any())).thenReturn(person);
    assertThat(personController.findPersonById(123L)).isEqualTo(new ResponseEntity<Person>(person, HttpStatus.OK));
  }

}