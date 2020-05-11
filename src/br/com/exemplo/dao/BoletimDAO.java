package br.com.exemplo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Boletim;
import br.com.exemplo.util.ConnectionFactory;

public class BoletimDAO {
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection conn;
	
	public BoletimDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Boletim> listar(String rgm, String semestre) throws Exception {
		try {
		
			String sql = "SELECT a.rgm as rgm, a.nome as nome, c.nome as curso, t.semestre as semestre, d.nome as disciplina, t.periodo as periodo, n.nota as nota, n.faltas as faltas "
					   + "FROM NotasFaltas n "
					   + "INNER JOIN DisciplinaEmCurso dc ON dc.Disciplina_id = n.Disciplina_id AND dc.Curso_id AND n.Curso_id "
					   + "INNER JOIN Disciplina d ON dc.Curso_id = d.id "
					   + "INNER JOIN Curso c ON c.id = dc.Curso_id "
					   + "INNER JOIN Aluno a ON a.rgm = n.Aluno_rgm "
					   + "INNER JOIN AlunoEmTurma at ON n.Aluno_rgm = at.Aluno_rgm "
					   + "INNER JOIN Turma t ON t.id = at.Turma_id "
					   + "WHERE n.Aluno_rgm = ? AND t.semestre = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, rgm);
			ps.setString(2, semestre);
			rs = ps.executeQuery();

			List<Boletim> bolList = new ArrayList<Boletim>();
			while(rs.next()) {
				Boletim bol = new Boletim(rs.getString("rgm"), rs.getString("nome"), rs.getString("disciplina"), rs.getDouble("nota"), rs.getInt("faltas"), rs.getString("periodo"), rs.getString("curso"), rs.getString("semestre"));
				bolList.add(bol);
			}			
			
			if (bolList.isEmpty())
				throw new Exception("Nada encontrado");
			
			return bolList;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}