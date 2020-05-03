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
	
	public Aluno consultar(String rgm) throws Exception {
		try {
			String sql = "SELECT * FROM Aluno WHERE rgm = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rgm);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Aluno aluno = new Aluno(rs.getString("rgm"), rs.getString("nome"), rs.getString("nascimento"), rs.getString("cpf"), 
						rs.getString("email"), rs.getString("endereco"), rs.getString("municipio"), rs.getString("uf"), rs.getString("celular"));
				return aluno;
			}
			else 
				throw new Exception("Nada encontrado");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterar(Aluno aluno) throws Exception {
		try {
			String sql = "UPDATE Aluno SET nome = ?, nascimento = ?,  cpf = ?, email = ?, endereco = ?, municipio = ?, uf = ?, celular = ? WHERE rgm = ?";

			ps = conn.prepareStatement(sql);
				
			ps.setString(1, aluno.getNome());
			ps.setDate(2, java.sql.Date.valueOf(aluno.getNascimento()));
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getEndereco());
			ps.setString(6, aluno.getMunicipio());
			ps.setString(7, aluno.getUf());
			ps.setString(8, aluno.getCelular());
			ps.setString(9, aluno.getRgm());

			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void excluir(String rgm) throws Exception {
		try {
			String sql = "DELETE FROM Aluno WHERE rgm = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, rgm);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
