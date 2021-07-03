package com.rajendar.person.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  @Id
  private Long personid;
  private String firstname;
  private String lastname;
  private String address;

}
