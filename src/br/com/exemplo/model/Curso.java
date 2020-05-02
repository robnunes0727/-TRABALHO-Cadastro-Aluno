package br.com.exemplo.model;

public class Curso {
	
	private String curso;
	private String campus;
	private String periodo;
	
	public Curso() {
		// vazio
	}

	public Curso(String nome, String campus, String periodo) {
		this.curso = nome;
		this.campus = campus;
		this.periodo = periodo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
