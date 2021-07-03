package com.rajendar.person.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.rajendar.person.entity.Person;
import com.rajendar.person.repository.PersonRepository;
import com.rajendar.person.util.TestConstants;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

  @Mock
  PersonRepository personRepository;

  @InjectMocks
  PersonService personService;

  Person person;

  @BeforeEach
  void setUp() {
    person = new Person(123L, "Rajendar", "Tekula", "Sydney");
  }

  @Test
  void savePerson() {
    when(personRepository.save(Mockito.any())).thenReturn(person);
    assertThat(personService.savePerson(person)).isEqualTo(person);
  }

  @Test
  void findByPersonId() {
    when(personRepository.findByPersonid(Mockito.any())).thenReturn(person);
    assertThat(personService.findByPersonId(123L)).isEqualTo(person);
  }

  @Test
  void findPersons() {
    List<Person> personList = TestConstants.createPersonList();
    when(personRepository.findAll()).thenReturn(personList);
    assertThat(personService.findPersons().size()).isEqualTo(3);
  }
}