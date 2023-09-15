import org.example.repository.ProductRepository;
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

public class TestProduct {
    private ProductRepository productRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet resultSet = mock(ResultSet.class);

    @BeforeEach
    public void setUp() throws SQLException {
        productRepository = new ProductRepository(connect);
        when(connect.prepareStatement(anyString())).thenReturn(statement);
    }
    @Test
    public void testRegisterProduct() throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);
        boolean result = productRepository.registerProduct("Produto Teste", 10.0);
        assertTrue(result);
    }
}
