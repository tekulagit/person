package com.rajendar.person.util;


import com.rajendar.person.entity.Person;
import java.util.ArrayList;
import java.util.List;

public class TestConstants {

  public static List<Person> createPersonList() {
    List<Person> personList = new ArrayList<>();
    Person p = new Person(123L, "Raj", "Tekula", "Sydney");
    Person p1 = new Person(456L, "Mahi", "Tekula", "Hyderabad");
    Person p2 = new Person(789L, "Sai", "Tekula", "Hyderabad");
    personList.add(p);
    personList.add(p1);
    personList.add(p2);
    return personList;
  }

}
