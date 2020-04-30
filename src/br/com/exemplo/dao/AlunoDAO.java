package br.com.exemplo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.exemplo.model.Aluno;
import br.com.exemplo.util.ConnectionFactory;

public class AlunoDAO {
	
	// SQL stuff
	private PreparedStatement ps; 
	private Connection conn;
	private ResultSet rs;
	
	// Modelo
	private Aluno aluno;
	
	public AlunoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}
	}
	
	public void salvar(Aluno aluno) throws Exception {
		try {
			String sql = "INSERT INTO Aluno (rgm, nome, nascimento, cpf, email, endereco, municipio, uf, celular)"
							+		"VALUES (  ?,    ?,          ?,   ?,     ?,        ?,         ?,  ?,       ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getRgm());
			ps.setString(2, aluno.getNome());
			ps.setDate(3, java.sql.Date.valueOf(aluno.getNascimento()));
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getUf());
			ps.setString(9, aluno.getCelular());
			ps.executeUpdate();	
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
