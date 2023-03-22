/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    
    private final PersonDAO personDao;
    
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDAO personDao){
        this.personDao = personDao;
    }
    
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    
    public List<Person> getAllPeople(){
        return personDao.getAllPeople();
    }
    
    public Optional<Person> getPerson(UUID id){
        return personDao.getPerson(id);
    }
    
    public int deletePerson(UUID id){
        return personDao.deletePerson(id);
    }
    
    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePerson(id, newPerson);
    }
}
