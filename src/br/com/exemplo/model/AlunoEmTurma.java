package br.com.exemplo.model;

public class AlunoEmTurma {
	private Aluno aluno;
	private Turma turma;
	private double notas;
	private int faltas;
	
	public AlunoEmTurma() {
		// Vazio
	}

	public AlunoEmTurma(Aluno aluno, Turma turma, double notas, int faltas) {
		this.aluno = aluno;
		this.turma = turma;
		this.notas = notas;
		this.faltas = faltas;
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

	public double getNotas() {
		return notas;
	}

	public void setNotas(double notas) {
		this.notas = notas;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	
}
