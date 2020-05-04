package br.com.exemplo.model;

public class AlunoEmTurma {
	private Aluno aluno; // --
	private Turma turma; // --
	
	public AlunoEmTurma() {
		// Vazio
	}

	public AlunoEmTurma(Aluno aluno, Turma turma) {
		this.aluno = aluno;
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	
}
