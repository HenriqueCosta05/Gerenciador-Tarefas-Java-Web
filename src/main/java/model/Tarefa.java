package model;

import java.util.Date;

public class Tarefa {
	private int id;
	private String titulo;
	private Date dataFinal;
	private String descricao;
	private String status;
	private long idUsuario; 
	
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public Date getDataFinal() {
		return dataFinal;
	}



	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Tarefa(int id, String titulo, Date dataFinal, String descricao, String status, int idUsuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
		this.status = status;
		this.idUsuario = idUsuario;
	}


	public Tarefa(String titulo, Date dataFinal, String descricao, String status, long idUsuario) {
		super();
		this.titulo = titulo;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
		this.status = status;
		this.idUsuario = idUsuario;
	}
	
	
	
	public Tarefa() {
		
	}
	

	
	
	
	
}
