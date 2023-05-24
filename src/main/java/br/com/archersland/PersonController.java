package br.com.archersland;

import br.com.archersland.model.Person;
import br.com.archersland.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;
//	private PersonServices service = new PersonServices();

	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Person> findAll() {
		return service.findAll();
	}
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person findPersonById(@PathVariable(value = "id") String id) {
		return service.findPersonById(id);
	}

	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.DELETE
	)
	public void delete(@PathVariable(value = "id") String id) {
		service.delete(id);
	}

	@RequestMapping(
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}

	@RequestMapping(
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
}