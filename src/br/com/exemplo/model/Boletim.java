package br.com.exemplo.model;

public class Boletim {
	private String rgm;
	private String nome;
	private String disciplina;
	private double nota;
	private int faltas;
	private String periodo;
	private String curso;
	private String semestre;
	
	public Boletim() {}
	
	public Boletim(String rgm, String nome, String disciplina, double nota, int faltas, String periodo, String curso,
			String semestre) {
		this.rgm = rgm;
		this.nome = nome;
		this.disciplina = disciplina;
		this.nota = nota;
		this.faltas = faltas;
		this.periodo = periodo;
		this.curso = curso;
		this.semestre = semestre;
	}

	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
