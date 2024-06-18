package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;

/**
 * Servlet implementation class ServletCadastrarUsuario
 */
public class ServletCadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//mostra página com mensagem
		response.getWriter().append("\n Dados cadastrados com sucesso ");
		//direciona para home
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// permitir acentuação
				request.setCharacterEncoding("UTF-8");		
				response.setContentType("text/html;charset=UTF-8");
				System.out.println("Servlet Cadastrar está funcionando");
				String nome,login,senha, mensagem;
				nome=request.getParameter("nome");
				login=request.getParameter("login");
				senha=request.getParameter("senha");
				//Validações
				if(nome!=null && !nome.isEmpty() && !login.isEmpty() && !senha.isEmpty()) {
				//adicionar ao banco de dados e salvar com id
				try {
					UsuarioDAO.insere(new Usuario(nome, login, senha));
					mensagem = "Usuário cadastrado com sucesso! Faça o login para continuar!";
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				response.getWriter().append("\n Dados cadastrados com sucesso ");
				} else {
					mensagem = "Preencha todos os campos para cadastrar seu usuário!";
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
					dispatcher.forward(request, response);
				}
		//doGet(request, response);
	}

}
