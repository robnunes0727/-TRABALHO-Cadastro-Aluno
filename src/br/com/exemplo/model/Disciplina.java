package br.com.exemplo.model;

public class Disciplina {
	private int id;
	private String nome;
	private String semestre;
	
	public Disciplina() {
		// Vazio
	}

	public Disciplina(int id, String nome, String semestre) {
		this.id = id;
		this.nome = nome;
		this.semestre = semestre;
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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
}
