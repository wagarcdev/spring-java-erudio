package br.com.archersland.services;

import br.com.archersland.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        logger.info("Finding all people...");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findPersonById(String id) {
        logger.info("Finding one person...");
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Wagner");
        person.setLastName("Arcieri");
        person.setAddress("Floripaaaa");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting person id: " + id + " ...");
    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Floripaaaa " + i);
        person.setGender("Male");
        return person;
    }

}
