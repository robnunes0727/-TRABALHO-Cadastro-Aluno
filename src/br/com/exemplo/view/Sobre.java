package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Sobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		****** COPIAR ESSA PARTE DO CODIGO E COLOCAR NO BOTÃO QUE ABRE A JANELA ******
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/icones/lookup.png")));
		setTitle("Sobre");
		setBounds(100, 100, 441, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[30px][][][][20][][][][][][]"));
		{
			JLabel lblSistemaDeCadastro = new JLabel("Sistema de Cadastro de Aluno");
			lblSistemaDeCadastro.setFont(new Font("Verdana", Font.BOLD, 24));
			lblSistemaDeCadastro.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblSistemaDeCadastro, "cell 0 0,growx,aligny top");
		}
		{
			JLabel lblFeitoPor = new JLabel("Feito por:");
			lblFeitoPor.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblFeitoPor, "flowx,cell 0 1");
		}
		{
			JLabel lblTurma = new JLabel("Turma:");
			lblTurma.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblTurma, "flowx,cell 0 2");
		}
		{
			JLabel lblPeriodo = new JLabel("Período:");
			lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblPeriodo, "flowx,cell 0 3");
		}
		{
			JLabel lblRobertoNunes = new JLabel("Roberto Nunes Moreira - 21267588");
			lblRobertoNunes.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblRobertoNunes, "cell 0 1,alignx left");
		}
		{
			JLabel lblADS = new JLabel("Análise e Desenvolvimento de Sistemas - 3A\r\n");
			lblADS.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblADS, "cell 0 2");
		}
		{
			JLabel lblManh = new JLabel("Manhã\r\n");
			lblManh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblManh, "cell 0 3");
		}
		{
			{
				JLabel lblOrganizacao = new JLabel("Organização (Trello)");
				lblOrganizacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblOrganizacao, "cell 0 5,alignx center");
			}
		}
		JLabel lblHyperlinkTrello = new JLabel("https://trello.com/b/NvBzzCYO/sistema-cadastro-do-aluno");
		lblHyperlinkTrello.addMouseListener(new MouseAdapter() {
			// TRELLO LINK
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Clicar no Link TRELLO
				try {
					Desktop.getDesktop().browse(new URI("https://trello.com/b/NvBzzCYO/sistema-cadastro-do-aluno"));
				} catch (IOException | URISyntaxException e1) {
			    	e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// Mudar mouse para mãozinha ao passar em cima e muda o visual do link
				lblHyperlinkTrello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblHyperlinkTrello.setText("<html><a href='aa'>https://trello.com/b/NvBzzCYO/sistema-cadastro-do-aluno</a></html>");
				// Nunca reparei que links ficavam sublinhados quando se passava o mouse em cima.
				// Fontes:
				// https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
				// https://stackoverflow.com/questions/11686938/how-to-change-the-mouse-pointer-to-finger-pointer-in-swing
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// Link volta ao normal
				lblHyperlinkTrello.setText("https://trello.com/b/NvBzzCYO/sistema-cadastro-do-aluno");
			}
			// FIM TRELLO LINK
		});
		lblHyperlinkTrello.setForeground(Color.BLUE.darker());
		lblHyperlinkTrello.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblHyperlinkTrello, "cell 0 6,alignx center");
		{
			{
				JLabel lblCodigo = new JLabel("Código (GitHub)");
				lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblCodigo, "cell 0 7,alignx center");
			}
		}
		JLabel lblHyperlinkGitHub = new JLabel("https://github.com/robnunes0727/cadastro-aluno");
		lblHyperlinkGitHub.addMouseListener(new MouseAdapter() {
			// GITHUB LINK
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Clicar no Link TRELLO
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/robnunes0727/cadastro-aluno"));
				} catch (IOException | URISyntaxException e1) {
			    	e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// Mudar mouse para mãozinha ao passar em cima e muda o visual do link
				lblHyperlinkGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblHyperlinkGitHub.setText("<html><a href='aa'>https://github.com/robnunes0727/cadastro-aluno</a></html>");
				// Nunca reparei que links ficavam sublinhados quando se passava o mouse em cima.
				// Fontes:
				// https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
				// https://stackoverflow.com/questions/11686938/how-to-change-the-mouse-pointer-to-finger-pointer-in-swing
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// Link volta ao normal
				lblHyperlinkGitHub.setText("https://github.com/robnunes0727/cadastro-aluno");
			}
			// FIM GITHUB LINK
		});
		lblHyperlinkGitHub.setForeground(new Color(0, 0, 178));
		lblHyperlinkGitHub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblHyperlinkGitHub, "cell 0 8,alignx center");
		{
			JButton btnNewButton = new JButton("FECHAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			contentPanel.add(btnNewButton, "cell 0 10,alignx center");
		}
	}
}
