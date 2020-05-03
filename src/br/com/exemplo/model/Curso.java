package br.com.exemplo.model;

public class Curso {
	
	private String nome;
	private String campus;
	
	public Curso() {
		// vazio
	}

	public Curso(String nome, String campus) {
		this.nome = nome;
		this.campus = campus;
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
