package com.codeclan.file.folders.controllers;

import com.codeclan.file.folders.models.Person;
import com.codeclan.file.folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
