package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {
   
    public static void insere(Usuario user) throws SQLException{
        String sql= "INSERT INTO usuarios(nome,login,senha) VALUES (?,?,?)";
        Connection conn=null;
        PreparedStatement pstm=null;
        
        try{
            conn= ConnectionFactory.createConnection();
            pstm= (PreparedStatement) conn.prepareStatement(sql);
         
            pstm.setString(1,user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3,user.getSenha());
            //Executando a query
             pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!= null) pstm.close();
            if(conn!=null) conn.close();
        }
    }
    
    public static void ler(int id) throws SQLException {
    	String sql = "SELECT usuarios WHERE id = ?";
    	
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
    
    public static void autenticar(String login, String senha) throws SQLException {
    	String sql = "SELECT login, senha FROM usuarios WHERE login = ?, senha = ?";
    	
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	
    	try {
    		conn = ConnectionFactory.createConnection();
    		pstm = conn.prepareStatement(sql);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if(pstm != null) pstm.close();
    		if(conn != null) conn.close();
    	}
    }
}
    
    
    