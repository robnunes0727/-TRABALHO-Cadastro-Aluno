package br.com.exemplo.model;

public class NotasFaltas {
	private Aluno aluno;
	private Disciplina disciplina;
	private Curso curso;
	private int faltas;
	private double nota;
	private String semestre;
	
	public NotasFaltas() {
		// TODO Auto-generated constructor stub
	}

	public NotasFaltas(Aluno aluno, Disciplina disciplina, Curso curso, int faltas, double nota) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.curso = curso;
		this.faltas = faltas;
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
}