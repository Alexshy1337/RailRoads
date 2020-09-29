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
    private static final String USER = "root";
    private static final String PASS = "";

    interface Mapper<R> {
        List<R> foo(ResultSet rs) throws SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException;
    }

    public static <T> List<T> executeSelectQuery(String query, Mapper<T> mapper) {
        try
        {
            System.out.println(query);
            Class.forName("com.mysql.cj.jdbc.Driver");// Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return mapper.foo(resultSet);
        }
        catch (SQLException e) {
            System.out.println("Connection error\n");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

    public static boolean executeNonSelectQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            System.out.println(query);
            System.out.println(statement.executeUpdate(query));
            return true;
        } catch (Exception e) {
            System.out.println("Connection error\n");
            e.printStackTrace();
        }
        return false;
    }
}
