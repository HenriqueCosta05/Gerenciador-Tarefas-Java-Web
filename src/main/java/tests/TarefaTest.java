package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dao.TarefaDAO;
import model.Tarefa;

public class TarefaTest {

    private Tarefa tarefa;

    @Before
    public void setUp() {
        // Inicializa uma tarefa para usar nos testes
        tarefa = new Tarefa();
        tarefa.setTitulo("Teste de Tarefa");
        tarefa.setDescricao("Descrição de Teste");
        tarefa.setDataFinal(new Date());
        tarefa.setStatus("Pendente");
        tarefa.setIdUsuario(3);  // Suponha que o usuário com ID 3 exista.
    }

    @Test
    public void testInserirTarefa() {
        try {
            TarefaDAO.insere(tarefa);
            // Suponha que a tarefa foi inserida com sucesso e tenha um ID maior que 0
            assertTrue("A tarefa deve ser inserida com sucesso", tarefa.getId() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erro ao inserir a tarefa: " + e.getMessage());
        }
    }

    @Test
    public void testLerTarefa() {
        try {
            // Suponha que a tarefa com ID 1 existe no banco de dados
            Tarefa tarefaLida = TarefaDAO.ler(1);
            assertNotNull("A tarefa deve ser lida com sucesso", tarefaLida);
            assertEquals("O ID da tarefa deve ser 1", 1, tarefaLida.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erro ao ler a tarefa: " + e.getMessage());
        }
    }

    @Test
    public void testLerTodasAsTarefas() {
        try {
            ArrayList<Tarefa> tarefas = TarefaDAO.lerTodasAsTarefas();
            assertNotNull("A lista de tarefas não deve ser nula", tarefas);
            assertTrue("A lista de tarefas deve conter pelo menos uma tarefa", tarefas.size() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erro ao ler todas as tarefas: " + e.getMessage());
        }
    }

    @Test
    public void testLerTarefasPorUsuario() {
        try {
            // Suponha que o usuário com ID 1 tenha tarefas associadas
            ArrayList<Tarefa> tarefas = TarefaDAO.lerTarefasPorUsuario(3);
            assertNotNull("A lista de tarefas não deve ser nula", tarefas);
            assertTrue("A lista de tarefas deve conter pelo menos uma tarefa", tarefas.size() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erro ao ler as tarefas por usuário: " + e.getMessage());
        }
    }
}
