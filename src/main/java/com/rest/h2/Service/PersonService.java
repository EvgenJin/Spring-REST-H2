package com.rest.h2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.rest.h2.dao.PersonDao;
import com.rest.h2.entity.Person;
import java.util.Optional;


@Service
public class PersonService {
    @Autowired
    PersonDao personDao;
    
    public List<Person> getAll() {
        return this.personDao.findAll();
    }
    public Optional<Person> getById(int id) {
        return this.personDao.findById(id);
    }
    public Person addPerson (Person person) {
        return this.personDao.save(person);
    }
    public Person updateUser(Person person) {
        return this.personDao.save(person);
    }
    public void deleteUserById(int id) {
        this.personDao.deleteById(id);
    }    
}