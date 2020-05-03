package br.com.exemplo.model;

public class AlunoEmTurma {
	private int id;
	private Aluno aluno; // NUNCA MAIS FAZER ASSIM
	private Turma turma; // NUNCA MAIS FAZER ASSIM
	
	public AlunoEmTurma() {
		// Vazio
	}

	public AlunoEmTurma(int id, Aluno aluno, Turma turma) {
		this.id = id;
		this.aluno = aluno;
		this.turma = turma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
