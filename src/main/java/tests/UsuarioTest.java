package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioTest {

    @Test
    public void criarNovoUsuarioTest() {
        // Dados de teste
        String nome = "Henrique";
        String login = "HenriqueCosta05";
        String senha = "Senha123!";

        // Cria uma instância de Usuario
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        try {
            // Insere o usuário no banco de dados
            boolean estaInserido = UsuarioDAO.insere(usuario);

            // Verifica se o usuário foi inserido com sucesso
            assertTrue("Deve inserir um usuário no banco de dados", estaInserido);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocorreu um erro ao tentar inserir um usuário no banco de dados: " + e.getMessage());
        }
    }

    @Test
    public void autenticarUsuarioTest() {
        // Dados de teste para autenticação
        String login = "HenriqueCosta05";
        String senha = "Senha123!";

        try {
            // Autentica o usuário no banco de dados
            boolean estaAutenticado = UsuarioDAO.autenticar(login, senha);

            // Verifica se o usuário foi autenticado com sucesso
            assertTrue("Deve autenticar um usuário no banco de dados", estaAutenticado);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocorreu um erro ao tentar autenticar o usuário: " + e.getMessage());
        }
    }

    @Test
    public void lerUsuarioTest() {
        // ID do usuário desejado
        long id = 3;

        try {
            // Busca o usuário pelo ID
            Usuario usuario = UsuarioDAO.ler(id);

            // Verifica se o usuário foi encontrado
            assertNotNull("Deve listar o usuário pelo ID", usuario);
            assertEquals("ID do usuário deve ser igual ao procurado", id, usuario.getId());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocorreu um erro ao tentar listar o usuário: " + e.getMessage());
        }
    }
}
