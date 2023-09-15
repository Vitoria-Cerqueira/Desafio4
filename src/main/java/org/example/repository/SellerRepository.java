package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class SellerRepository {
    public SellerRepository(){}
    public SellerRepository(Connection conn) {
        this.conn = conn;
    }
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean showSellerSalariesOfInDescendingOrder(){
        try {
            String sql = "SELECT seller.name,seller.salary FROM seller " +
                        "ORDER BY seller.salary DESC ";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Sal[ario dos vendedores em ordem decrescente");
            while (resultSet.next()) {
                System.out.println("\t|Vendedor:   " + resultSet.getString("name"));
                System.out.println("\t|Total:       " + resultSet.getDouble("salary") + "|");
                System.out.println();
            }
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
