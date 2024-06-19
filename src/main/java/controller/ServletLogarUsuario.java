package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;

public class ServletLogarUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletLogarUsuario() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String mensagem;
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");

        if (login.isEmpty() || senha.isEmpty()) {
            mensagem = "Preencha todos os campos para se autenticar!";
            request.setAttribute("mensagem", mensagem);
            dispatcher.forward(request, response);
            return;
        }

        try {
            Usuario usuario = UsuarioDAO.autenticar(login, senha);
            if (usuario != null) {
            	//Seta o id e o nome de usuário para uso em outra servlet (Cadastrar e Listar Tarefas)
                HttpSession session = request.getSession();
                session.setAttribute("usuarioId", usuario.getId());
                session.setAttribute("usuarioNome", usuario.getNome());
                mensagem = "Usuário autenticado com sucesso!";
            } else {
                mensagem = "Credenciais inválidas!";
            }
            request.setAttribute("mensagem", mensagem);
        } catch (SQLException e) {
            e.printStackTrace();
            mensagem = "Erro ao autenticar o usuário!";
            request.setAttribute("mensagem", mensagem);
        }

        dispatcher.forward(request, response);
    }
}
