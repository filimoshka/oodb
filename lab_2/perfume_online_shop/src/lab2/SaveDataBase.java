package lab2;

import com.google.gson.Gson;
import lab1.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class SaveDataBase {
    public static void savePersonList(List<Person> persons) throws IOException {

        if (persons != null && persons.size() > 0) {
            Gson gson = new Gson();

            String personsAsJson = gson.toJson(persons);

            System.out.println(personsAsJson);

            try (OutputStream os = new FileOutputStream(new File("persons.json"))) {
                os.write(personsAsJson.getBytes("UTF-8"));
                os.flush();
            }

        }
    }

}
