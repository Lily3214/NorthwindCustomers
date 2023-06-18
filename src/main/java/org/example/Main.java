package org.example;

import java.net.ConnectException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String username = args[0];
        String password = args[1];
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                username, password);

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT ContactName, CompanyName, City, Country, Phone FROM customers");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("ContactName = %s, CompanyName = %s, City = %s, Country = %s, Phone = %d\n",
                    resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
        }
        
    }
}
