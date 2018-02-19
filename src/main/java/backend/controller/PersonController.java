package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Person;
import backend.service.PersonService;

@RestController
@RequestMapping("/person")
@io.swagger.annotations.Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class PersonController {

	@Autowired
	PersonService service;
	@io.swagger.annotations.ApiOperation(value = "View a list of persons", response = Iterable.class)
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllUser() {
		List<Person> userData = service.getUserList();
		return new ResponseEntity<List<Person>>(userData, HttpStatus.OK);
	}

	@io.swagger.annotations.ApiOperation(value = "Create new Person",response = Person.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> addNewUser(@RequestBody Person person) {
		Person userData = service.addNewUser(person);
		return new ResponseEntity<Person>(userData, HttpStatus.OK);
	}

	@io.swagger.annotations.ApiOperation(value = "Upadte new Person")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<String> updateUser(@RequestBody Person person, @PathVariable Integer id) {
		service.updateUser(person, id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@io.swagger.annotations.ApiOperation(value = "Delete new Person")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}
