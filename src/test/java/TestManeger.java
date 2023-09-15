import org.example.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestManeger {
    private ManagerRepository managerRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet resultSet = mock(ResultSet.class);

    @BeforeEach
    public void setUp() throws SQLException {
        managerRepository = new ManagerRepository(connect);
        when(connect.prepareStatement(anyString())).thenReturn(statement);
    }
    @Test
    public void testLoginManager() throws SQLException{
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("email")).thenReturn("vitoria@gmail.com");
        when(resultSet.getString("password")).thenReturn("1234");

        boolean result = managerRepository.login("vitoria@gmail.com","1234");
        assertTrue(result);

    }
    @Test
    public void testInvalidLoginManager() throws SQLException{
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(false);

        boolean result = managerRepository.login("vitoria@gmail.com","1234");
        assertFalse(result);

    }

    @Test
    public void testShowEmailOfPeople() throws SQLException {
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getString("name")).thenReturn("vitoria");
        when(resultSet.getString("email")).thenReturn("vitoria@zup.com.br");

        boolean result = managerRepository.ShowEmailOfPeople();
        assertTrue(result);
    }
}


