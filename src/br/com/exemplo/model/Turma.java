package br.com.exemplo.model;

public class Turma {
	private int id;
	private Curso curso; // --
	private String periodo;
	private String semestre;
	
	public Turma() {}

	public Turma(int id, Curso curso, String periodo, String semestre) {
		this.id = id;
		this.curso = curso;
		this.periodo = periodo;
		this.semestre = semestre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
}
