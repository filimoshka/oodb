package lab4;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lab4.model.Person;
import lab4.model.Shop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class LoadFromDB {

    public static Shop load() throws IOException {
        Shop shop = null;
        String shopStr = "";
        File file = new File("shop.json");

        if (file.exists()) {
            shopStr = new String(Files.readAllBytes(file.toPath()));
        }

        shop = new Gson().fromJson(shopStr, Shop.class);

        return shop;
    }

    /**
     * Пример чтения из файла массива JSON объектов
     */
    public static List<Person> loadPersonList(Connection connection) throws JsonSyntaxException, SQLException {
        String pStr = "";

        PreparedStatement statement =
                connection.prepareStatement("select cnt_json from person");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("cnt_json");
            System.out.println(pStr);
        }
        statement.close();

        Gson gson = new Gson();

        Person[] plst = gson.fromJson(pStr, Person[].class);


        statement =
                connection.prepareStatement("select cnt_json as cnt_jsonb from person ");

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("cnt_jsonb");
            System.out.println(pStr);
        }

        return Arrays.asList(plst);
    }
}