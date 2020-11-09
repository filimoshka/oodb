package lab4;

import lab4.model.Person;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/oodb", "postgres", "pst5326gr");

            LoadFromDB.loadPersonList(connection);

            List<Person> persons = LoadFromFile.loadPersonList();

            persons.forEach(System.out::println);

            Person prs = PersonService.findPersonByName(persons, "Alexander");

            if (prs != null) {
                prs.setPhoneNumber("+71111111111");
                prs.setEmail("alex@mail.ru");
            }


            SaveDB.savePersonList(persons, connection);


            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}