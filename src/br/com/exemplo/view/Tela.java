package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;

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
	public Tela() {
		setTitle("Cadastro Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);
		
		mnAlSalvar = new JMenuItem("Salvar");
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
				// Talvez abrir um pop-up de confirmação??
				System.exit(0);
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
		GroupLayout gl_tabDadosPessoais = new GroupLayout(tabDadosPessoais);
		gl_tabDadosPessoais.setHorizontalGroup(
			gl_tabDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGap(0, 659, Short.MAX_VALUE)
		);
		gl_tabDadosPessoais.setVerticalGroup(
			gl_tabDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGap(0, 305, Short.MAX_VALUE)
		);
		tabDadosPessoais.setLayout(gl_tabDadosPessoais);
		
		tabCurso = new JPanel();
		tabbedPane.addTab("Dados do Curso", null, tabCurso, "Dados do curso do aluno.");
		
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
}
