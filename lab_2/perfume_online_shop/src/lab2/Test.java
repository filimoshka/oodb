package lab2;

import lab1.Person;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {

            List<Person> persons = LoadDataBase.loadPersonList();

            persons.forEach(System.out::println);

            Person person = PersonService.findPerson(persons, "Alexander");

            if (person != null) {
                person.setPhoneNumber("+79170000000");
                person.setEmail("alex@gmail.com");
            }

            SaveDataBase.savePersonList(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
