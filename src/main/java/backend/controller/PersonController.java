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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import backend.model.Person;
import backend.service.PersonService;

@RestController
@RequestMapping("/person")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class PersonController {

	@Autowired
	PersonService service;
	@ApiOperation(value = "View a list of persons", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllUser() {
		List<Person> userData = service.getUserList();
		return new ResponseEntity<List<Person>>(userData, HttpStatus.OK);
	}

	@ApiOperation(value = "Create new Person",response = Person.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> addNewUser(@RequestBody Person person) {
		Person userData = service.addNewUser(person);
		return new ResponseEntity<Person>(userData, HttpStatus.OK);
	}

	@ApiOperation(value = "Upadte new Person")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<String> updateUser(@RequestBody Person person, @PathVariable Integer id) {
		service.updateUser(person, id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete new Person")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}
