package br.com.exemplo.model;

public class DisciplinaEmCurso {
	private int disciplina_id;
	private int curso_id;
	
	public DisciplinaEmCurso() {}

	public DisciplinaEmCurso(int disciplina_id, int curso_id) {
		this.disciplina_id = disciplina_id;
		this.curso_id = curso_id;
	}

	public int getDisciplina_id() {
		return disciplina_id;
	}

	public void setDisciplina_id(int disciplina_id) {
		this.disciplina_id = disciplina_id;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	
	
	
}
