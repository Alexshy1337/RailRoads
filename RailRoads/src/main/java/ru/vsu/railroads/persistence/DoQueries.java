package ru.vsu.railroads.persistence;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/trainsdb?useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private static final String USER = "alex";
    private static final String PASS = "777";

    interface Mapper<R> {
        List<R> foo(ResultSet rs) throws SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException;
    }

    public static <T> List<T> executeSelectQuery(String query, Mapper<T> mapper) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(query);
            return mapper.foo(resultSet);
        } catch (SQLException e) {
            System.out.println("Connection error\n");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

    public static boolean executeNonSelectQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println("Connection error\n");
            e.printStackTrace();
        }
        return false;
    }
}
