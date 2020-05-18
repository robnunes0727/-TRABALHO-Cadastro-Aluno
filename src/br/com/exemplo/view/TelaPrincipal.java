package br.com.exemplo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JDialog;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.AlunoDAO;
import br.com.exemplo.dao.AlunoEmTurmaDAO;
import br.com.exemplo.dao.BoletimDAO;
import br.com.exemplo.dao.DisciplinaEmCursoDAO;
import br.com.exemplo.dao.NotasFaltasDAO;
import br.com.exemplo.model.Aluno;
import br.com.exemplo.model.AlunoEmTurma;
import br.com.exemplo.model.Boletim;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.Disciplina;
import br.com.exemplo.model.DisciplinaEmCurso;
import br.com.exemplo.model.NotasFaltas;
import br.com.exemplo.model.Turma;
import br.com.exemplo.util.Globals;
import net.miginfocom.swing.MigLayout;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenuItem mnAlSalvar;
	private JMenuItem mnAlAlterar;
	private JMenuItem mnAlConsultar;
	private JMenuItem mnAlExcluir;
	private JMenuItem mnAlSair;
	private JSeparator mnAlSeparator;
	private JMenu mnNotasFaltas;
	private JMenuItem mnNtSalvar;
	private JMenuItem mnNtAlterar;
	private JMenuItem mnNtExcluir;
	private JMenuItem mnNtConsultar;
	private JMenu mnAjuda;
	private JMenuItem mnAjSobre;
	private JTabbedPane tabbedPane;
	private JTextField txtStatus;
	private JPanel tabDadosPessoais;
	private JPanel tabCurso;
	private JPanel tabNotasFaltas;
	private JPanel tabBoletim;
	private JSeparator separator;
	private JMenuItem mnAjLicensas;
	private JLabel lblRgm;
	private JFormattedTextField txtRgm;
	private JLabel lblNome;
	private JTextField txtNome;
	private JFormattedTextField txtNasc;
	private JLabel lblNasc;
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblEnd;
	private JTextField txtEndereco;
	private JLabel lblMunicipio;
	private JFormattedTextField txtMunicipio;
	private JLabel lblEstado;
	private JComboBox cmbEstado;
	private JLabel lblCel;
	private JFormattedTextField txtCelular;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JComboBox cmbCurso;
	private JComboBox cmbCampus;
	private JRadioButton rdMatutino;
	private JRadioButton rdVespertino;
	private JRadioButton rdNoturno;
	private final ButtonGroup rdGrpPeriodo = new ButtonGroup();
	private JButton btnCursoConsulta;
	private JButton btnCursoAlterar;
	private JButton btnCursoInserir;
	private JButton btnCursoExcluir;
	private JLabel lblBoletimRGM;
	private JLabel lblBoletimSemestre;
	private JFormattedTextField txtBoletimRGM;
	private JComboBox cmbBoletimSemestre;
	private JLabel lblNotasRGM;
	private JFormattedTextField txtNotasRGM;
	private JTextField txtNotasCurso;
	private JTextField txtNotasNome;
	private JComboBox cmbNotasSemestre;
	private JLabel lblNotasSemestre;
	private JLabel lblNotasNota;
	private JComboBox cmbNotasNota;
	private JLabel lblNotasFaltas;
	private JButton btnNewButton;
	private JButton btnNotasInserir;
	private JButton btnNotasConsulta;
	private JButton btnNotasAlterar;
	private JButton btnNotasExcluir;
	private JButton btnAlunoInserir;
	private JButton btnAlunoConsulta;
	private JButton btnAlunoAlterar;
	private JButton btnAlunoExcluir;
	private JLabel lblNotasDisciplina;
	private JComboBox cmbNotasDisciplina;
	private JLabel lblSemestre;
	private JLabel lblOnicoCurso;
	private JLabel lblOnicoCurso_1;
	private JComboBox cmbCursoSemestre;
	private JButton btnNovo;
	private JButton btnCursoNovo;
	private JButton btnNotasNovo;
	private JTable tbBoletim;
	private DefaultTableModel tModel;
	private JScrollPane scrollPane;
	private JMenu mnBancoDeDados;
	private JCheckBoxMenuItem mnLocal;
	private JCheckBoxMenuItem mnRemoto;
	private final ButtonGroup rdGrpBanco = new ButtonGroup();
	private JSeparator separator_1;
	private JMenuItem mnExplicacao;
	private JMenuItem mntmCdigoSql;
	private JSpinner txtNotasFaltas;
	private boolean[] erroDados = new boolean[] {true, true, true, true, true, true, true, true}; 
											    // rgm,nome, nasc,  cpf, email, end, munic, celular 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() throws Exception {
		
		setIconImage(new ImageIcon(getClass().getResource("/icones/icon.png")).getImage());
		setFont(new Font("Verdana", Font.PLAIN, 18));		
		setTitle("Cadastro Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);
		
		mnAlSalvar = new JMenuItem("Salvar");
		mnAlSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// MENU ALUNO > Salvar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoSalvar();
						return null;
					}
				}.execute();
				enableDisable(contentPane, true);
				enableDisable(menuBar, true);
				// Fim ALUNO > Salvar
			}
		});
		mnAlSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnAluno.add(mnAlSalvar);
		
		mnAlAlterar = new JMenuItem("Alterar");
		mnAlAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MENU ALUNO > ALTERAR
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				mudarStatus("Executando...");
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoAlterar();
						return null;
					}
				}.execute();
				enableDisable(contentPane, true);
				enableDisable(menuBar, true);
				// FIM
			}
		});
		mnAluno.add(mnAlAlterar);
		
		mnAlConsultar = new JMenuItem("Consultar");
		mnAlConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// MENU Aluno consultar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoConsultar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
				// FIM aluno consultar
			}
		});
		mnAluno.add(mnAlConsultar);
		
		mnAlExcluir = new JMenuItem("Excluir");
		mnAlExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// MENU EXCLUIR
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoExcluir();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
				// FIM
			}
		});
		mnAluno.add(mnAlExcluir);
		
		mnAlSeparator = new JSeparator();
		mnAluno.add(mnAlSeparator);
		
		mnAlSair = new JMenuItem("Sair");
		mnAlSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Menu > Aluno > Sair
				try {
					Saida dialog = new Saida();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Fim botão Sair
			}
		});
		mnAlSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mnAluno.add(mnAlSair);
		
		mnNotasFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasFaltas);
		
		mnNtSalvar = new JMenuItem("Salvar");
		mnNtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Menu NOTAS salvar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasSalvar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		mnNotasFaltas.add(mnNtSalvar);
		
		mnNtAlterar = new JMenuItem("Alterar");
		mnNtAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Menu NOTAS Alterar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);;
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasAlterar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		mnNtAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNotasFaltas.add(mnNtAlterar);
		
		mnNtExcluir = new JMenuItem("Excluir");
		mnNtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasExcluir();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		mnNotasFaltas.add(mnNtExcluir);
		
		mnNtConsultar = new JMenuItem("Consultar");
		mnNtConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MENU NOTAS CONSULTAR
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasConsultar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		mnNotasFaltas.add(mnNtConsultar);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mnAjSobre = new JMenuItem("Sobre");
		mnAjSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Menu > Ajuda > Sobre
				
				// Copiado da main do Sobre.java
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				// Fim botão sobre
			}
		});
		mnAjSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAjuda.add(mnAjSobre);
		
		separator = new JSeparator();
		mnAjuda.add(separator);
		
		mnAjLicensas = new JMenuItem("Licenças");
		mnAjLicensas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Botão licenças
				try {
					Licenca dialog = new Licenca();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Fim botão licensas
			}
		});
		mnAjuda.add(mnAjLicensas);
		
		mnBancoDeDados = new JMenu("Banco de Dados");
		menuBar.add(mnBancoDeDados);
		
		mnLocal = new JCheckBoxMenuItem("Localhost (rápido)");
		mnLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTrocarBanco();
			}
		});
		rdGrpBanco.add(mnLocal);
		mnBancoDeDados.add(mnLocal);
		
		mnRemoto = new JCheckBoxMenuItem("Remoto (lento)");
		mnRemoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTrocarBanco();
			}
		});
		rdGrpBanco.add(mnRemoto);
		mnBancoDeDados.add(mnRemoto);
		
		if (Globals.banco == 1) {
			mnRemoto.setSelected(true);
			mnLocal.setSelected(false);
		} else {
			mnRemoto.setSelected(false);
			mnLocal.setSelected(true);
		}
		separator_1 = new JSeparator();
		mnBancoDeDados.add(separator_1);
		
		mnExplicacao = new JMenuItem("Explicação");
		mnExplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Caso o MySQL Connector 8.0 não funcione, usar o banco remoto", "Banco de dados", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		mntmCdigoSql = new JMenuItem("Código SQL");
		mntmCdigoSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CodigoSQL dialog = new CodigoSQL();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnBancoDeDados.add(mntmCdigoSql);
		mnBancoDeDados.add(mnExplicacao);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 664, 333);
		contentPane.add(tabbedPane);
		
		tabDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, tabDadosPessoais, "Dados pessoais do aluno.");
		tabDadosPessoais.setLayout(new MigLayout("", "[][120px:120px:120px,grow][][][170:170:170,grow][grow]", "[][][][][][][10][]"));
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblRgm, "cell 0 0,alignx right");
		
		txtRgm = new JFormattedTextField(new MaskFormatter("########"));
		txtRgm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtRgm.getText().trim().isEmpty()){
					txtRgm.setBackground(Color.RED);
					mudarStatus("RGM inválido.");
					tabbedPane.setEnabledAt(1, false);
					erroDados[0] = true;
				}
				else {
					txtRgm.setBackground(Color.WHITE);
					mudarStatus("");
					if (!txtRgm.getText().contains(" "))
						tabbedPane.setEnabledAt(1, true);
					erroDados[0] = false;
				}
			}
		});
		txtRgm.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabDadosPessoais.add(txtRgm, "cell 1 0,growx");
		txtRgm.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblNome, "cell 3 0,alignx trailing");
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String chars = "[0-9]|\\!|\\@|\\#|\\$|\\&|\\*|\\\\|\\(|\\)|\\=|\\-|\\+|\\>|\\<|\\;|\\/|\\,|\\|"; //regex
				if(txtNome.getText().trim().isEmpty() || txtNome.getText().replaceAll(chars, "%").contains("%")){
					txtNome.setBackground(Color.RED);
					mudarStatus("Nome em branco / inválido.");
					erroDados[1] = true;
				}
				else {
					txtNome.setBackground(Color.WHITE);
					mudarStatus("");
					erroDados[1] = false;
				}
			}
		});
		txtNome.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNome.setColumns(10);
		tabDadosPessoais.add(txtNome, "cell 4 0 2 1,growx");
		
		lblNasc = new JLabel("Nasc.");
		lblNasc.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblNasc, "cell 0 1,alignx right");
		
		txtNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNasc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Textfield data
				// Ação que valida se a data é válida.
				// regex: https://stackoverflow.com/questions/13194322/php-regex-to-check-date-is-in-yyyy-mm-dd-format
				String padraoData = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])"
						+ "\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0"
						+ "[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|"
						+ "1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|"
						+ "(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|"
						+ "[13579][26])|((16|[2468][048]|[3579][26])00))))$";			
				
				if(!txtNasc.getText().matches(padraoData)){
					txtNasc.setBackground(Color.RED);
					mudarStatus("Data inválida.");
					erroDados[2] = true;
				}
				else {
					mudarStatus("");
					txtNasc.setBackground(Color.WHITE);
					erroDados[2] = false;
				}
			}
		});
		// Fim data
		txtNasc.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabDadosPessoais.add(txtNasc, "cell 1 1,growx");
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblCpf, "cell 3 1,alignx trailing");
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtCpf.getText().contains(" ")){
					txtCpf.setBackground(Color.RED);
					mudarStatus("CPF inválido.");
					erroDados[3] = true;
				}
				else {
					txtCpf.setBackground(Color.WHITE);
					mudarStatus("");
					erroDados[3] = false;
				}
			}
		});
		txtCpf.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabDadosPessoais.add(txtCpf, "cell 4 1,growx");
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblEmail, "cell 0 2,alignx right");
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtEmail.getText().trim().isEmpty() || !txtEmail.getText().contains("@")){
					txtEmail.setBackground(Color.RED);
					mudarStatus("E-mail invalido.");
					erroDados[4] = true;
				}
				else {
					txtEmail.setBackground(Color.WHITE);
					mudarStatus("");
					erroDados[4] = false;
				}
			}
		});
		txtEmail.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		tabDadosPessoais.add(txtEmail, "cell 1 2 5 1,growx");
		
		lblEnd = new JLabel("Endereço");
		lblEnd.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblEnd, "cell 0 3,alignx right");
		
		txtEndereco = new JTextField();
		txtEndereco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtEndereco.getText().trim().isEmpty()){
					txtEndereco.setBackground(Color.RED);
					mudarStatus("Endereço em branco.");
					erroDados[5] = true;
				}
				else {
					txtEndereco.setBackground(Color.WHITE);
					mudarStatus("");
					erroDados[5] = false;
				}
			}
		});
		txtEndereco.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtEndereco.setColumns(10);
		tabDadosPessoais.add(txtEndereco, "cell 1 3 5 1,growx");
		
		lblMunicipio = new JLabel("Município");
		lblMunicipio.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblMunicipio, "cell 0 4,alignx right");
		
		txtMunicipio = new JFormattedTextField();
		txtMunicipio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String p = "^([\\.\\ \\u00c0-\\u01ffa-zA-Z'\\-])+$";
				if (!txtMunicipio.getText().matches(p)) {
					txtMunicipio.setBackground(Color.RED);
					mudarStatus("Caracteres invalidos no campo Municipio.");
					erroDados[6] = true;
				} else {
					txtMunicipio.setBackground(Color.WHITE);
					mudarStatus("");
					erroDados[6] = false;
				}
			}
		});
		txtMunicipio.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtMunicipio.setColumns(10);
		tabDadosPessoais.add(txtMunicipio, "cell 1 4 4 1,growx");
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblEstado, "cell 0 5,alignx trailing");
		
		cmbEstado = new JComboBox();
		cmbEstado.addItemListener(new ItemListener() {
			// Ação que checa se a UF é válida.
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbEstado.getSelectedItem() == "--") {
					cmbEstado.setSelectedIndex(0);
					mudarStatus("UF inválida, alterado para SP.");
				}
			}
		});
		// Fim UF
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"SP", "--", "AC", "AL", "AP", "AM", "BA", "CE", "DF",
				"ES", "GO", "MA","MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR",
				"SC", "SP", "SE", "TO"}));
		cmbEstado.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabDadosPessoais.add(cmbEstado, "cell 1 5,growx");
		
		lblCel = new JLabel("Celular");
		lblCel.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblCel, "cell 3 5,alignx trailing");
		
		txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtCelular.getText().contains("  ")){
					txtCelular.setBackground(Color.RED);
					mudarStatus("Celular em branco.");
					erroDados[7] = true;
				}
				else {
					txtCelular.setBackground(Color.WHITE);
					mudarStatus("");
					erroDados[7] = false;
				}
			}
		});
		txtCelular.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtCelular.setColumns(10);
		tabDadosPessoais.add(txtCelular, "cell 4 5,growx");
		
		btnAlunoInserir = new JButton("");
		btnAlunoInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Botão AlunoSalvar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoSalvar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoNovo();
			}
		});
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon(getClass().getResource("/icones/clear.png")));
		tabDadosPessoais.add(btnNovo, "flowx,cell 0 7 6 1,alignx center");
		
		btnAlunoInserir.setToolTipText("Salvar");
		btnAlunoInserir.setIcon(new ImageIcon(getClass().getResource("/icones/save.png")));
		tabDadosPessoais.add(btnAlunoInserir, "cell 0 7 6 1,alignx center");
		
		btnAlunoConsulta = new JButton("");
		btnAlunoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão alunoConsultar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoConsultar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
				// FIM 
			}
		});
		btnAlunoConsulta.setToolTipText("Consultar");
		btnAlunoConsulta.setIcon(new ImageIcon(getClass().getResource("/icones/lookup.png")));
		tabDadosPessoais.add(btnAlunoConsulta, "cell 0 7 6 1,alignx center");
		
		btnAlunoAlterar = new JButton("");
		btnAlunoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão aluno alterar
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoAlterar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		btnAlunoAlterar.setToolTipText("Editar");
		btnAlunoAlterar.setIcon(new ImageIcon(getClass().getResource("/icones/edit.png")));
		tabDadosPessoais.add(btnAlunoAlterar, "cell 0 7 6 1,alignx center");
		
		btnAlunoExcluir = new JButton("");
		btnAlunoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão excluir
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						alunoExcluir();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
				// FIM
			}
		});
		btnAlunoExcluir.setToolTipText("Apagar");
		btnAlunoExcluir.setIcon(new ImageIcon(getClass().getResource("/icones/delete.png")));
		tabDadosPessoais.add(btnAlunoExcluir, "cell 0 7 6 1,alignx center");
		
		tabCurso = new JPanel();
		tabbedPane.addTab("Dados do Curso", null, tabCurso, "Dados do curso do aluno.");
		tabbedPane.setEnabledAt(1, false);
		tabCurso.setLayout(new MigLayout("", "[][10][grow][180:180:180,grow][100px:100px:100px,grow][25]", "[][25][][25][][25][]"));
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblCurso, "cell 0 0,alignx right");
		
		cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Análise e Desenvolvimento de Sistemas", "Ciência da Computação", "Medicina"}));
		cmbCurso.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(cmbCurso, "cell 2 0 3 1,growx");
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblCampus, "cell 0 2,alignx right");
		
		cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Tatuapé", "Pinheiros"}));
		cmbCampus.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXX");
		cmbCampus.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(cmbCampus, "flowx,cell 2 2 2 1,alignx left");
		
		lblSemestre = new JLabel("Semestre ");
		lblSemestre.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblSemestre, "cell 3 2 2 1,alignx trailing");
		
		lblOnicoCurso_1 = new JLabel("O único curso em 2019-02 é MEDICINA");
		lblOnicoCurso_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		tabCurso.add(lblOnicoCurso_1, "cell 3 3 3 1,alignx center,aligny top");
		
		lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblPeriodo, "cell 0 4,alignx right");
		
		rdMatutino = new JRadioButton("Matutino");
		rdGrpPeriodo.add(rdMatutino);
		rdMatutino.setActionCommand("M");
		rdMatutino.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(rdMatutino, "flowx,cell 2 4 4 1,growx");
		
		btnCursoInserir = new JButton("");
		btnCursoInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Botão inserir curso
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						cursoInserir();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();				
				// FIM BOTÃO INSERIR CURSO
			}
		});
		
		btnCursoNovo = new JButton("");
		btnCursoNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botaoNovo();
			}
		});
		btnCursoNovo.setToolTipText("Novo");
		btnCursoNovo.setIcon(new ImageIcon(getClass().getResource("/icones/clear.png")));
		tabCurso.add(btnCursoNovo, "flowx,cell 0 6 6 1,alignx center");
		
		
		btnCursoInserir.setIcon(new ImageIcon(getClass().getResource("/icones/save.png")));
		btnCursoInserir.setToolTipText("Salvar");
		tabCurso.add(btnCursoInserir, "cell 0 6 6 1,alignx center");
		
		btnCursoConsulta = new JButton("");
		btnCursoConsulta.setToolTipText("Consultar");
		btnCursoConsulta.setIcon(new ImageIcon(getClass().getResource("/icones/lookup.png")));
		btnCursoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// BOTÃO CURSO CONSULTAR
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						cursoConsultar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
				// FIM
			}
		});
		tabCurso.add(btnCursoConsulta, "cell 0 6 6 1,alignx center");
		
		btnCursoAlterar = new JButton("");
		btnCursoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTÃO CURSO ALTERAR
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						cursoAlterar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
				// FIM 
			}
		});
		btnCursoAlterar.setIcon(new ImageIcon(getClass().getResource("/icones/edit.png")));
		btnCursoAlterar.setToolTipText("Editar");
		tabCurso.add(btnCursoAlterar, "cell 0 6 6 1,alignx center");
		
		btnCursoExcluir = new JButton("");
		btnCursoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTÃO CURSO EXCLUIR
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						cursoExcluir();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		btnCursoExcluir.setIcon(new ImageIcon(getClass().getResource("/icones/delete.png")));
		btnCursoExcluir.setToolTipText("Apagar");
		tabCurso.add(btnCursoExcluir, "cell 0 6 6 1,alignx center");
		
		rdVespertino = new JRadioButton("Vespertino");
		rdVespertino.setActionCommand("V");
		rdGrpPeriodo.add(rdVespertino);
		rdVespertino.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(rdVespertino, "cell 2 4 4 1,growx");
		
		rdNoturno = new JRadioButton("Noturno");
		rdNoturno.setSelected(true);
		rdNoturno.setActionCommand("N");
		rdGrpPeriodo.add(rdNoturno);
		rdNoturno.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(rdNoturno, "cell 2 4 4 1,growx");
		
		cmbCursoSemestre = new JComboBox();
		cmbCursoSemestre.setModel(new DefaultComboBoxModel(new String[] {"2020-01", "2019-02"}));
		cmbCursoSemestre.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(cmbCursoSemestre, "cell 3 2,alignx center");
		
		tabNotasFaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, tabNotasFaltas, "Notas e faltas do aluno.");
		tabNotasFaltas.setLayout(new MigLayout("", "[50:50:50,grow][70:70:70][25:25:25][80:80:80,grow][100px:100px:100px,grow][100:100:100,grow][60:60:60,grow][48:48:48,grow][80:80:80]", "[][][][][25][]"));
		
		lblNotasRGM = new JLabel("RGM:");
		lblNotasRGM.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasRGM, "cell 0 0,alignx trailing");
		
		txtNotasRGM = new JFormattedTextField(new MaskFormatter("########"));
		txtNotasRGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Notas RGM ENTER
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						NotasFaltasRgm();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		txtNotasRGM.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasRGM.setColumns(10);
		tabNotasFaltas.add(txtNotasRGM, "cell 1 0 3 1,growx");
		
		txtNotasNome = new JTextField();
		txtNotasNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// Notas RGM Click
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						NotasFaltasRgm();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		txtNotasNome.setText("Pressione ENTER ou clique aqui");
		txtNotasNome.setEditable(false);
		txtNotasNome.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasNome.setColumns(10);
		tabNotasFaltas.add(txtNotasNome, "cell 4 0 5 1,growx");
		
		txtNotasCurso = new JTextField();
		txtNotasCurso.setEditable(false);
		txtNotasCurso.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasCurso.setColumns(10);
		tabNotasFaltas.add(txtNotasCurso, "cell 0 1 9 1,growx");
		
		lblNotasDisciplina = new JLabel("Disciplina:");
		lblNotasDisciplina.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasDisciplina, "flowx,cell 0 2 5 1,alignx trailing");
		
		cmbNotasDisciplina = new JComboBox();
		cmbNotasDisciplina.setEnabled(false);
		cmbNotasDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Preencha o RGM"}));
		cmbNotasDisciplina.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXX");
		cmbNotasDisciplina.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabNotasFaltas.add(cmbNotasDisciplina, "cell 0 2 5 1,growx");
		
		lblNotasSemestre = new JLabel("Semestre:");
		lblNotasSemestre.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasSemestre, "cell 5 2,alignx trailing");
		
		cmbNotasSemestre = new JComboBox();
		cmbNotasSemestre.setModel(new DefaultComboBoxModel(new String[] {"2020-01", "2019-02"}));
		cmbNotasSemestre.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabNotasFaltas.add(cmbNotasSemestre, "cell 6 2,growx");
		
		lblNotasNota = new JLabel("Nota:");
		lblNotasNota.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasNota, "cell 0 3,alignx trailing");
		
		cmbNotasNota = new JComboBox();
		cmbNotasNota.setModel(new DefaultComboBoxModel(new String[] {"0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5", "4,0", "4,5", "5,0",
																	"5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10,0"}));
		cmbNotasNota.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabNotasFaltas.add(cmbNotasNota, "cell 1 3,growx");
		
		lblNotasFaltas = new JLabel("Faltas:");
		lblNotasFaltas.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasFaltas, "cell 3 3,alignx trailing");
		
		txtNotasFaltas = new JSpinner();
		txtNotasFaltas.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		txtNotasFaltas.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabNotasFaltas.add(txtNotasFaltas, "cell 4 3,growx");
		
		lblOnicoCurso = new JLabel("O único curso em 2019-02 é MEDICINA");
		lblOnicoCurso.setFont(new Font("Verdana", Font.PLAIN, 12));
		tabNotasFaltas.add(lblOnicoCurso, "cell 5 3 4 1,alignx center,aligny top");
		
		btnNotasInserir = new JButton("");
		btnNotasInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// NOTAS SALVAR
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasSalvar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		
		btnNotasNovo = new JButton("");
		btnNotasNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoNovo();
			}
		});
		btnNotasNovo.setToolTipText("Novo");
		btnNotasNovo.setIcon(new ImageIcon(getClass().getResource("/icones/clear.png")));
		tabNotasFaltas.add(btnNotasNovo, "flowx,cell 0 5 9 1,alignx center");
		
		btnNotasInserir.setIcon(new ImageIcon(getClass().getResource("/icones/save.png")));
		btnNotasInserir.setToolTipText("Salvar");
		tabNotasFaltas.add(btnNotasInserir, "cell 0 5 9 1,alignx center");
		
		btnNotasConsulta = new JButton("");
		btnNotasConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasConsultar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		btnNotasConsulta.setIcon(new ImageIcon(getClass().getResource("/icones/lookup.png")));
		btnNotasConsulta.setToolTipText("Consultar");
		tabNotasFaltas.add(btnNotasConsulta, "cell 0 5 9 1");
		
		btnNotasAlterar = new JButton("");
		btnNotasAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasAlterar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		btnNotasAlterar.setIcon(new ImageIcon(getClass().getResource("/icones/edit.png")));
		btnNotasAlterar.setToolTipText("Alterar");
		tabNotasFaltas.add(btnNotasAlterar, "cell 0 5 9 1");
		
		btnNotasExcluir = new JButton("");
		btnNotasExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						notasExcluir();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		btnNotasExcluir.setIcon(new ImageIcon(getClass().getResource("/icones/delete.png")));
		btnNotasExcluir.setToolTipText("Excluir");
		tabNotasFaltas.add(btnNotasExcluir, "cell 0 5 9 1");
		
		tabBoletim = new JPanel();
		tabbedPane.addTab("Boletim", null, tabBoletim, "Boletim do aluno.");
		tabBoletim.setLayout(null);
		
		lblBoletimRGM = new JLabel("RGM:");
		lblBoletimRGM.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBoletimRGM.setBounds(10, 11, 64, 23);
		tabBoletim.add(lblBoletimRGM);
		
		lblBoletimSemestre = new JLabel("Semestre:");
		lblBoletimSemestre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBoletimSemestre.setBounds(191, 11, 104, 23);
		tabBoletim.add(lblBoletimSemestre);
		
		txtBoletimRGM = new JFormattedTextField((new MaskFormatter("########")));
		txtBoletimRGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						boletimListar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		txtBoletimRGM.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtBoletimRGM.setColumns(8);
		txtBoletimRGM.setBounds(61, 8, 120, 31);
		tabBoletim.add(txtBoletimRGM);
		
		cmbBoletimSemestre = new JComboBox();
		cmbBoletimSemestre.setFont(new Font("Monospaced", Font.PLAIN, 18));
		cmbBoletimSemestre.setModel(new DefaultComboBoxModel(new String[] {"2020-01", "2019-02"}));
		cmbBoletimSemestre.setBounds(293, 10, 129, 26);
		tabBoletim.add(cmbBoletimSemestre);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudarStatus("Executando...");
				enableDisable(contentPane, false);
				enableDisable(menuBar, false);
				new SwingWorker<Void, Void>() { // Criando uma nova thread para o programa ficar responsivo.
					protected Void doInBackground() throws Exception {
						boletimListar();
						enableDisable(contentPane, true);
						enableDisable(menuBar, true);
						return null;
					}
				}.execute();
			}
		});
		btnNewButton.setBounds(540, 8, 109, 28);
		tabBoletim.add(btnNewButton);
		DefaultTableModel tModel = new DefaultTableModel();
		Object[] colunas = new Object[] {"RGM", "Nome do Aluno", "Disciplina", "Notas", "Faltas", "Periodo", "Curso", "Semestre"};
		tModel.setColumnIdentifiers(colunas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 639, 249);
		tabBoletim.add(scrollPane);
		
		tbBoletim = new JTable();
		scrollPane.setViewportView(tbBoletim);
		tbBoletim.setEnabled(false);
		tbBoletim.setModel(tModel);
		tbBoletim.setAutoCreateRowSorter(true);
		
		setTamanhoColunasBoletim();

		txtStatus = new JTextField();
		txtStatus.setToolTipText("Mensagens do sistema aparecem aqui.");
		txtStatus.setEditable(false);
		txtStatus.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtStatus.setBounds(10, 348, 664, 25);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		txtStatus.setText("Mensagens do sistema aparecem aqui.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/***************************************** FUNÇÕES GERAIS ********************************************/
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mudarStatus(String status) {
		txtStatus.setText(status);
	}
	
	private void botaoNovo() {
		main(null);
		this.dispose();
	}
	
	private void menuTrocarBanco() {
		if (mnLocal.isSelected()) {
			Globals.banco = 0;
		} else if (mnRemoto.isSelected()) {
			Globals.banco = 1;
		}
	}
	
	// POLIMORFISMO RECURSIVO QUE DEIXA TUDO DISABLED / ENABLED - Não precisava fazer assim mas ficou legal
	
	private void enableDisable(JPanel painel, boolean isEnabled) {
		Component[] elementos = painel.getComponents();
		painel.getRootPane().setEnabled(isEnabled);
		for (Component el : elementos) {
			if (el instanceof JPanel) {
				enableDisable((JPanel) el, isEnabled);
			} else if (el instanceof JTabbedPane) {
				enableDisable((JTabbedPane) el, isEnabled);
			}
			el.setEnabled(isEnabled);
		}
	}
	
	private void enableDisable(JMenuBar menu, boolean isEnabled) {
		Component[] elementos = menu.getComponents();
		
		for (Component el : elementos) {
			if (el instanceof JMenuBar) {
				enableDisable((JMenuBar) el, isEnabled);
			}
			el.setEnabled(isEnabled);
		}
	}
	
	private void enableDisable(JTabbedPane aba, boolean isEnabled) {
		Component[] elementos = aba.getComponents();
		
		for (Component el : elementos) {
			if (el instanceof JTabbedPane) {
				enableDisable((JTabbedPane) el, isEnabled);
			} else if (el instanceof JPanel) {
				enableDisable((JPanel) el, isEnabled);
			}
			el.setEnabled(isEnabled);
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/******************************************* ABA ALUNO ***********************************************/
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void alunoSalvar() {
		// Usado no botão e no menu Aluno > Salvar
		
		// Testar se tem algum erro nos dados
		for (boolean b : erroDados) {
			if (b) {
				mudarStatus("Erro nos dados: Campos em branco ou inválidos.");
				return; 
			}
		}
		
		// Inserir
		try {
			Aluno aluno = new Aluno();
			AlunoDAO dao = new AlunoDAO();

			aluno.setRgm(txtRgm.getText());
			aluno.setNome(txtNome.getText());
			aluno.setNascimento(txtNasc.getText());
			aluno.setCpf(txtCpf.getText());
			aluno.setEmail(txtEmail.getText());
			aluno.setEndereco(txtEndereco.getText());
			aluno.setMunicipio(txtMunicipio.getText().trim());
			aluno.setUf((String)cmbEstado.getSelectedItem());
			aluno.setCelular(txtCelular.getText());
			
			dao.salvar(aluno);
			
			mudarStatus("Salvo com sucesso");
			
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao salvar: " + e.getMessage());
				mudarStatus("Erro ao salvar: " + e.getMessage());
			}
	}
	
	private void alunoConsultar() {
		// Testar se tem algum erro no campo RGM
		if (erroDados[0] == true) {
			mudarStatus("Erro nos dados: Campos em branco ou inválidos.");
			return; 
		}
		
		// Consultar
		try {
			Aluno aluno = new AlunoDAO().consultar(txtRgm.getText());
			
			txtNome.setText(aluno.getNome());
			txtNasc.setText(aluno.getNascimento());
			txtCpf.setText(aluno.getCpf());
			txtEmail.setText(aluno.getEmail());
			txtEndereco.setText(aluno.getEndereco());
			txtMunicipio.setText(aluno.getMunicipio());
			cmbEstado.setSelectedItem(aluno.getUf());
			txtCelular.setText(aluno.getCelular());
			
			mudarStatus("Consulta realizada com sucesso");
			erroDados = new boolean[] {false, false, false, false, false, false, false, false}; 
			
		} catch (Exception e) {
			mudarStatus("Erro ao consultar: " + e.getMessage());
			System.out.println("Erro ao consultar: " + e.getMessage());
		} 
	}
	
	private void alunoAlterar() {
		// Testar erro nos campos
		for (boolean b : erroDados) {
			if (b) {
				mudarStatus("Erro nos dados: Campos em branco ou inválidos.");
				return; 
			}
		}
		
		// Alterar
		try {
			Aluno aluno = new Aluno();
			AlunoDAO dao = new AlunoDAO();
			
			aluno.setRgm(txtRgm.getText());
			aluno.setNome(txtNome.getText());
			aluno.setNascimento(txtNasc.getText());
			aluno.setCpf(txtCpf.getText());
			aluno.setEmail(txtEmail.getText());
			aluno.setEndereco(txtEndereco.getText());
			aluno.setMunicipio(txtMunicipio.getText().trim());
			aluno.setUf((String)cmbEstado.getSelectedItem());
			aluno.setCelular(txtCelular.getText());
			
			dao.alterar(aluno);
			
			mudarStatus("Alterado com sucesso");
			
		} catch (Exception e) {
			mudarStatus("Erro ao alterar: " + e.getMessage());
			System.out.println("Erro ao alterar: " + e.getMessage());
		}
	}
	
	private void alunoExcluir() {
		try {
			AlunoDAO dao = new AlunoDAO();
			dao.excluir(txtRgm.getText());
			mudarStatus("Excluído RGM " + txtRgm.getText() + " com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao apagar: " + e.getMessage());
			System.out.println("Erro ao excluir: " + e.getMessage());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/******************************************** ABA CURSO **********************************************/
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	private void cursoInserir() {
		try {
			Aluno aluno = new Aluno();
			Curso curso = new Curso();
			Turma turma = new Turma();
			
			AlunoEmTurmaDAO dao = new AlunoEmTurmaDAO();
			
			aluno.setRgm(txtRgm.getText());
			
			curso.setNome((String)cmbCurso.getSelectedItem());
			curso.setCampus((String)cmbCampus.getSelectedItem());
			turma.setPeriodo(rdGrpPeriodo.getSelection().getActionCommand());
			turma.setSemestre((String)cmbCursoSemestre.getSelectedItem());
			
			turma.setCurso(curso);
			
			AlunoEmTurma alunoTurma = new AlunoEmTurma(aluno, turma);
			
			dao.salvar(alunoTurma);
			
			mudarStatus("Curso salvo com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao salvar curso: "+ e.getMessage());
		}	
	}
	
	private void cursoConsultar() {
		try {

			AlunoEmTurma alunoTurma = new AlunoEmTurmaDAO().consultar(txtRgm.getText());
			
			cmbCurso.setSelectedItem(alunoTurma.getTurma().getCurso().getNome());
			cmbCampus.setSelectedItem(alunoTurma.getTurma().getCurso().getCampus());
			cmbCursoSemestre.setSelectedItem(alunoTurma.getTurma().getSemestre());
			rdGrpPeriodo.clearSelection();
			
			switch (alunoTurma.getTurma().getPeriodo()) {
			case "M":
				rdMatutino.setSelected(true);
				break;	
			case "V":
				rdVespertino.setSelected(true);
				break;
			case "N":
				rdNoturno.setSelected(true);
				break;
			}
			
			mudarStatus("Consulta de curso realizada.");
		} catch (Exception e) {
			mudarStatus("Erro na consulta: " + e.getMessage());
		}
	}
	
	private void cursoAlterar() {
		try {
			Aluno aluno = new Aluno();
			Curso curso = new Curso();
			Turma turma = new Turma();

			
			AlunoEmTurmaDAO dao = new AlunoEmTurmaDAO();

			aluno.setRgm(txtRgm.getText());

			curso.setNome((String) cmbCurso.getSelectedItem());
			curso.setCampus((String) cmbCampus.getSelectedItem());
			turma.setPeriodo(rdGrpPeriodo.getSelection().getActionCommand());
			turma.setSemestre((String)cmbCursoSemestre.getSelectedItem());

			turma.setCurso(curso);
			
			AlunoEmTurma alunoTurma = new AlunoEmTurma(aluno, turma);

			dao.alterar(alunoTurma);
			
			mudarStatus("Alteração realizada com sucesso.");
		} catch (Exception e) {
			mudarStatus("Erro na alteração: " + e.getMessage());
		}
	}
	
	private void cursoExcluir() {
		try {
			AlunoEmTurmaDAO dao = new AlunoEmTurmaDAO();		
			
			dao.excluir(txtRgm.getText());
			
			mudarStatus("Informações da turma de: RGM " + txtRgm.getText() + " excluidas com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao excluir: " + e.getMessage());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/***************************************** ABA NOTAS FALTAS ******************************************/
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void NotasFaltasRgm() {
		try {
			AlunoEmTurmaDAO dao = new AlunoEmTurmaDAO();
			
			AlunoEmTurma alunoTurma = dao.consultar(txtNotasRGM.getText());
			
			// Settar o texto nos campos de consulta
			txtNotasNome.setText(alunoTurma.getAluno().getNome());
			Curso curso = alunoTurma.getTurma().getCurso();
			String descricao = curso.getNome() + " - " + alunoTurma.getTurma().getPeriodo() + " / " + curso.getCampus();
			txtNotasCurso.setText(descricao);
			
			// Habilitar lista
			cmbNotasDisciplina.setEnabled(true);
			
			// Apagar mensagem de RGM
			cmbNotasDisciplina.setModel(new DefaultComboBoxModel(new String[] {}));
			
			// Consultar lista de disciplinas
			DisciplinaEmCursoDAO dao1 = new DisciplinaEmCursoDAO();
			List<Disciplina> disciplinas = dao1.consultarDisciplinas(curso.getId());
			
			// Colocar a lista dentro do combobox
			for (Disciplina disciplina : disciplinas) {
				cmbNotasDisciplina.addItem(disciplina.getNome()  + " - " + disciplina.getId() + " / " + curso.getId());
			}
			mudarStatus("Dados do aluno buscados com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao trazer dados do aluno: " + e.getMessage());
		}
	}
	
	private void notasSalvar() {
		NotasFaltas nf = new NotasFaltas();	
		
		int disciplinaId;
		int cursoId;
		
		// Puxar ids da string
		try {
			String[] nomeDisc = cmbNotasDisciplina.getSelectedItem().toString().split(" - ");
			String[] dcId = nomeDisc[1].split(" / ");
			cursoId = Integer.parseInt(dcId[0]);
			disciplinaId = Integer.parseInt(dcId[1]);
		} catch (Exception e) {
			mudarStatus("Disciplina inválida");
			return;
		}
		
		Aluno a = new Aluno();		
		a.setRgm(txtNotasRGM.getText());
		nf.setAluno(a);
		
		Curso c = new Curso();
		c.setId(cursoId);
		nf.setCurso(c);
		
		Disciplina d = new Disciplina();
		d.setId(disciplinaId);
		nf.setDisciplina(d);
		
		// Tratamento de número com virgula
		nf.setFaltas((int)txtNotasFaltas.getValue());
		nf.setNota(Double.parseDouble(cmbNotasNota.getSelectedItem().toString().replace(",", ".")));
	
		try {
			NotasFaltasDAO dao = new NotasFaltasDAO();
			dao.salvar(nf);
			mudarStatus("Notas/Faltas adicionadas com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao salvar: " + e.getMessage());
		}
	}
	
	private void notasConsultar() {		
		NotasFaltas nf;
		int disciplinaId;
		int cursoId;
		
		// Puxar ids
		try {
			String[] nomeDisc = cmbNotasDisciplina.getSelectedItem().toString().split(" - ");
			String[] dcId = nomeDisc[1].split(" / ");
			cursoId = Integer.parseInt(dcId[0]);
			disciplinaId = Integer.parseInt(dcId[1]);
		} catch (Exception e) {
			mudarStatus("Disciplina inválida");
			return;
		}
		
		// Conectar
		try {
			nf = new NotasFaltasDAO().consultar(txtNotasRGM.getText(), disciplinaId, cursoId);
			txtNotasFaltas.setValue((nf.getFaltas()));
			cmbNotasNota.setSelectedItem(String.valueOf(nf.getNota()).replace(".", ","));
			mudarStatus("Notas/Faltas buscada com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao consultar: " + e.getMessage());
		}
	}
	
	private void notasAlterar() {
		NotasFaltas nf = new NotasFaltas();
		int disciplinaId;
		int cursoId;
				
		Aluno a = new Aluno();
		a.setRgm(txtNotasRGM.getText());
		nf.setAluno(a);

		// Puxar ids da string
		try {
			String[] nomeDisc = cmbNotasDisciplina.getSelectedItem().toString().split(" - ");
			String[] dcId = nomeDisc[1].split(" / ");
			cursoId = Integer.parseInt(dcId[0]);
			disciplinaId = Integer.parseInt(dcId[1]);
		} catch (Exception e) {
			mudarStatus("Disciplina inválida");
			return;
		}
		
		Disciplina d = new Disciplina();
		d.setId(disciplinaId);
		nf.setDisciplina(d);
		
		Curso c = new Curso();
		c.setId(cursoId);
		nf.setCurso(c);
		
		nf.setFaltas((int)txtNotasFaltas.getValue());
		nf.setNota(Double.parseDouble(cmbNotasNota.getSelectedItem().toString().replace(",", ".")));
		
		try {
			NotasFaltasDAO dao = new NotasFaltasDAO();
			dao.alterar(nf);
			mudarStatus("Notas/Faltas alteradas com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao alterar: " + e.getMessage());
		}
	}
	
	private void notasExcluir() {
		NotasFaltas nf = new NotasFaltas();
		int disciplinaId;
		int cursoId;
		
		// Puxar ids da string -- devia ter feito uma função
		try {
			String[] nomeDisc = cmbNotasDisciplina.getSelectedItem().toString().split(" - ");
			String[] dcId = nomeDisc[1].split(" / ");
			cursoId = Integer.parseInt(dcId[0]);
			disciplinaId = Integer.parseInt(dcId[1]);
		} catch (Exception e) {
			mudarStatus("Disciplina inválida");
			return;
		}
		
		Aluno a = new Aluno();
		a.setRgm(txtNotasRGM.getText());
		nf.setAluno(a);
		
		Disciplina d = new Disciplina();
		d.setId(disciplinaId);
		nf.setDisciplina(d);
		
		Curso c = new Curso();
		c.setId(cursoId);
		nf.setCurso(c);
		
		try {
			NotasFaltasDAO dao = new NotasFaltasDAO();
			dao.excluir(nf);
			mudarStatus("Notas/Faltas alteradas com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao excluir: " + e.getMessage());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/******************************************** ABA BOLETIM ********************************************/
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void boletimListar() {
		try {
			BoletimDAO dao = new BoletimDAO();
			List<Boletim> bolList = dao.listar(txtBoletimRGM.getText(), cmbBoletimSemestre.getSelectedItem().toString());
			
			DefaultTableModel rModel = new DefaultTableModel();
			Object[] colunas = new Object[] {"RGM", "Nome do Aluno", "Disciplina", "Notas", "Faltas", "Periodo", "Curso", "Semestre"};
			rModel.setColumnIdentifiers(colunas);
			
			for (Boletim b : bolList) {
				//{"RGM", "Nome do Aluno", "Disciplina", "Notas", "Faltas", "Periodo", "Curso", "Semestre"}
				String[] linha = new String[8];
				linha[0] = b.getRgm();
				linha[1] = b.getNome();
				linha[2] = b.getDisciplina();
				linha[3] = Double.toString(b.getNota());
				linha[4] = Integer.toString(b.getFaltas());

				if (b.getPeriodo().contains("M")) {
					linha[5] = "Matutino";
				} else if (b.getPeriodo().contains("N")) {
					linha[5] = "Noturno";
				} else {
					linha[5] = "Vespertino";
				}

				linha[6] = b.getCurso();
				linha[7] = b.getSemestre();
				
				rModel.addRow(linha);
			}

			tbBoletim.setModel(rModel);
			setTamanhoColunasBoletim();
			mudarStatus("Boletim criado com sucesso");
		} catch (Exception e) {
			mudarStatus("Erro ao listar: " + e.getMessage());
		}
	}
	
	private void setTamanhoColunasBoletim() {
		tbBoletim.getColumnModel().getColumn(1).setPreferredWidth(162);
		tbBoletim.getColumnModel().getColumn(3).setPreferredWidth(41);
		tbBoletim.getColumnModel().getColumn(4).setPreferredWidth(41);
		tbBoletim.getColumnModel().getColumn(5).setPreferredWidth(48);
		tbBoletim.getColumnModel().getColumn(6).setPreferredWidth(104);
	}
}
