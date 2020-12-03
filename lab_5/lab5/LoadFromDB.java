package lab5;

import com.google.gson.JsonSyntaxException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadFromDB {

    public static String loadClient(Connection connection) throws JsonSyntaxException, SQLException {

        String pStr = "";
        PreparedStatement statement =
                connection.prepareStatement("select clients from shop ");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("clients");
        }

        statement.close();

        return pStr;
    }

    public static String loadProducts(Connection connection) throws JsonSyntaxException, SQLException {

        String pStr = "";
        PreparedStatement statement =
                connection.prepareStatement("select products from shop");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("products");
        }

        statement.close();

        return pStr;
    }

}