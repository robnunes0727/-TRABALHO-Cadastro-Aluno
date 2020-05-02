package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.exemplo.util.ConnectionFactory;
import br.com.exemplo.model.Aluno;
import br.com.exemplo.model.Curso;

public class AlunoEmTurmaDAO {
		
	// SQL stuff
	private PreparedStatement ps; 
	private Connection conn;
	private ResultSet rs;
	
	public AlunoEmTurmaDAO() throws Exception {
		try {	
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void salvar(Aluno aluno, Curso curso) throws Exception {
		try {
			String sql = "INSERT INTO AlunoEmTurma (Aluno_rgm, Turma_id) SELECT ?, id  " + "FROM Turma "
					+ "WHERE curso_id = (SELECT id " + "FROM Curso "
					+ "WHERE curso = ? AND campus = ? AND periodo = ?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, aluno.getRgm());
			ps.setString(2, curso.getCurso());
			ps.setString(3, curso.getCampus());
			ps.setString(4, curso.getPeriodo());
			
			System.out.println(ps);
			
			if(ps.executeUpdate() == 0);
				throw new Exception("Aluno, curso ou turma não encontrados, tente outra turma.");
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
