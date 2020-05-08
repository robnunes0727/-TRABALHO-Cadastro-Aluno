package br.com.exemplo.dao;

import java.sql.*;

import br.com.exemplo.model.NotasFaltas;
import br.com.exemplo.util.ConnectionFactory;

public class NotasFaltasDAO {
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection conn;
	
	public NotasFaltasDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void salvar(NotasFaltas nf) throws Exception {
		try {
			String sql = "INSERT INTO NotasFaltas (Aluno_rgm, Faltas, Nota, Disciplina_id, Curso_id) "
					+ "VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, nf.getAluno().getRgm());
			ps.setInt(2, nf.getFaltas());
			ps.setDouble(3, nf.getNota());
			ps.setInt(4, nf.getDisciplina().getId());
			ps.setInt(5, nf.getCurso().getId());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage().contains("Duplicate entry"))
				throw new Exception("Entrada duplicada");
			throw new Exception(e.getMessage());
		}
	}
}
