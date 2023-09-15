import org.example.repository.SellerRepository;
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

public class TestSeller {
    private SellerRepository sellerRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet resultSet = mock(ResultSet.class);

    @BeforeEach
    public void setUp() throws SQLException {
        sellerRepository = new SellerRepository(connect);
        when(connect.prepareStatement(anyString())).thenReturn(statement);
    }
    @Test
    public void testShowSellerSalariesOfInDescendingOrder() throws SQLException {
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true,false);
        when(resultSet.getString("name")).thenReturn("Vendedor Teste");
        when(resultSet.getDouble("salary")).thenReturn(1000.0);

        boolean result = sellerRepository.showSellerSalariesOfInDescendingOrder();
        assertTrue(result);
    }

}
