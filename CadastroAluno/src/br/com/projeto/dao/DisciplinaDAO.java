/* 	NOME: ALAN CARLOS SOUZA DA SILVA
	RGM: 20878435
	TURMA: 3°B
	NOTURNO
*/

package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.model.Aluno;
import br.com.projeto.model.Disciplina;
import br.com.projeto.util.ConnectionFactory;

public class DisciplinaDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Disciplina disciplina;

	public DisciplinaDAO() throws Exception {

		try {
			conn = ConnectionFactory.getConnection();
		}

		catch (Exception e) {
			throw new Exception("Erro ao conectar ao DB" + e.getMessage());
		}
	}

	public void salvar(Disciplina disciplina) throws Exception {
		try {
			String sql = "INSERT INTO disciplina(disciplina,semestre,nota,falta,rgmaluno)"
					+ "VALUES (?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
	
			ps.setString(1, disciplina.getDisciplina());
			ps.setString(2, disciplina.getSemestre());
			ps.setString(3, disciplina.getNota());
			ps.setInt(4, disciplina.getFalta());
			ps.setInt(5, disciplina.getRgmAluno());
			
			ps.executeUpdate();
			
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

	
	public void alterar(Disciplina disciplina,int rgmAluno, String disciplina1) throws Exception {
		try {
			String sql = "UPDATE disciplina SET nota=?,falta=? "
					+ "WHERE rgmaluno = ? and disciplina = ?";

			ps = conn.prepareStatement(sql);
		
			ps.setString(1, disciplina.getNota());
			ps.setInt(2, disciplina.getFalta());
			ps.setInt(3, rgmAluno);
			ps.setString(4, disciplina1);
			
			ps.executeUpdate();
			
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}
	
	public void excluir(int rgmAluno, String disciplina) throws Exception {
		try {
			String sql = "DELETE FROM disciplina"
			+ " WHERE rgmaluno = ? and disciplina=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, rgmAluno);
			ps.setString(2, disciplina);
			
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir: " + e.getMessage());
		}

	}
	public List consultar(int rgmAluno) throws Exception {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			ps = conn.prepareStatement("SELECT * FROM disciplina WHERE rgmAluno = ?");

			ps.setInt(1, rgmAluno);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			
			String disciplina1 = rs.getString("disciplina");
			String semestre = rs.getString("semestre");
			String nota = rs.getString("nota");
			int falta = rs.getInt("falta");
		
			
			disciplina = new Disciplina(disciplina1, semestre, nota, falta, rgmAluno);
			lista.add(disciplina);
			}
			return lista;
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}
	
	public List listarTodos() throws Exception {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		
		try {
			ps = conn.prepareStatement("SELECT * FROM disciplina");
			rs = ps.executeQuery();
			
			if (rs.next()) {
			int rgmAluno = rs.getInt("rgmAluno");
			String disciplina1 = rs.getString("disciplina");
			String semestre = rs.getString("semestre");
			String nota = rs.getString("nota");
			int falta = rs.getInt("falta");
			
			disciplina = new Disciplina(disciplina1, semestre, nota, falta, rgmAluno);
			lista.add(disciplina);
			}
			return lista;
		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}
	
}