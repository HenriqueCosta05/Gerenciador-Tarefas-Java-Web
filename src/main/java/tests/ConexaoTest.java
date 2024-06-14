package tests;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import factory.ConnectionFactory;

public class ConexaoTest {

    @Test
    public void testConnection() {
        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection();
            assertNotNull("Deve criar uma conexão com o Banco de Dados", connection);
        } catch (Exception e) {
            e.printStackTrace();
            // Falha o teste caso uma exceção seja lançada
            assert false : "Exceção ao tentar conectar ao banco de dados: " + e.getMessage();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
