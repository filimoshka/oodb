package lab7;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ScanDB {

    private static Connection connection;

    public static HashMap<String, HashSet<String>> returnTables() {
        // Структура для хранения имен таблиц и полей (в HashSet)
        HashMap<String, HashSet<String>> tables = new HashMap<>();

        try(Connection connection = getConnection()) {

            List<String> tbls = getTables(connection);

            for (String table : tbls) {
                List<String> fields = getFields(connection, table);

                HashSet<String> hashSetFields = new HashSet<>();
                fields.forEach(f->{
                    hashSetFields.add(f);
                });

                tables.put(table, hashSetFields);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        Class.forName("org.postgresql.Driver");
        String dbURL = "jdbc:postgresql://localhost:5433/oodb_lab7";
        connection = DriverManager.getConnection( dbURL, "postgres", "pst5326gr");

        return connection;
    }

    public static List<String> getTables(Connection connection) throws SQLException {

        List<String> lst = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement(
                "SELECT table_name FROM information_schema.tables " +
                "WHERE table_type = 'BASE TABLE' AND" +
                " table_schema NOT IN ('pg_catalog', 'information_schema')");

        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
            String s = resultSet.getString("table_name");
            lst.add(s);
        }

        st.close();
        return lst;
    }

    public static List<String> getFields(Connection connection, String tableName) throws SQLException {

        List<String> lst = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement(
                "SELECT a.attname " +
                        "FROM pg_catalog.pg_attribute a " +
                        "WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c " +
                        "LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
                        " WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = ? )" +
                        " AND a.attnum > 0 AND NOT a.attisdropped");

        st.setString(1, tableName);
        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
            String s = resultSet.getString("attname");
            lst.add(s);
        }

        st.close();
        return lst;
    }

}
