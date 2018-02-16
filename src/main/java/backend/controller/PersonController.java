package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Person;
import backend.service.PersonService;


@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
	
	@Autowired
	PersonService service;

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllUser() {
        List<Person> userData = service.getUserList();
        return new ResponseEntity<List<Person>>(userData, HttpStatus.OK);
    }
	
}
