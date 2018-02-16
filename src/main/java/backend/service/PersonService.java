package backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Person;
import backend.repository.PeopleRepository;

@Service
public class PersonService {
	@Autowired
	PeopleRepository repo;
	
	public List<Person> getUserList() {
		List<Person> users = new ArrayList<>();
		repo.findAll().forEach(users::add);
		return users;

	}

}
