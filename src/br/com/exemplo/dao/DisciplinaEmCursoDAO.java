package br.com.exemplo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Disciplina;
import br.com.exemplo.util.ConnectionFactory;

public class DisciplinaEmCursoDAO {
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection conn;
	
	public DisciplinaEmCursoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Disciplina> consultarDisciplinas(int idCurso) throws Exception {
		try {
			String sql = "SELECT id, nome FROM DisciplinaEmCurso "
					+ "INNER JOIN Disciplina ON Disciplina_id = Disciplina.id "
					+ "WHERE Curso_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurso);
			rs = ps.executeQuery();
			
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			
			while(rs.next()) {
				Disciplina d = new Disciplina();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				
				disciplinas.add(d);
			}
			
			if(disciplinas.isEmpty())
				throw new Exception("Nenhuma disciplina encontrada.");
			
			return disciplinas;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
}
