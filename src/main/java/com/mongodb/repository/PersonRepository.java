package com.mongodb.repository;

import com.mongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartsWith(String name);

    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}", fields = "{'address' : 0}")
    List<Person> findPersonByAge(Integer minAge, Integer maxAge);
}


