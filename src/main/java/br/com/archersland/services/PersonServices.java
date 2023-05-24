package br.com.archersland.services;

import br.com.archersland.exceptions.ResourceNotFoundException;
import br.com.archersland.model.Person;
import br.com.archersland.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;


    public List<Person> findAll() {
        logger.info("Finding all people...");
        return repository.findAll();
    }

    public Person findPersonById(Long id) {
        logger.info("Finding one person...");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + id));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + person.getId()));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting person id: " + id + " ...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + id));
        repository.delete(entity);
    }
}
