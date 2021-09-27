/* 	NOME: ALAN CARLOS SOUZA DA SILVA
	RGM: 20878435
	TURMA: 3°B
	NOTURNO
*/

package br.com.projeto.model;

public class Aluno {
	
	private int rgmaluno;
	private String nome;
	private String dtanasc;
	private String cpf;
	private String email;
	private String endereco;
	private String municipio;
	private String uf;
	private String celular;
	private String curso;
	private String campus;
	private String periodo;
    
    public Aluno() {
    	
    }

	public Aluno(int rgmaluno, String nome, String dtanasc, String cpf, String email, String endereco, String municipio,
			String uf, String celular, String curso, String campus, String periodo) {
		this.rgmaluno = rgmaluno;
		this.nome = nome;
		this.dtanasc = dtanasc;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.celular = celular;
		this.curso = curso;
		this.campus = campus;
		this.periodo = periodo;
	}

	public int getRgmaluno() {
		return rgmaluno;
	}

	public void setRgmaluno(int rgmaluno) {
		this.rgmaluno = rgmaluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtanasc() {
		return dtanasc;
	}

	public void setDtanasc(String dtanasc) {
		this.dtanasc = dtanasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
    
    