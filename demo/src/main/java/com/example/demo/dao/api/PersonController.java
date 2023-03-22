/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao.api;

import com.example.demo.service.PersonService;
import com.example.demo.model.Person;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }
    
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    
    @GetMapping(path = "{id}")
    public Person getPerson(@PathVariable("id") UUID id){
        return personService.getPerson(id).orElse(null);
    }
    
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person newPerson){
        personService.updatePerson(id, newPerson);
    }
}
