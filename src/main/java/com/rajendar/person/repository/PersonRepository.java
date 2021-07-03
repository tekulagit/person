package com.rajendar.person.repository;

import com.rajendar.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  Person findByPersonId(Long personId);
}
