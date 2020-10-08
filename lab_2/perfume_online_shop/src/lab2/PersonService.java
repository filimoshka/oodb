package lab2;

import lab1.Person;

import java.util.List;

public class PersonService {
        public static Person findPerson(List<Person> persons, String searchByName) {
            Person result = null;

            for (Person person : persons) {
                if (person.getFirstName().equals(searchByName)) {
                    result = person;
                }
            }

            return result;
        }
}
