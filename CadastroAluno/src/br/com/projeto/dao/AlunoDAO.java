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
import br.com.projeto.util.ConnectionFactory;

public class AlunoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Aluno aluno;

	public AlunoDAO() throws Exception {

		try {
			conn = ConnectionFactory.getConnection();
		}

		catch (Exception e) {
			throw new Exception("Erro ao conectar ao DB" + e.getMessage());
		}
	}

	public void salvar(Aluno aluno) throws Exception {
		try {
			String sql = "INSERT INTO aluno(rgmaluno,nome,dtanasc,cpf,email,endereco,municipio,uf,celular,curso,campus,periodo)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, aluno.getRgmaluno());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getDtanasc());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getUf());
			ps.setString(9, aluno.getCelular());
			ps.setString(10, aluno.getCurso());
			ps.setString(11, aluno.getCampus());
			ps.setString(12, aluno.getPeriodo());

			ps.executeUpdate();

		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

	public List listarTodos() throws Exception {
		List<Aluno> lista = new ArrayList<Aluno>();

		try {
			ps = conn.prepareStatement("SELECT * FROM aluno");
			rs = ps.executeQuery();
			while (rs.next()) {
				int rgmAluno = rs.getInt("rgmAluno");
				String nome = rs.getString("nome");
				String dtanasc = rs.getString("dtanasc");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String celular = rs.getString("celular");
				String curso = rs.getString("curso");
				String campus = rs.getString("campus");
				String periodo = rs.getString("periodo");
				aluno = new Aluno(rgmAluno,nome,dtanasc,cpf,email,endereco,municipio,uf,celular,curso,campus,periodo);
				lista.add(aluno);
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro ao listar " + e.getLocalizedMessage());
		}
	}

	public void alterar(Aluno aluno) throws Exception {
		try {
			String sql = "UPDATE aluno SET nome=?,dtanasc=?,cpf=?,email=?,endereco=?,municipio=?,uf=?,celular=?,curso=?,campus=?,periodo=?"
					+ " WHERE rgmaluno = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getDtanasc());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getEndereco());
			ps.setString(6, aluno.getMunicipio());
			ps.setString(7, aluno.getUf());
			ps.setString(8, aluno.getCelular());
			ps.setString(9, aluno.getCurso());
			ps.setString(10, aluno.getCampus());
			ps.setString(11, aluno.getPeriodo());
			ps.setInt(12, aluno.getRgmaluno());

			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao alterar: " + e.getMessage());
		}

	}

	public void excluir(int rgmAluno) throws Exception {
		try {
			String sql = "DELETE FROM aluno"
			+ " WHERE rgmaluno = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, rgmAluno);

			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir: " + e.getMessage());
		}

	}

	public Aluno consultar(int rgmAluno) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM aluno WHERE rgmAluno = ?");
			ps.setInt(1, rgmAluno);
			rs = ps.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String dtanasc = rs.getString("dtanasc");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String celular = rs.getString("celular");
				String curso = rs.getString("curso");
				String campus = rs.getString("campus");
				String periodo = rs.getString("periodo");
				aluno = new Aluno(rgmAluno,nome,dtanasc,cpf,email,endereco,municipio,uf,celular,curso,campus,periodo);
			}
			return aluno;
		} catch (Exception e) {
			throw new Exception("Erro ao consultar " + e.getLocalizedMessage());
		}
	}
}
