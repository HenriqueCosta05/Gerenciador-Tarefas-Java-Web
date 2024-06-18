package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;
import model.Usuario;
import dao.TarefaDAO;
import dao.UsuarioDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ServletCadastrarTarefa extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletCadastrarTarefa() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Usuario> usuarios = UsuarioDAO.lerTodosUsuarios();
            if (usuarios != null) {
                request.setAttribute("usuarios", usuarios);
            } else {
                request.setAttribute("erro", "Não há usuários cadastrados");
            }
            request.getRequestDispatcher("novaTarefa.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao carregar usuários");
            request.getRequestDispatcher("novaTarefa.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String dataFinal = request.getParameter("dataFinal");
        String status = request.getParameter("status");
        String idUsuario = request.getParameter("usuarioId");

        try {
            int idUsuarioFormatado = Integer.valueOf(idUsuario);
            Date dataFinalFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal);

            if (!titulo.isEmpty()) {
                TarefaDAO.insere(new Tarefa(titulo, dataFinalFormatada, descricao, status, idUsuarioFormatado));
                response.getWriter().append("Dados cadastrados com sucesso");
            } else {
                response.getWriter().append("Erro. Campos vazios!");
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            response.getWriter().append("Erro ao cadastrar tarefa");
        }
        doGet(request, response);
    }
}
