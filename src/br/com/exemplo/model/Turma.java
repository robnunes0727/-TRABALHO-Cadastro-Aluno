package br.com.exemplo.model;

public class Turma {
	private int id;
	private Disciplina disciplina;
	private Curso curso;
	
	public Turma() {
		// Vazio
	}

	public Turma(int id, Disciplina disciplina, Curso curso) {
		this.id = id;
		this.disciplina = disciplina;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
