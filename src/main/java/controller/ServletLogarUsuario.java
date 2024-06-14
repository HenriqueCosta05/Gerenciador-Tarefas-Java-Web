package controller;

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
public class ServletLogarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogarUsuario() {
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
		//response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// permitir acentuação
				request.setCharacterEncoding("UTF-8");		
				response.setContentType("text/html;charset=UTF-8");
				System.out.println("Servlet Autenticar está funcionando");
				String login,senha;
				
				login=request.getParameter("login");
				senha=request.getParameter("senha");
				//Validações
				if(!login.isEmpty() || !senha.isEmpty()) {
				//Verificar as credenciais do usuário
				try {
					UsuarioDAO.autenticar(login, senha);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				response.getWriter().append("\n Usuário autenticado com sucesso. ");
				} else {
					response.getWriter().append("\n Erro. Campos vazios! ");
				}
		//doGet(request, response);
	}

}
