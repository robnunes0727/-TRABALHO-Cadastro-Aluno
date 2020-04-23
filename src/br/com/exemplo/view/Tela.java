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

public class Tela extends JFrame {

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
	private String inputErro = ""; // Tratamento de entrada invalida: 'ESTADO', 'CELULAR' e 'DATA'
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
					Tela frame = new Tela();
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
	public Tela() throws Exception {		
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
				if (inputErro == "") {
					mudarStatus("POOF");
				} else {
					String msgErro = "Erro nos campos: " + inputErro.replace("''", ", "); 
					mudarStatus(msgErro);
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
		
		txtRgm = new JFormattedTextField(new MaskFormatter("##########"));;
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
						+"[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|"
						+ "1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|"
						+ "(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|"
						+"[13579][26])|((16|[2468][048]|[3579][26])00))))$";			
				
				if(txtNasc.getText().matches(padraoData)){
					txtNasc.setBackground(Color.GREEN);
					mudarStatus("");
					inputErro = inputErro.replace("'DATA'", "");
				}
				else {
					txtNasc.setBackground(Color.RED);
					mudarStatus("Data inválida.");
					if (!inputErro.contains("'DATA'"))
						inputErro = inputErro + "'DATA'";
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
					if (!inputErro.contains("'ESTADO'"))
						inputErro = inputErro + "'ESTADO'";
					mudarStatus("UF inválida.");
				} else {
					inputErro = inputErro.replace("'ESTADO'", "");
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
		txtCel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Ação Celular
				// Validar
				// JFORMAT retorna numeros formatados
				if (txtCel.getText().matches("^\\(\\d\\d\\) 9\\d\\d\\d\\d\\-\\d\\d\\d\\d$")) {
					txtCel.setBackground(Color.GREEN);
					mudarStatus("");
					inputErro = inputErro.replace("'CELULAR'", "");
				}
				else {
					txtCel.setBackground(Color.RED);
					mudarStatus("Celular inválido.");
					if (!inputErro.contains("'CELULAR'"))
						inputErro = inputErro + "'CELULAR'";
				}
				// Fim Celular
			}
		});
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
		btnInserir.setIcon(new ImageIcon("D:\\Users\\Rob\\OneDrive\\AULAS\\TERCEIRO SEMESTRE\\Técnicas de Programação\\[2020.05.04 - 02] Cadastro Aluno\\imagens\\icones\\save.png"));
		btnInserir.setToolTipText("Salvar");
		tabCurso.add(btnInserir, "flowx,cell 0 6 6 1,alignx center");
		
		btnConsulta = new JButton("");
		btnConsulta.setToolTipText("Salvar");
		btnConsulta.setIcon(new ImageIcon("D:\\Users\\Rob\\OneDrive\\AULAS\\TERCEIRO SEMESTRE\\Técnicas de Programação\\[2020.05.04 - 02] Cadastro Aluno\\imagens\\icones\\lookup.png"));
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tabCurso.add(btnConsulta, "cell 0 6 6 1,alignx center");
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon("D:\\Users\\Rob\\OneDrive\\AULAS\\TERCEIRO SEMESTRE\\Técnicas de Programação\\[2020.05.04 - 02] Cadastro Aluno\\imagens\\icones\\edit.png"));
		btnAlterar.setToolTipText("Salvar");
		tabCurso.add(btnAlterar, "cell 0 6 6 1,alignx center");
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("D:\\Users\\Rob\\OneDrive\\AULAS\\TERCEIRO SEMESTRE\\Técnicas de Programação\\[2020.05.04 - 02] Cadastro Aluno\\imagens\\icones\\delete.png"));
		btnExcluir.setToolTipText("Salvar");
		tabCurso.add(btnExcluir, "cell 0 6 6 1,alignx center");
		
		tabNotasFaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, tabNotasFaltas, "Notas e faltas do aluno.");
		
		tabBoletim = new JPanel();
		tabbedPane.addTab("Boletim", null, tabBoletim, "Boletim do aluno.");
		
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
