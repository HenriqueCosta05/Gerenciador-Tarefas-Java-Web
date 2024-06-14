package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.TarefaDAO;

/**
 * Servlet implementation class ServletCadastrarUsuario
 */
public class ServletCadastrarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarTarefa() {
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
		response.getWriter().append("\n Tarefa cadastrada com sucesso! ");
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
				String titulo, descricao, status, idUsuario, dataFinal;
				
				
				titulo=request.getParameter("titulo");
				descricao=request.getParameter("descricao");
				dataFinal=request.getParameter("dataFinal");
				status=request.getParameter("status");
				idUsuario=request.getParameter("idUsuario");
				
				//Transforma os valores em seus tipos correspondentes.
				int idUsuarioFormatado =  Integer.valueOf(idUsuario);
				Date dataFinalFormatada = new Date();
				
				try {
					dataFinalFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataFinal);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Simples Validação
				if(!titulo.isEmpty()) {
				try {
					TarefaDAO.insere(new Tarefa(titulo, dataFinalFormatada, descricao, status, idUsuarioFormatado));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				response.getWriter().append("\n Dados cadastrados com sucesso ");
				} else {
					response.getWriter().append("\n Erro. Campos vazios! ");
				}
		doGet(request, response);
	}

}
