package lab2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lab1.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class LoadDataBase {

    public static List<Person> loadPersonList() throws IOException, JsonSyntaxException {
        String personStr = "";
        File file = new File("persons.json");

        if (file.exists()) {
            personStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File persons.json is not found!");
        }

        Gson gson = new Gson();

        Person[] personList = gson.fromJson(personStr, Person[].class);

        return Arrays.asList(personList);
    }
}
