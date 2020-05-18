package br.com.exemplo.dao;

import java.sql.*;

import br.com.exemplo.model.Aluno;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.Disciplina;
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
			if(e.getMessage().toLowerCase().contains("duplicate entry"))
				throw new Exception("Entrada duplicada");
			throw new Exception(e.getMessage());
		}
	}
	
	public NotasFaltas consultar(String rgm, int DiscId, int Cid) throws Exception {
		try {
			String sql = "SELECT Nota, Faltas FROM NotasFaltas WHERE Aluno_rgm = ? AND Disciplina_id = ? AND Curso_id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, rgm);
			ps.setInt(2, DiscId);
			ps.setInt(3, Cid);
			
			rs = ps.executeQuery();
			
			NotasFaltas nf;
			if(rs.next()) {
				Aluno a = new Aluno();
				a.setRgm(rgm);
				
				Disciplina d = new Disciplina();
				d.setId(DiscId);
				
				Curso c = new Curso();
				c.setId(Cid);
				
				nf = new NotasFaltas(a,d,c,rs.getInt("Faltas"),rs.getDouble("Nota"));
			} else {
				throw new Exception("Nada encontrado");
			}
			
			return nf;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterar(NotasFaltas nf) throws Exception {
		try {
			String sql = "UPDATE NotasFaltas SET Nota = ?, Faltas = ? WHERE Aluno_rgm = ? AND Disciplina_id = ? AND Curso_id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, nf.getNota());
			ps.setInt(2, nf.getFaltas());
			ps.setString(3, nf.getAluno().getRgm());
			ps.setInt(4, nf.getDisciplina().getId());
			ps.setInt(5, nf.getCurso().getId());

			if (ps.executeUpdate() == 0)
				throw new Exception("Nada alterado");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void excluir(NotasFaltas nf) throws Exception {
		try {
			String sql = "DELETE FROM NotasFaltas WHERE Aluno_rgm = ? AND Disciplina_id = ? AND Curso_id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, nf.getAluno().getRgm());
			ps.setInt(2, nf.getDisciplina().getId());
			ps.setInt(3, nf.getCurso().getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
