package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Tarefa;

public class TarefaDAO {
	public static void insere(Tarefa tarefa) throws SQLException {
		String sql = "INSERT INTO tarefas(titulo,dataFinal,descricao,status,idUsuario) VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
		//Prepara a conexão com o MySQL
			conn= ConnectionFactory.createConnection();
	        pstm= (PreparedStatement) conn.prepareStatement(sql);
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, tarefa.getTitulo());
		pstm.setString(2, tarefa.getDescricao());
		pstm.setDate(3, (Date) tarefa.getDataFinal());
		pstm.setString(4, tarefa.getStatus());
		pstm.setLong(5, tarefa.getIdUsuario());

		//Executa a query:
		pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Encerra a conexão com o MySQL
			 if(pstm!= null) pstm.close();
	         if(conn!=null) conn.close();
		}
		
	}
	
	public static void ler(int id) throws SQLException {
    	String sql = "SELECT FROM tarefas WHERE id = ?";
    	
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	
    	try {
    		conn = ConnectionFactory.createConnection();
    		pstm = conn.prepareStatement(sql);
    		pstm.setLong(1, id);
    		pstm.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if (pstm != null) {
    			pstm.close();
    		}
    		if(conn != null) {
    			conn.close();
    		}
    	}
    }
	
	public static ArrayList<Tarefa> lerTodasAsTarefas() throws SQLException {
		String sql = "SELECT * FROM tarefas";
		
	    //Prepara a conexão com o MySQL
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet query = null;
		
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		try {
			//Cria a conexão e executa a query.
			conn = ConnectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);
			query = pstm.executeQuery();
		
			//Enquanto há dados a serem recuperados, faça:
			while(query.next()) {
				Tarefa tarefa = new Tarefa();
				//Recupera cada um dos campos.
				tarefa.setId(query.getInt("id"));
				tarefa.setTitulo(query.getString("titulo"));
				tarefa.setDescricao(query.getString("descricao"));
				tarefa.setStatus(query.getString("status"));
				tarefa.setIdUsuario(query.getInt("idUsuario"));
				tarefa.setDataFinal(query.getDate("dataFinal"));
				
				tarefas.add(tarefa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
    		if (pstm != null) {
    			pstm.close();
    		}
    		if(conn != null) {
    			conn.close();
    		}
    		if(query != null) {
    			query.close();
    		}
    	}
		return tarefas;
		
	}
}
