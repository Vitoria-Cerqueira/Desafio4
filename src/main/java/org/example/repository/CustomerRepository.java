package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class CustomerRepository {
    public CustomerRepository(){}
    public CustomerRepository(Connection conn) {
        this.conn = conn;
    }
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean registerCustomer(String name, String email, String cpf, String address){
        try {
            String sql= "INSERT INTO customer (name,email,cpf,address) VALUES (?,?,?,?) ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, cpf);
            preparedStatement.setString(4, address);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteCustomer(String cpf) {
        try {
            String SQL = "DELETE FROM customer WHERE cpf = ?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, cpf);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean showPurchaseHistory(String cpf){
        try {
            String sql = "SELECT product.name,sale.amount,sale.total " +
                    "FROM customer " +
                    "INNER JOIN sale ON customer.id_customer = sale.idCustomer " +
                    "INNER JOIN product ON product.id_product = sale.idProduct " +
                    "WHERE customer.cpf = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Historica de compras");
            while (resultSet.next()){
                System.out.println("\t|Produto    " + resultSet.getString("name"));
                System.out.println("\t|Quantidade " + resultSet.getInt("amount"));
                System.out.println("\t|Total      " + resultSet.getInt("total"));
            }
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
