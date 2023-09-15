
import org.example.repository.CustomerRepository;
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

public class TestCustomer {
    private CustomerRepository customerRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet resultSet = mock(ResultSet.class);

    @BeforeEach
    public void setUp() throws SQLException {
        customerRepository = new CustomerRepository(connect);
        when(connect.prepareStatement(anyString())).thenReturn(statement);
    }

    @Test
    public void testRegisterCustomer() throws SQLException {
        String name = "John Doe";
        String email = "john@example.com";
        String cpf = "12345678901";
        String address = "123 Main St";

        when(statement.executeUpdate()).thenReturn(1);
        boolean success = customerRepository.registerCustomer(name, email, cpf, address);
        assertTrue(success);
    }
    @Test
    public void testDeleteCustomer() throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);
        boolean result = customerRepository.deleteCustomer("12345678910");
        assertTrue(result);
    }
    @Test
    public void testShowPurchaseHistory() throws SQLException {
        String cpf = "12345678901";
        String productName = "Product A";
        int amount = 5;
        double total = 100.0;

        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getString("name")).thenReturn(productName);
        when(resultSet.getInt("amount")).thenReturn(amount);
        when(resultSet.getDouble("total")).thenReturn(total);

        boolean success = customerRepository.showPurchaseHistory(cpf);

        assertTrue(success);
    }
}

