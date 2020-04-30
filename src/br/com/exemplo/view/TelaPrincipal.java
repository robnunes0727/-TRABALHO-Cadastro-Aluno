package br.com.exemplo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.AlunoDAO;
import br.com.exemplo.model.Aluno;
import net.miginfocom.swing.MigLayout;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

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
	private JTextField txtEnd;
	private JLabel lblMunicipio;
	private JTextField txtMunicipio;
	private JLabel lblEstado;
	private JComboBox cmbEstado;
	private JLabel lblCel;
	private JFormattedTextField txtCel;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JComboBox cmbCurso;
	private JComboBox cmbCampus;
	private JRadioButton rdMatutino;
	private JRadioButton rdVespertino;
	private JRadioButton rdNoturno;
	private final ButtonGroup rdGrpPeriodo = new ButtonGroup();
	private JButton btnConsulta;
	private JButton btnAlterar;
	private JButton btnInserir;
	private JButton btnExcluir;
	private JTextPane txtBoletim1;
	private JTextPane txtBoletim2;
	private JLabel lblBoletimRGM;
	private JLabel lblBoletimSemestre;
	private JLabel lblBoletimAno;
	private JFormattedTextField txtBoletimRGM;
	private JFormattedTextField txtBoletimAno;
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
	private JFormattedTextField txtNotasAno;
	private JLabel lblNotasAno;
	private JFormattedTextField txtNotasFaltas;
	private JButton btnNewButton;
	private JButton btnNotasInserir;
	private JButton btnNotasConsulta;
	private JButton btnNotasAlterar;
	private JButton btnNotasExcluir;

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
				// Ação ALUNO > Salvar
				try {
				Aluno aluno = new Aluno();
				AlunoDAO dao = new AlunoDAO();

				aluno.setRgm(txtRgm.getText());
				aluno.setNome(txtNome.getText());
				aluno.setNascimento(txtNasc.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setEndereco(txtEnd.getText());
				aluno.setMunicipio(txtMunicipio.getText());
				aluno.setUf((String)cmbEstado.getSelectedItem());
				aluno.setCelular(txtCel.getText());
				
				dao.salvar(aluno);
				
				mudarStatus("Salvo com sucesso");
				
				} catch(Exception e) {
					System.out.println("Erro ao salvar: " + e.getMessage());
				}
				// Fim ALUNO > Salvar
			}
		});
		mnAlSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnAluno.add(mnAlSalvar);
		
		mnAlAlterar = new JMenuItem("Alterar");
		mnAluno.add(mnAlAlterar);
		
		mnAlConsultar = new JMenuItem("Consultar");
		mnAluno.add(mnAlConsultar);
		
		mnAlExcluir = new JMenuItem("Excluir");
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
		mnNotasFaltas.add(mnNtSalvar);
		
		mnNtAlterar = new JMenuItem("Alterar");
		mnNtAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNotasFaltas.add(mnNtAlterar);
		
		mnNtExcluir = new JMenuItem("Excluir");
		mnNotasFaltas.add(mnNtExcluir);
		
		mnNtConsultar = new JMenuItem("Consultar");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 664, 333);
		contentPane.add(tabbedPane);
		
		tabDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, tabDadosPessoais, "Dados pessoais do aluno.");
		tabDadosPessoais.setLayout(new MigLayout("", "[][120px:120px:120px,grow][][][170:170:170,grow][grow]", "[][][][][][]"));
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblRgm, "cell 0 0,alignx right");
		
		txtRgm = new JFormattedTextField(new MaskFormatter("########"));;
		txtRgm.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabDadosPessoais.add(txtRgm, "cell 1 0,growx");
		txtRgm.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblNome, "cell 3 0,alignx trailing");
		
		txtNome = new JTextField();
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
				
				if(txtNasc.getText().matches(padraoData)){
					txtNasc.setBackground(Color.GREEN);
					mudarStatus("");
				}
				else {
					txtNasc.setBackground(Color.RED);
					mudarStatus("Data inválida.");
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
		txtCpf.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabDadosPessoais.add(txtCpf, "cell 4 1,growx");
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblEmail, "cell 0 2,alignx right");
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		tabDadosPessoais.add(txtEmail, "cell 1 2 5 1,growx");
		
		lblEnd = new JLabel("Endereço");
		lblEnd.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblEnd, "cell 0 3,alignx right");
		
		txtEnd = new JTextField();
		txtEnd.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtEnd.setColumns(10);
		tabDadosPessoais.add(txtEnd, "cell 1 3 5 1,growx");
		
		lblMunicipio = new JLabel("Município");
		lblMunicipio.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabDadosPessoais.add(lblMunicipio, "cell 0 4,alignx right");
		
		txtMunicipio = new JTextField();
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
		
		txtCel = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtCel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtCel.setColumns(10);
		tabDadosPessoais.add(txtCel, "cell 4 5,growx");
		
		tabCurso = new JPanel();
		tabbedPane.addTab("Dados do Curso", null, tabCurso, "Dados do curso do aluno.");
		tabCurso.setLayout(new MigLayout("", "[][10][grow][grow][grow][25]", "[][25][][25][][25][]"));
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblCurso, "cell 0 0,alignx right");
		
		cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Análise e Desenvolvimento de Sistema", "Ciência da Computação", "Farmácia", "Medicina"})); // ** Talvez fazer puxar da db? Hardcoded por enquanto.
		cmbCurso.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(cmbCurso, "cell 2 0 3 1,growx");
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblCampus, "cell 0 2,alignx right");
		
		cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Tatuapé", "Pinheiros"}));
		cmbCampus.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(cmbCampus, "cell 2 2 3 1,growx");
		
		lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabCurso.add(lblPeriodo, "cell 0 4,alignx right");
		
		rdMatutino = new JRadioButton("Matutino");
		rdGrpPeriodo.add(rdMatutino);
		rdMatutino.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(rdMatutino, "flowx,cell 2 4,alignx left");
		
		rdVespertino = new JRadioButton("Vespertino");
		rdGrpPeriodo.add(rdVespertino);
		rdVespertino.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(rdVespertino, "cell 3 4,alignx left");
		
		rdNoturno = new JRadioButton("Noturno");
		rdGrpPeriodo.add(rdNoturno);
		rdNoturno.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabCurso.add(rdNoturno, "cell 4 4");
		
		btnInserir = new JButton("");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserir.setIcon(new ImageIcon("imagens\\icones\\save.png"));
		btnInserir.setToolTipText("Salvar");
		tabCurso.add(btnInserir, "flowx,cell 0 6 6 1,alignx center");
		
		btnConsulta = new JButton("");
		btnConsulta.setToolTipText("Consultar");
		btnConsulta.setIcon(new ImageIcon("imagens\\icones\\lookup.png"));
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tabCurso.add(btnConsulta, "cell 0 6 6 1,alignx center");
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterar.setIcon(new ImageIcon("imagens\\icones\\edit.png"));
		btnAlterar.setToolTipText("Editar");
		tabCurso.add(btnAlterar, "cell 0 6 6 1,alignx center");
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setIcon(new ImageIcon("imagens\\icones\\delete.png"));
		btnExcluir.setToolTipText("Apagar");
		tabCurso.add(btnExcluir, "cell 0 6 6 1,alignx center");
		
		tabNotasFaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, tabNotasFaltas, "Notas e faltas do aluno.");
		tabNotasFaltas.setLayout(new MigLayout("", "[50:50:50,grow][70:70:70][][80:80:80,grow][100px:100px:100px,grow][70:70:70,grow][grow][grow][]", "[][][][][25][]"));
		
		lblNotasRGM = new JLabel("RGM:");
		lblNotasRGM.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasRGM, "cell 0 0,alignx trailing");
		
		txtNotasRGM = new JFormattedTextField(new MaskFormatter("##########"));
		txtNotasRGM.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasRGM.setColumns(10);
		tabNotasFaltas.add(txtNotasRGM, "cell 1 0 3 1,growx");
		
		txtNotasNome = new JTextField();
		txtNotasNome.setEditable(false);
		txtNotasNome.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasNome.setColumns(10);
		tabNotasFaltas.add(txtNotasNome, "cell 4 0 5 1,growx");
		
		txtNotasCurso = new JTextField();
		txtNotasCurso.setEditable(false);
		txtNotasCurso.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasCurso.setColumns(10);
		tabNotasFaltas.add(txtNotasCurso, "cell 0 1 9 1,growx");
		
		lblNotasSemestre = new JLabel("Semestre:");
		lblNotasSemestre.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasSemestre, "flowx,cell 0 2 3 1,alignx trailing");
		
		lblNotasAno = new JLabel("Ano:");
		lblNotasAno.setFont(new Font("Verdana", Font.PLAIN, 18));
		tabNotasFaltas.add(lblNotasAno, "cell 3 2,alignx trailing");
		
		cmbNotasSemestre = new JComboBox();
		cmbNotasSemestre.setModel(new DefaultComboBoxModel(new String[] {"1º", "2º", "3º", "4º"}));
		cmbNotasSemestre.setFont(new Font("Monospaced", Font.PLAIN, 18));
		tabNotasFaltas.add(cmbNotasSemestre, "cell 0 2 3 1,growx");
		
		txtNotasAno = new JFormattedTextField(new MaskFormatter("####"));
		txtNotasAno.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasAno.setColumns(10);
		tabNotasFaltas.add(txtNotasAno, "cell 4 2,growx");
		
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
		
		txtNotasFaltas = new JFormattedTextField(new MaskFormatter("##"));
		txtNotasFaltas.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtNotasFaltas.setColumns(10);
		tabNotasFaltas.add(txtNotasFaltas, "cell 4 3,growx");
		
		btnNotasInserir = new JButton("");
		btnNotasInserir.setIcon(new ImageIcon("imagens\\icones\\save.png"));
		btnNotasInserir.setToolTipText("Salvar");
		tabNotasFaltas.add(btnNotasInserir, "flowx,cell 0 5 9 1,alignx center");
		
		btnNotasConsulta = new JButton("");
		btnNotasConsulta.setIcon(new ImageIcon("imagens\\icones\\lookup.png"));
		btnNotasConsulta.setToolTipText("Consultar");
		tabNotasFaltas.add(btnNotasConsulta, "cell 0 5 9 1");
		
		btnNotasAlterar = new JButton("");
		btnNotasAlterar.setIcon(new ImageIcon("imagens\\icones\\edit.png"));
		btnNotasAlterar.setToolTipText("Alterar");
		tabNotasFaltas.add(btnNotasAlterar, "cell 0 5 9 1");
		
		btnNotasExcluir = new JButton("");
		btnNotasExcluir.setIcon(new ImageIcon("imagens\\icones\\delete.png"));
		btnNotasExcluir.setToolTipText("Excluir");
		tabNotasFaltas.add(btnNotasExcluir, "cell 0 5 9 1");
		
		tabBoletim = new JPanel();
		tabbedPane.addTab("Boletim", null, tabBoletim, "Boletim do aluno.");
		tabBoletim.setLayout(null);
		
		txtBoletim1 = new JTextPane();
		txtBoletim1.setEditable(false);
		txtBoletim1.setBounds(0, 43, 327, 262);
		tabBoletim.add(txtBoletim1);
		
		txtBoletim2 = new JTextPane();
		txtBoletim2.setEditable(false);
		txtBoletim2.setBounds(332, 43, 327, 262);
		tabBoletim.add(txtBoletim2);
		
		lblBoletimRGM = new JLabel("RGM:");
		lblBoletimRGM.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBoletimRGM.setBounds(10, 11, 64, 23);
		tabBoletim.add(lblBoletimRGM);
		
		lblBoletimSemestre = new JLabel("Semestre:");
		lblBoletimSemestre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBoletimSemestre.setBounds(193, 9, 104, 23);
		tabBoletim.add(lblBoletimSemestre);
		
		lblBoletimAno = new JLabel("Ano:");
		lblBoletimAno.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBoletimAno.setBounds(365, 9, 82, 23);
		tabBoletim.add(lblBoletimAno);
		
		txtBoletimRGM = new JFormattedTextField((new MaskFormatter("##########")));
		txtBoletimRGM.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtBoletimRGM.setColumns(10);
		txtBoletimRGM.setBounds(61, 8, 120, 31);
		tabBoletim.add(txtBoletimRGM);
		
		txtBoletimAno = new JFormattedTextField(new MaskFormatter("####"));
		txtBoletimAno.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtBoletimAno.setColumns(10);
		txtBoletimAno.setBounds(410, 8, 120, 31);
		tabBoletim.add(txtBoletimAno);
		
		cmbBoletimSemestre = new JComboBox();
		cmbBoletimSemestre.setFont(new Font("Monospaced", Font.PLAIN, 18));
		cmbBoletimSemestre.setModel(new DefaultComboBoxModel(new String[] {"1º", "2º", "3º", "4º"}));
		cmbBoletimSemestre.setBounds(293, 10, 62, 26);
		tabBoletim.add(cmbBoletimSemestre);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(540, 8, 109, 28);
		tabBoletim.add(btnNewButton);
		
		txtStatus = new JTextField();
		txtStatus.setToolTipText("Mensagens do sistema aparecem aqui.");
		txtStatus.setEditable(false);
		txtStatus.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtStatus.setBounds(10, 348, 664, 25);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
	}
	
	public void mudarStatus(String status) {
		txtStatus.setText(status);
	}
}
