/* 	NOME: ALAN CARLOS SOUZA DA SILVA
	RGM: 20878435
	TURMA: 3°B
	NOTURNO
*/

package br.com.projeto.model;

public class Disciplina {

	private String disciplina;
	private String semestre;
	private String nota;
	private int falta;
	private int rgmAluno;

	public Disciplina() {

	}

	public Disciplina(String disciplina, String semestre, String nota, int falta, int rgmaluno) {
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.nota = nota;
		this.falta = falta;
		this.rgmAluno = rgmaluno;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public int getFalta() {
		return falta;
	}

	public void setFalta(int falta) {
		this.falta = falta;
	}

	public int getRgmAluno() {
		return rgmAluno;
	}

	public void setRgmAluno(int rgmaluno) {
		this.rgmAluno = rgmaluno;
	}

}