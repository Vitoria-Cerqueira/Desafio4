import org.example.repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestSale {
    private SaleRepository saleRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet resultSet = mock(ResultSet.class);

    @BeforeEach
    public void setUp() throws SQLException {
        saleRepository = new SaleRepository(connect);
        when(connect.prepareStatement(anyString())).thenReturn(statement);
    }
    @Test
    public void testRegisterSale() throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);
        boolean result = saleRepository.registerSale(5, 50.0, 1, 2, 3);
        assertTrue(result);
    }
    @Test
    public void testDisplayItemsThatHaveBeenSoldForMoreThanTen() throws SQLException {
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getString("name")).thenReturn("Chocolate");
        when(resultSet.getDouble("total")).thenReturn(15.0);

        boolean result = saleRepository.displayItemsThatHaveBeenSoldForMoreThanTen();
        assertTrue(result);
    }
    @Test
    public void testChangeTotalValueOfSalesThatAreNullTo0() throws SQLException {
        when(statement.executeQuery()).thenReturn(resultSet);
        boolean result = saleRepository.changeTotalValueOfSalesThatAreNullTo0();
        assertTrue(result);
    }
    @Test
    public void testShowAllSales() throws SQLException {
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getInt("amount")).thenReturn(5);
        when(resultSet.getString("total")).thenReturn("50.0");
        when(resultSet.getString("idSeller")).thenReturn("1");
        when(resultSet.getString("idCustomer")).thenReturn("2");
        when(resultSet.getString("idProduct")).thenReturn("3");

        boolean result = saleRepository.showAllSales();
        assertTrue(result);
    }

}
