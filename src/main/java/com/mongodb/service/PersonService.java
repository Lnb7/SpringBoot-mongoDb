package com.mongodb.service;

import com.mongodb.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    List<Person> finsAllPerson();

    void deletePerson(String id);

    List<Person> findPersonByAge(Integer minAge, Integer maxAge);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getPopulationByCity();

    List<Document> getOldestPersonByCity();
}
