package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.exemplo.util.ConnectionFactory;
import br.com.exemplo.model.Aluno;
import br.com.exemplo.model.AlunoEmTurma;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.Turma;

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
	
	public void salvar(AlunoEmTurma alunoTurma) throws Exception {
		try {
			String sql = "INSERT INTO AlunoEmTurma (Aluno_rgm, Turma_id) " + 
					"SELECT ?, id FROM Turma " + 
					"WHERE periodo = ? AND curso_id = (SELECT id FROM Curso WHERE nome = ? AND campus = ?) " +
					"AND semestre = (SELECT MAX(semestre) FROM Turma)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, alunoTurma.getAluno().getRgm());
			ps.setString(2, alunoTurma.getTurma().getPeriodo());
			ps.setString(3, alunoTurma.getTurma().getCurso().getNome());
			ps.setString(4, alunoTurma.getTurma().getCurso().getCampus());
			
			if(ps.executeUpdate() == 0)
				throw new Exception("Aluno, curso ou turma não encontrados, verifique os dados.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().contains("for key 'alunoemturma.Aluno_rgm_UNIQUE'"))
				throw new Exception("Esse aluno já está cadastrado em um curso.");
			throw new Exception(e.getMessage());
		}
	}
	
	public AlunoEmTurma consultar(String rgm) throws Exception{
		try {
			String sql = "SELECT AlunoEmTurma.id, AlunoEmTurma.Aluno_rgm, Curso.nome, Curso.campus, Turma.periodo " + 
					"FROM Turma " + 
					"INNER JOIN Curso ON Turma.Curso_id = Curso.id " + 
					"INNER JOIN AlunoEmTurma ON AlunoEmTurma.Turma_id = Turma.id " + 
					"WHERE AlunoEmTurma.Aluno_rgm = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, rgm);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setRgm(rs.getString("Aluno_rgm"));
				
				Curso curso = new Curso(rs.getString("nome"), rs.getString("campus"));
				
				Turma turma = new Turma();
				turma.setPeriodo(rs.getString("periodo"));
				turma.setCurso(curso);
					
				AlunoEmTurma AlunoTurma = new AlunoEmTurma(Integer.parseInt(rs.getString("id")), aluno, turma);
				
				return AlunoTurma;
				
			} else {
				throw new Exception("Nada encontrado.");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
