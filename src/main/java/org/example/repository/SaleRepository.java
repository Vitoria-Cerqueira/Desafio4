package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class SaleRepository {
    public SaleRepository(){}
    public SaleRepository(Connection conn) {
        this.conn = conn;
    }
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean registerSale(int amount,Double total,int id_seller, int id_customer, int id_product){
        try {
            String sql = "INSERT INTO sale (amount,total,idSeller,idCustomer,idProduct) VALUES (?,?,?,?,?) ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, amount);
            preparedStatement.setDouble(2, total);
            preparedStatement.setInt(3, id_seller);
            preparedStatement.setInt(4,id_customer);
            preparedStatement.setInt(5,id_product);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean displayItemsThatHaveBeenSoldForMoreThanTen(){
        try {
            String sql = "SELECT product.name, sale.total " +
                    "FROM product, sale " +
                    "WHERE sale.idProduct = product.id_product " +
                    "AND sale.total > 10 ";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Vendas com valor total acima de 10 reais");
            while (resultSet.next()) {
                System.out.println("\tProduto:   " + resultSet.getString("name"));
                System.out.println("\tTotal:     " + resultSet.getDouble("total"));
            }
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean changeTotalValueOfSalesThatAreNullTo0(){
        try {
            String sql = "UPDATE sale SET total = 0 WHERE total IS NULL ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean showAllSales(){
        try{
            String SQL = "SELECT * FROM sale";
            preparedStatement = conn.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("QUANTIDADE: " + resultSet.getInt("amount"));
                System.out.println("TOTAL: " + resultSet.getString("total"));
                System.out.println("ID_VENDEDOR: " + resultSet.getString("idSeller"));
                System.out.println("ID_CLIENTE: " + resultSet.getString("idCustomer"));
                System.out.println("ID_PRODUTO: " + resultSet.getString("idProduct"));
                System.out.println();

            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
