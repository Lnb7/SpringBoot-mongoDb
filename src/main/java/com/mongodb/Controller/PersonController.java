package com.mongodb.Controller;

import com.mongodb.collection.Person;
import com.mongodb.service.PersonService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping("/{name}")
    public List<Person> getPersonStartWith(@PathVariable("name") String name){
        return personService.getPersonStartWith(name);
    }

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.finsAllPerson();
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id){
        personService.deletePerson(id);
    }

    @GetMapping("/{minAge}/{maxAge}")
    public List<Person> getPersonByAge(@PathVariable Integer minAge, @PathVariable Integer maxAge){
        return personService.findPersonByAge(minAge,maxAge);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return personService.search(name,minAge,maxAge,city,pageable);
    }

    @GetMapping("/oldestPerson")
    public List<Document> getOlderstPerson(){
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/population")
    public List<Document> getPopulationByCity(){
        return personService.getPopulationByCity();
    }
}
