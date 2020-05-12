package br.com.exemplo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
	
	private String rgm;
	private String nome;
	private String nascimento;
	private String cpf;
	private String email;
	private String endereco;
	private String municipio;
	private String uf;
	private String celular;
	
	public Aluno() {
	// Vazio	
	}

	public Aluno(String rgm, String nome, String nascimento, String cpf, String email, String endereco,
			String municipio, String uf, String celular) throws Exception {
		
		try {
			this.rgm = rgm;
			this.nome = nome;
			Date dataNasc = new SimpleDateFormat("yyyy-mm-dd").parse(nascimento);
			this.nascimento = new SimpleDateFormat("dd/mm/yyyy").format(dataNasc);
			this.cpf = cpf;
			this.email = email;
			this.endereco = endereco;
			this.municipio = municipio;
			this.uf = uf;
			this.celular = celular;
		} catch (ParseException e) {
			if (e.getMessage().contains("Unparseable date")) {
				throw new Exception("Data inválida");
			}
		}
	}
	
	// Getter & Setter
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) throws Exception {
		// Transforma DIA/MES/ANO em ANO-MES-DIA
		try {
			Date dataNasc = new SimpleDateFormat("dd/mm/yyyy").parse(nascimento);
			this.nascimento = new SimpleDateFormat("yyyy-mm-dd").format(dataNasc);
		} catch (ParseException e) {
			if (e.getMessage().contains("Unparseable date")) {
				throw new Exception("Data inválida");
			}
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replace(".", "").replace("-", "");

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
