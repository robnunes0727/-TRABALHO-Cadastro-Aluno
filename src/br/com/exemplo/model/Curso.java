package br.com.exemplo.model;

public class Curso {
	
	private int id;
	private String nome;
	private String campus;
	
	public Curso() {
		// vazio
	}

	public Curso(int id, String nome, String campus) {
		this.id = id;
		this.nome = nome;
		this.campus = campus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	
	
}
