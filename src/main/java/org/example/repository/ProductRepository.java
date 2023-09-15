package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class ProductRepository {
    public ProductRepository(){}
    public ProductRepository(Connection conn) {
        this.conn = conn;
    }
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean registerProduct(String name,double price){
        try {
            String sql = "INSERT INTO product(name,price) VALUES (?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
