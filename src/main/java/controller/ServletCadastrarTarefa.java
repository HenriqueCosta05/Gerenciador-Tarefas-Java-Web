package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
            HttpSession session = request.getSession(false); // Recupera a sessão atual, não cria uma nova
            if (session != null) {
                long idUsuario = (long) session.getAttribute("usuarioId");
                String nomeUsuario = (String) session.getAttribute("usuarioNome");

                // Setando os parâmetros da sessão na request
                request.setAttribute("usuarioId", idUsuario);
                request.setAttribute("usuarioNome", nomeUsuario);
            }
            
            // Recupera a lista de usuários
            ArrayList<Usuario> usuarios = UsuarioDAO.lerTodosUsuarios();
            request.setAttribute("usuarios", usuarios);
            
            // Redireciona para a página de nova tarefa
            request.getRequestDispatcher("novaTarefa.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().append("Erro ao carregar usuários");
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
        String idUsuarioStr = request.getParameter("usuarioId");
        String mensagem = "";

        try {
            // Verifica se o ID do usuário está presente e não é nulo
            if (idUsuarioStr == null || idUsuarioStr.isEmpty()) {
                throw new NumberFormatException("ID de usuário inválido");
            }

            long idUsuario = Long.parseLong(idUsuarioStr);
            Date dataFinalFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal);

            if (!titulo.isEmpty() && !descricao.isEmpty() && !status.isEmpty()) {
                TarefaDAO.insere(new Tarefa(titulo, dataFinalFormatada, descricao, status, idUsuario));
                mensagem = "Tarefa cadastrada com sucesso!";
                request.setAttribute("mensagem", mensagem);
            } else {
                response.getWriter().append("Erro. Campos vazios!");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mensagem = "Erro: ID de usuário inválido";
            request.setAttribute("mensagem", mensagem);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            mensagem = "Erro ao cadastrar tarefa";
            request.setAttribute("mensagem", mensagem);
        }
        doGet(request, response);
    }
}
