package service;

import model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void removePerson(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
        }
    }
}