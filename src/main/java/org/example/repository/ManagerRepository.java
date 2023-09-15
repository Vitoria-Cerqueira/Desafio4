package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class ManagerRepository {

    public ManagerRepository(){}
    public ManagerRepository(Connection conn) {
        this.conn = conn;
    }
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean login(String email, String password){
        try {
            String sql = "SELECT * FROM manager WHERE email=  ? AND password = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean ShowEmailOfPeople(){
        try {
            String sql = "SELECT name, email " +
                    "FROM seller " +
                    "WHERE email LIKE '%@zup.com.br%' " +
                    "UNION " +
                    "SELECT name, email " +
                    "FROM customer " +
                    "WHERE email LIKE '%@zup.com.br%' ";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("\t|Pessoas:   " + resultSet.getString("name"));
                System.out.println("\t|Email      " + resultSet.getString("email"));
                System.out.println();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

}

