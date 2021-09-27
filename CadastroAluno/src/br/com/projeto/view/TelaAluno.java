/* 	NOME: ALAN CARLOS SOUZA DA SILVA
	RGM: 20878435
	TURMA: 3°B
	NOTURNO
*/
package br.com.projeto.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.AlunoDAO;
import br.com.projeto.dao.DisciplinaDAO;
import br.com.projeto.model.Aluno;
import br.com.projeto.model.Disciplina;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JSeparator separator;
	private JTabbedPane tabbedPane;
	private JPanel DadosPessoais;
	private JPanel Curso;
	private JPanel NotasFaltas;
	private JPanel Boletim;
	private JLabel lblRgm;
	private JLabel lblMunicipio;
	private JLabel lblEnd;
	private JLabel lblEmail;
	private JLabel lblDataDeNascimento;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtMunicipio;
	private JFormattedTextField txtDtaNasc;
	private JLabel lblUf;
	private JComboBox cmbUf;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JLabel lblCelular;
	private JFormattedTextField txtCelular;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JComboBox cmbCurso;
	private JComboBox cmbCampus;
	private JRadioButton rdbMatutino;
	private JRadioButton rdbNoturno;
	private JRadioButton rdbVespertino;
	private JButton btnNewButton;
	private JButton btnSair;
	private JButton btnExcluir;
	private final ButtonGroup btngPeriodo = new ButtonGroup();
	private JLabel lblRgmN;
	private JLabel lblNomeNF;
	private JLabel lblCursoNF;
	private JLabel lblDisciplina;
	private JComboBox cmbDisciplina;
	private JLabel lblSemestre;
	private JComboBox cmbSemestre;
	private JLabel lblNota;
	private JTextField txtFalta;
	private JLabel lblFaltas;
	private JComboBox cmbNota;
	private JButton btnSalvarN;
	private JButton btnSairN;
	private JButton bntAlterarN;
	private JButton btnExcluirN;
	private JButton btnAlterar;
	private JTextField txtRgm;
	private JTextField txtRgmNF;
	private TextArea txtListar;
	private JLabel lblRgm_1;
	private JTextField txtRgmB;
	private JLabel lblListarTodos;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblCurso_1;
	private JLabel lblNomeB;
	private JLabel lblCusoB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAluno() throws Exception {
		setTitle("Cadastro Aluno");
		setResizable(false);
		setBackground(UIManager.getColor("Button.darkShadow"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 354);
		this.setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		menuBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ============================

				try {

					Aluno aluno = new Aluno();
					AlunoDAO dao = new AlunoDAO();

					aluno.setRgmaluno(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setDtanasc(txtDtaNasc.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setMunicipio(txtMunicipio.getText());

					if (cmbUf.getSelectedItem().toString().equals("--")) {
						JOptionPane.showMessageDialog(null, "Insira a UF correta!");
					} else {
						aluno.setUf((String) cmbUf.getSelectedItem());
					}

					aluno.setCelular(txtCelular.getText());

					if (cmbCurso.getSelectedItem().toString().equals("Selecione uma opção")) {
						JOptionPane.showMessageDialog(null, "Insira o curso!");
					} else {
						aluno.setCurso((String) cmbCurso.getSelectedItem());
					}

					if (cmbCampus.getSelectedItem().toString().equals("Selecione uma opção")) {
						JOptionPane.showMessageDialog(null, "Insira o campus!");
					} else {
						aluno.setCampus((String) cmbCampus.getSelectedItem());
					}

					if (rdbMatutino.isSelected())
						aluno.setPeriodo("M");

					if (rdbVespertino.isSelected())
						aluno.setPeriodo("V");

					if (rdbNoturno.isSelected())
						aluno.setPeriodo("N");

					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");

					txtNome.setText(null);
					txtDtaNasc.setText(null);
					txtCpf.setText(null);
					txtEmail.setText(null);
					txtEnd.setText(null);
					txtMunicipio.setText(null);
					cmbUf.setSelectedIndex(0);
					txtCelular.setText(null);
					cmbCurso.setSelectedIndex(0);
					cmbCampus.setSelectedIndex(0);
					btngPeriodo.clearSelection();

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}

				// ============================
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Aluno aluno = new Aluno();
					AlunoDAO dao = new AlunoDAO();

					aluno.setRgmaluno(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setDtanasc(txtDtaNasc.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf((String) cmbUf.getSelectedItem());
					aluno.setCelular(txtCelular.getText());
					aluno.setCurso((String) cmbCurso.getSelectedItem());
					aluno.setCampus((String) cmbCampus.getSelectedItem());

					if (rdbMatutino.isSelected())
						aluno.setPeriodo("M");

					if (rdbVespertino.isSelected())
						aluno.setPeriodo("V");

					if (rdbNoturno.isSelected())
						aluno.setPeriodo("N");

					dao.alterar(aluno);

					JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

					txtNome.setText(null);
					txtDtaNasc.setText(null);
					txtCpf.setText(null);
					txtEmail.setText(null);
					txtEnd.setText(null);
					txtMunicipio.setText(null);
					cmbUf.setSelectedIndex(0);
					txtCelular.setText(null);
					cmbCurso.setSelectedIndex(0);
					cmbCampus.setSelectedIndex(0);
					btngPeriodo.clearSelection();

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
				}

			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AlunoDAO dao = new AlunoDAO();

					int codigo = Integer.parseInt(txtRgm.getText());

					Aluno aluno = dao.consultar(codigo);

					List<Aluno> lista = new ArrayList<Aluno>();

					lista = dao.listarTodos();

					boolean registrado = false;

					for (Aluno aluno1 : lista) {
						if (codigo == aluno1.getRgmaluno()) {
							registrado = true;
							break;
						}
					}
					if (registrado == true) {
						txtNome.setText(aluno.getNome());
						txtDtaNasc.setText(aluno.getDtanasc());
						txtCpf.setText(aluno.getCpf());
						txtEmail.setText(aluno.getEmail());
						txtEnd.setText(aluno.getEndereco());
						txtMunicipio.setText(aluno.getMunicipio());
						cmbUf.setSelectedItem(aluno.getUf());
						txtCelular.setText(aluno.getCelular());
						cmbCurso.setSelectedItem(aluno.getCurso());
						cmbCampus.setSelectedItem(aluno.getCampus());

						if (aluno.getPeriodo().equals("M")) {
							rdbMatutino.setSelected(true);
						} else if (aluno.getPeriodo().equals("V")) {
							rdbVespertino.setSelected(true);
						} else if (aluno.getPeriodo().equals("N")) {
							rdbNoturno.setSelected(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar!");
				}

			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AlunoDAO dao = new AlunoDAO();
					int codigo = Integer.parseInt(txtRgm.getText());
					dao.excluir(codigo);
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

					txtRgm.setText(null);
					txtNome.setText(null);
					txtDtaNasc.setText(null);
					txtCpf.setText(null);
					txtEmail.setText(null);
					txtEnd.setText(null);
					txtMunicipio.setText(null);
					cmbUf.setSelectedIndex(0);
					txtCelular.setText(null);
					cmbCurso.setSelectedIndex(0);
					cmbCampus.setSelectedIndex(0);
					btngPeriodo.clearSelection();

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
				}

			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		separator = new JSeparator();
		mnNewMenu.add(separator);

		mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}
		});
		mntmNewMenuItem_4
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);

		mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_5 = new JMenuItem("Salvar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Disciplina disciplina = new Disciplina();
					DisciplinaDAO dao = new DisciplinaDAO();

					if (cmbDisciplina.getSelectedItem().toString().equals("Selecione uma opção")) {
						JOptionPane.showMessageDialog(null, "Insira a disciplina!");
					} else {
						disciplina.setDisciplina((String) cmbDisciplina.getSelectedItem());
					}

					disciplina.setSemestre((String) cmbSemestre.getSelectedItem());

					disciplina.setNota((String) cmbNota.getSelectedItem());
					disciplina.setFalta(Integer.parseInt(txtFalta.getText()));
					disciplina.setRgmAluno(Integer.parseInt(txtRgmNF.getText()));
					dao.salvar(disciplina);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");

					lblNomeNF.setText(null);
					lblCursoNF.setText(null);
					cmbDisciplina.setSelectedIndex(0);
					cmbSemestre.setSelectedIndex(0);
					cmbNota.setSelectedIndex(0);
					txtFalta.setText(null);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);

		mntmNewMenuItem_6 = new JMenuItem("Alterar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ============================
				try {
					Disciplina disciplina = new Disciplina();
					DisciplinaDAO dao = new DisciplinaDAO();

					int codigo = Integer.parseInt(txtRgmNF.getText());
					String codigo1 = (String) cmbDisciplina.getSelectedItem();

					disciplina.setSemestre(((String) cmbSemestre.getSelectedItem()));
					disciplina.setNota((String) cmbNota.getSelectedItem());
					disciplina.setFalta(Integer.parseInt(txtFalta.getText()));

					dao.alterar(disciplina, codigo, codigo1);

					lblNomeNF.setText(null);
					lblCursoNF.setText(null);
					cmbDisciplina.setSelectedIndex(0);
					cmbSemestre.setSelectedIndex(0);
					cmbNota.setSelectedIndex(0);
					txtFalta.setText(null);

					JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
				}

				// ============================
			}
		});
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_6);

		mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Disciplina disciplina = new Disciplina();
					DisciplinaDAO dao = new DisciplinaDAO();

					int codigo = Integer.parseInt(txtRgmNF.getText());
					String codigo1 = (String) cmbDisciplina.getSelectedItem();

					dao.excluir(codigo, codigo1);

					JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

					lblNomeNF.setText(null);
					lblCursoNF.setText(null);
					cmbDisciplina.setSelectedIndex(0);
					cmbSemestre.setSelectedIndex(0);
					cmbNota.setSelectedIndex(0);
					txtFalta.setText(null);
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		mntmNewMenuItem_8 = new JMenuItem("Consultar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AlunoDAO dao = new AlunoDAO();

					int codigo = Integer.parseInt(txtRgmNF.getText());

					Aluno aluno = dao.consultar(codigo);

					List<Aluno> lista = new ArrayList<Aluno>();

					lista = dao.listarTodos();

					boolean registrado = false;

					for (Aluno aluno1 : lista) {
						if (codigo == aluno1.getRgmaluno()) {
							registrado = true;
							break;
						}
					}

					if (registrado == true) {
						lblNomeNF.setText(aluno.getNome());

						lblCursoNF.setText(aluno.getCurso());
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar!");
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);

		mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_9 = new JMenuItem("Sobre");
		mntmNewMenuItem_9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"Bem vindo a tela de cadastro de alunos!\n\nAqui você poderá verificar suas notas e faltas.");

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tabbedPane.setBounds(10, 11, 463, 272);
		contentPane.add(tabbedPane);

		DadosPessoais = new JPanel();
		DadosPessoais.setBorder(new MatteBorder(1, 0, 0, 0, (Color) SystemColor.desktop));
		DadosPessoais.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Dados Pessoais", null, DadosPessoais, null);
		DadosPessoais.setLayout(null);

		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRgm.setBounds(10, 11, 32, 15);
		DadosPessoais.add(lblRgm);

		lblMunicipio = new JLabel("Munic\u00EDpio");
		lblMunicipio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMunicipio.setBounds(10, 181, 58, 15);
		DadosPessoais.add(lblMunicipio);

		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnd.setBounds(10, 139, 27, 15);
		DadosPessoais.add(lblEnd);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 95, 31, 15);
		DadosPessoais.add(lblEmail);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDeNascimento.setBounds(10, 52, 122, 15);
		DadosPessoais.add(lblDataDeNascimento);

		txtEmail = new JTextField();
		txtEmail.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(78, 92, 368, 20);
		DadosPessoais.add(txtEmail);

		txtEnd = new JTextField();
		txtEnd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnd.setColumns(10);
		txtEnd.setBounds(78, 136, 368, 20);
		DadosPessoais.add(txtEnd);

		txtMunicipio = new JTextField();
		txtMunicipio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(78, 178, 117, 20);
		DadosPessoais.add(txtMunicipio);

		txtDtaNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDtaNasc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtDtaNasc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDtaNasc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDtaNasc.setBounds(142, 49, 96, 20);
		DadosPessoais.add(txtDtaNasc);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(204, 181, 14, 15);
		DadosPessoais.add(lblUf);

		cmbUf = new JComboBox();
		cmbUf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cmbUf.setModel(new DefaultComboBoxModel(
				new String[] { "--", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
						"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
		cmbUf.setBounds(228, 179, 49, 20);
		DadosPessoais.add(cmbUf);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(184, 11, 34, 15);
		DadosPessoais.add(lblNome);

		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(255, 52, 22, 15);
		DadosPessoais.add(lblCpf);

		txtNome = new JTextField();
		txtNome.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(228, 8, 218, 20);
		DadosPessoais.add(txtNome);

		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCpf.setBounds(287, 50, 159, 20);
		DadosPessoais.add(txtCpf);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCelular.setBounds(291, 181, 41, 15);
		DadosPessoais.add(lblCelular);

		txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtCelular.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCelular.setBounds(342, 178, 104, 20);
		DadosPessoais.add(txtCelular);

		txtRgm = new JTextField();
		txtRgm.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtRgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					AlunoDAO dao = new AlunoDAO();

					int codigo = Integer.parseInt(txtRgm.getText());

					Aluno aluno = dao.consultar(codigo);

					List<Aluno> lista = new ArrayList<Aluno>();

					lista = dao.listarTodos();

					boolean registrado = false;

					for (Aluno aluno1 : lista) {
						if (codigo == aluno1.getRgmaluno()) {
							registrado = true;
							break;
						}
					}
					if (registrado == true) {
						txtNome.setText(aluno.getNome());
						txtDtaNasc.setText(aluno.getDtanasc());
						txtCpf.setText(aluno.getCpf());
						txtEmail.setText(aluno.getEmail());
						txtEnd.setText(aluno.getEndereco());
						txtMunicipio.setText(aluno.getMunicipio());
						cmbUf.setSelectedItem(aluno.getUf());
						txtCelular.setText(aluno.getCelular());
						cmbCurso.setSelectedItem(aluno.getCurso());
						cmbCampus.setSelectedItem(aluno.getCampus());

						if (aluno.getPeriodo().equals("M")) {
							rdbMatutino.setSelected(true);
						} else if (aluno.getPeriodo().equals("V")) {
							rdbVespertino.setSelected(true);
						} else if (aluno.getPeriodo().equals("N")) {
							rdbNoturno.setSelected(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar!");
				}

			}
		});
		txtRgm.setBounds(78, 9, 96, 20);
		DadosPessoais.add(txtRgm);
		txtRgm.setColumns(10);

		Curso = new JPanel();
		Curso.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Curso", null, Curso, null);
		Curso.setLayout(null);

		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(10, 11, 46, 14);
		Curso.add(lblCurso);

		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCampus.setBounds(10, 52, 46, 14);
		Curso.add(lblCampus);

		lblPeriodo = new JLabel("Per\u00EDodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeriodo.setBounds(10, 92, 46, 14);
		Curso.add(lblPeriodo);

		cmbCurso = new JComboBox();
		cmbCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cmbCurso.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione uma op\u00E7\u00E3o", "An\u00E1lise e Desenvolvimento de Sistemas" }));
		cmbCurso.setBounds(66, 9, 382, 20);
		Curso.add(cmbCurso);

		cmbCampus = new JComboBox();
		cmbCampus.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cmbCampus.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione uma op\u00E7\u00E3o", "Jabaquara", "Tatuap\u00E9" }));
		cmbCampus.setBounds(66, 50, 382, 20);
		Curso.add(cmbCampus);

		rdbMatutino = new JRadioButton("Matutino");
		rdbMatutino.setBackground(SystemColor.activeCaption);
		rdbMatutino.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btngPeriodo.add(rdbMatutino);
		rdbMatutino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbMatutino.setBounds(89, 88, 73, 23);
		Curso.add(rdbMatutino);

		rdbNoturno = new JRadioButton("Noturno");
		rdbNoturno.setBackground(SystemColor.activeCaption);
		rdbNoturno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btngPeriodo.add(rdbNoturno);
		rdbNoturno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbNoturno.setBounds(342, 88, 73, 23);
		Curso.add(rdbNoturno);

		rdbVespertino = new JRadioButton("Vespertino");
		rdbVespertino.setBackground(SystemColor.activeCaption);
		rdbVespertino.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btngPeriodo.add(rdbVespertino);
		rdbVespertino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbVespertino.setBounds(219, 88, 85, 23);
		Curso.add(rdbVespertino);

		btnNewButton = new JButton("");
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\save_3621.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Aluno aluno = new Aluno();
					AlunoDAO dao = new AlunoDAO();

					if (txtRgm.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Insira o RGM");
					} else {
						aluno.setRgmaluno(Integer.parseInt(txtRgm.getText()));
					}

					aluno.setNome(txtNome.getText());
					aluno.setDtanasc(txtDtaNasc.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setMunicipio(txtMunicipio.getText());

					if (cmbUf.getSelectedItem().toString().equals("--")) {
						JOptionPane.showMessageDialog(null, "Insira a UF!");
					} else {
						aluno.setUf((String) cmbUf.getSelectedItem());
					}

					aluno.setCelular(txtCelular.getText());

					if (cmbCurso.getSelectedItem().toString().equals("Selecione uma opção")) {
						JOptionPane.showMessageDialog(null, "Insira o curso!");
					} else {
						aluno.setCurso((String) cmbCurso.getSelectedItem());
					}

					if (cmbCampus.getSelectedItem().toString().equals("Selecione uma opção")) {
						JOptionPane.showMessageDialog(null, "Insira o campus!");
					} else {
						aluno.setCampus((String) cmbCampus.getSelectedItem());
					}

					if (rdbMatutino.isSelected())
						aluno.setPeriodo("M");

					if (rdbVespertino.isSelected())
						aluno.setPeriodo("V");

					if (rdbNoturno.isSelected())
						aluno.setPeriodo("N");

					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");

					txtNome.setText(null);
					txtDtaNasc.setText(null);
					txtCpf.setText(null);
					txtEmail.setText(null);
					txtEnd.setText(null);
					txtMunicipio.setText(null);
					cmbUf.setSelectedIndex(0);
					txtCelular.setText(null);
					cmbCurso.setSelectedIndex(0);
					cmbCampus.setSelectedIndex(0);
					btngPeriodo.clearSelection();

				}

				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}

			}
		});
		btnNewButton.setBounds(10, 141, 73, 65);
		Curso.add(btnNewButton);

		btnSair = new JButton("");
		btnSair.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSair.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Sair.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(375, 141, 73, 65);
		Curso.add(btnSair);

		btnExcluir = new JButton("");
		btnExcluir.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Excluir.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AlunoDAO dao = new AlunoDAO();
					int codigo = Integer.parseInt(txtRgm.getText());
					dao.excluir(codigo);
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

					txtRgm.setText(null);
					txtNome.setText(null);
					txtDtaNasc.setText(null);
					txtCpf.setText(null);
					txtEmail.setText(null);
					txtEnd.setText(null);
					txtMunicipio.setText(null);
					cmbUf.setSelectedIndex(0);
					txtCelular.setText(null);
					cmbCurso.setSelectedIndex(0);
					cmbCampus.setSelectedIndex(0);
					btngPeriodo.clearSelection();

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
				}

			}
		});
		btnExcluir.setBounds(256, 141, 73, 65);
		Curso.add(btnExcluir);

		btnAlterar = new JButton("");
		btnAlterar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAlterar.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Alterar.png"));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Aluno aluno = new Aluno();
					AlunoDAO dao = new AlunoDAO();

					aluno.setRgmaluno(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setDtanasc(txtDtaNasc.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf((String) cmbUf.getSelectedItem());
					aluno.setCelular(txtCelular.getText());
					aluno.setCurso((String) cmbCurso.getSelectedItem());
					aluno.setCampus((String) cmbCampus.getSelectedItem());

					if (rdbMatutino.isSelected())
						aluno.setPeriodo("M");

					if (rdbVespertino.isSelected())
						aluno.setPeriodo("V");

					if (rdbNoturno.isSelected())
						aluno.setPeriodo("N");

					dao.alterar(aluno);

					JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

					txtNome.setText(null);
					txtDtaNasc.setText(null);
					txtCpf.setText(null);
					txtEmail.setText(null);
					txtEnd.setText(null);
					txtMunicipio.setText(null);
					cmbUf.setSelectedIndex(0);
					txtCelular.setText(null);
					cmbCurso.setSelectedIndex(0);
					cmbCampus.setSelectedIndex(0);
					btngPeriodo.clearSelection();

				}

				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
				}

			}
		});
		btnAlterar.setBounds(134, 141, 73, 65);
		Curso.add(btnAlterar);

		NotasFaltas = new JPanel();
		NotasFaltas.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Notas e Faltas", null, NotasFaltas, null);
		NotasFaltas.setLayout(null);

		lblRgmN = new JLabel("RGM");
		lblRgmN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRgmN.setBounds(10, 11, 46, 14);
		NotasFaltas.add(lblRgmN);

		lblNomeNF = new JLabel("");
		lblNomeNF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeNF.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));
		lblNomeNF.setBounds(162, 9, 286, 20);
		NotasFaltas.add(lblNomeNF);

		lblCursoNF = new JLabel("");
		lblCursoNF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCursoNF.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));
		lblCursoNF.setBounds(10, 36, 438, 20);
		NotasFaltas.add(lblCursoNF);

		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisciplina.setBounds(10, 67, 56, 15);
		NotasFaltas.add(lblDisciplina);

		cmbDisciplina = new JComboBox();
		cmbDisciplina.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] { "Selecione uma op\u00E7\u00E3o",
				"An\u00E1lise e Projeto de Sistemas", "Banco de Dados", "Ergonomia e Seguran\u00E7a do Trabalho",
				"Engenharia de Software", "Fundamentos de Estruturas de Dados", "Redes de Computadores",
				"T\u00E9cnicas de Programa\u00E7\u00E3o" }));
		cmbDisciplina.setBounds(76, 65, 372, 20);
		NotasFaltas.add(cmbDisciplina);

		lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSemestre.setBounds(9, 93, 57, 15);
		NotasFaltas.add(lblSemestre);

		cmbSemestre = new JComboBox();
		cmbSemestre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] { "2020-1" }));
		cmbSemestre.setBounds(76, 91, 86, 20);
		NotasFaltas.add(cmbSemestre);

		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota.setBounds(191, 93, 29, 15);
		NotasFaltas.add(lblNota);

		txtFalta = new JTextField();
		txtFalta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtFalta.setColumns(10);
		txtFalta.setBounds(377, 91, 71, 20);
		NotasFaltas.add(txtFalta);

		lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFaltas.setBounds(332, 93, 35, 15);
		NotasFaltas.add(lblFaltas);

		cmbNota = new JComboBox();
		cmbNota.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cmbNota.setModel(new DefaultComboBoxModel(new String[] { "0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5",
				"4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10" }));
		cmbNota.setBounds(230, 91, 71, 20);
		NotasFaltas.add(cmbNota);

		btnSalvarN = new JButton("");
		btnSalvarN.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSalvarN.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\save_3621.png"));
		btnSalvarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Disciplina disciplina = new Disciplina();
					DisciplinaDAO dao = new DisciplinaDAO();

					if (cmbDisciplina.getSelectedItem().toString().equals("Selecione uma opção")) {
						JOptionPane.showMessageDialog(null, "Insira a disciplina!");
					} else {
						disciplina.setDisciplina((String) cmbDisciplina.getSelectedItem());
					}

					disciplina.setSemestre((String) cmbSemestre.getSelectedItem());

					disciplina.setNota((String) cmbNota.getSelectedItem());
					disciplina.setFalta(Integer.parseInt(txtFalta.getText()));
					disciplina.setRgmAluno(Integer.parseInt(txtRgmNF.getText()));
					dao.salvar(disciplina);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");

					lblNomeNF.setText(null);
					lblCursoNF.setText(null);
					cmbDisciplina.setSelectedIndex(0);
					cmbSemestre.setSelectedIndex(0);
					cmbNota.setSelectedIndex(0);
					txtFalta.setText(null);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}

			}
		});
		btnSalvarN.setBounds(10, 141, 73, 65);
		NotasFaltas.add(btnSalvarN);

		btnSairN = new JButton("");
		btnSairN.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSairN.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Sair.png"));
		btnSairN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSairN.setBounds(375, 141, 73, 65);
		NotasFaltas.add(btnSairN);

		bntAlterarN = new JButton("");
		bntAlterarN.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		bntAlterarN.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Alterar.png"));
		bntAlterarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Disciplina disciplina = new Disciplina();
					DisciplinaDAO dao = new DisciplinaDAO();

					int codigo = Integer.parseInt(txtRgmNF.getText());
					String codigo1 = (String) cmbDisciplina.getSelectedItem();

					disciplina.setSemestre(((String) cmbSemestre.getSelectedItem()));
					disciplina.setNota((String) cmbNota.getSelectedItem());
					disciplina.setFalta(Integer.parseInt(txtFalta.getText()));

					dao.alterar(disciplina, codigo, codigo1);

					lblNomeNF.setText(null);
					lblCursoNF.setText(null);
					cmbDisciplina.setSelectedIndex(0);
					cmbSemestre.setSelectedIndex(0);
					cmbNota.setSelectedIndex(0);
					txtFalta.setText(null);

					JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

				}

				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
				}

			}
		});
		bntAlterarN.setBounds(134, 141, 73, 65);
		NotasFaltas.add(bntAlterarN);

		btnExcluirN = new JButton("");
		btnExcluirN.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnExcluirN.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Excluir.png"));
		btnExcluirN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Disciplina disciplina = new Disciplina();
					DisciplinaDAO dao = new DisciplinaDAO();

					int codigo = Integer.parseInt(txtRgmNF.getText());
					String codigo1 = (String) cmbDisciplina.getSelectedItem();

					dao.excluir(codigo, codigo1);

					JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

					lblNomeNF.setText(null);
					lblCursoNF.setText(null);
					cmbDisciplina.setSelectedIndex(0);
					cmbSemestre.setSelectedIndex(0);
					cmbNota.setSelectedIndex(0);
					txtFalta.setText(null);
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
				}

			}
		});
		btnExcluirN.setBounds(256, 141, 73, 65);
		NotasFaltas.add(btnExcluirN);

		txtRgmNF = new JTextField();
		txtRgmNF.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtRgmNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AlunoDAO dao = new AlunoDAO();

					int codigo = Integer.parseInt(txtRgmNF.getText());

					Aluno aluno = dao.consultar(codigo);

					List<Aluno> lista = new ArrayList<Aluno>();

					lista = dao.listarTodos();

					boolean registrado = false;

					for (Aluno aluno1 : lista) {
						if (codigo == aluno1.getRgmaluno()) {
							registrado = true;
							break;
						}
					}

					if (registrado == true) {
						lblNomeNF.setText(aluno.getNome());

						lblCursoNF.setText(aluno.getCurso());
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar!");
				}

			}
		});
		txtRgmNF.setBounds(66, 9, 86, 20);
		NotasFaltas.add(txtRgmNF);
		txtRgmNF.setColumns(10);

		Boletim = new JPanel();
		Boletim.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Boletim", null, Boletim, null);
		Boletim.setLayout(null);

		txtListar = new TextArea();
		txtListar.setBounds(10, 69, 438, 122);
		Boletim.add(txtListar);

		lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRgm_1.setBounds(10, 11, 28, 16);
		Boletim.add(lblRgm_1);

		txtRgmB = new JTextField();
		txtRgmB.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtRgmB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Disciplina> lista = new ArrayList<Disciplina>();
				try {

					AlunoDAO dao = new AlunoDAO();
					DisciplinaDAO dao1 = new DisciplinaDAO();

					int codigo = Integer.parseInt(txtRgmB.getText());

					Aluno aluno = dao.consultar(codigo);

					lista = dao1.consultar(codigo);

					List<Aluno> lista1 = new ArrayList<Aluno>();

					lista1 = dao.listarTodos();

					boolean registrado = false;

					for (Aluno aluno1 : lista1) {
						if (codigo == aluno1.getRgmaluno()) {
							registrado = true;
							break;
						}
					}

					if (registrado == true) {

						lblNomeB.setText(aluno.getNome());
						lblCusoB.setText(aluno.getCurso());
						txtListar.append("Celular: " + aluno.getCelular() + "\n");
						txtListar.append("Email: " + aluno.getEmail() + "\n");
						txtListar.append("Campus: " + aluno.getCampus() + "\t\t\t\t");

						if (aluno.getPeriodo().equals("M")) {
							txtListar.append("Periodo: Matutino\n");
						} else if (aluno.getPeriodo().equals("V")) {
							txtListar.append("Periodo: Vespertino\n");
						} else if (aluno.getPeriodo().equals("N")) {
							txtListar.append("Periodo: Noturno\n");
						}

						for (Disciplina disciplina : lista) {
							txtListar.append("\nDisciplina: " + disciplina.getDisciplina() + "\n");
							txtListar.append("Semestre: " + disciplina.getSemestre());
							txtListar.append("\t\tNota: " + disciplina.getNota());
							txtListar.append("\t\tFaltas: " + disciplina.getFalta() + "\n");

						}
						txtListar.append("=======================================================\n\n");
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar!");
				}

			}
		});
		txtRgmB.setBounds(58, 9, 86, 23);
		Boletim.add(txtRgmB);
		txtRgmB.setColumns(10);

		lblListarTodos = new JLabel("LISTAR TODOS");
		lblListarTodos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListarTodos.setBounds(10, 210, 92, 16);
		Boletim.add(lblListarTodos);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Pesquisar.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					List<Aluno> lista = new ArrayList<Aluno>();

					AlunoDAO dao = new AlunoDAO();
					lista = dao.listarTodos();

					for (Aluno aluno : lista) {
						txtListar.append("RGM: " + aluno.getRgmaluno() + "\n");
						txtListar.append("Nome: " + aluno.getNome() + "\n");
						txtListar.append("Data de Nascimento: " + aluno.getDtanasc());
						txtListar.append("\t\t\tCPF: " + aluno.getCpf() + "\n");
						txtListar.append("Celular: " + aluno.getCelular() + "\n");
						txtListar.append("Email: " + aluno.getEmail() + "\n");
						txtListar.append("Endereço: " + aluno.getEndereco() + "\n");
						txtListar.append("Município: " + aluno.getMunicipio() + "\t\t\t\t\t");
						txtListar.append("UF: " + aluno.getUf() + "\n");
						txtListar.append("Curso: " + aluno.getCurso() + "\n");
						txtListar.append("Campus: " + aluno.getCampus() + "\t\t\t\t");

						if (aluno.getPeriodo().equals("M")) {
							txtListar.append("Periodo: Matutino\n");
						} else if (aluno.getPeriodo().equals("V")) {
							txtListar.append("Periodo: Vespertino\n");
						} else if (aluno.getPeriodo().equals("N")) {
							txtListar.append("Periodo: Noturno\n\n");
						}

						txtListar.append("=======================================================\n\n");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar!");
				}

			}
		});
		btnNewButton_1.setBounds(112, 192, 45, 41);
		Boletim.add(btnNewButton_1);

		btnNewButton_2 = new JButton("LIMPAR DADOS");
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtListar.setText(null);
				lblNomeB.setText(null);
				lblCusoB.setText(null);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(299, 197, 147, 41);
		Boletim.add(btnNewButton_2);

		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(165, 11, 35, 16);
		Boletim.add(lblNewLabel);

		lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurso_1.setBounds(10, 38, 37, 16);
		Boletim.add(lblCurso_1);

		lblNomeB = new JLabel("");
		lblNomeB.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeB.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));
		lblNomeB.setBounds(210, 11, 238, 21);
		Boletim.add(lblNomeB);

		lblCusoB = new JLabel("");
		lblCusoB.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCusoB.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), SystemColor.desktop,
				SystemColor.desktop, SystemColor.desktop));
		lblCusoB.setBounds(58, 38, 390, 21);
		Boletim.add(lblCusoB);
	}
}