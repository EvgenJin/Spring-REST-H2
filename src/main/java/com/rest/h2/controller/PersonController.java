package com.rest.h2.controller;
 
import com.rest.h2.dao.PersonDao;
import com.rest.h2.entity.Person;
import com.rest.h2.Service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person") 
public class PersonController {
    @Autowired
    PersonService personService;
    PersonDao personDao;

// get All    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> all() {
        return this.personService.getAll();
    }
// get one by ID    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Person> id(@PathVariable int id) {
        return this.personService.getById(id);
    }
// add
    @RequestMapping(value = "/add", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person add(@RequestBody Person person) {
        return this.personService.addPerson(person);
    }
// update
    @RequestMapping(value = "/update", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return this.personService.updatePerson(person);
    }
    
// delete  
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        this.personService.deletePersonById(id);
    }
// get querry
    @RequestMapping(value = "/querry/{id}", method = RequestMethod.GET)
    public List<Person> querry(@PathVariable int id) {
        return this.personService.getQuerry(id);
    }    
}
