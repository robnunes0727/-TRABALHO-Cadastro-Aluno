package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Licenca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblLic1;
	private JLabel lblLic2;
	private JButton btnFechar;
	private JLabel lblLic3;
	private JLabel lblLic4;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Licenca dialog = new Licenca();
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
	public Licenca() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Licenca.class.getResource("/icones/icon.png")));
		setTitle("Licenças e Recursos");
		setResizable(false);
		setBounds(100, 100, 259, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow,center]", "[][5][][][][][baseline]"));
		{
			JLabel lblSistemaDeCadastro = new JLabel("Recursos Usados");
			lblSistemaDeCadastro.setHorizontalAlignment(SwingConstants.CENTER);
			lblSistemaDeCadastro.setFont(new Font("Verdana", Font.BOLD, 24));
			contentPanel.add(lblSistemaDeCadastro, "cell 0 0,alignx center");
		}
		
		lblLic2 = new JLabel("MiG Layout (BSD License)");
		lblLic2.setToolTipText("Layout de painel");
		lblLic2.addMouseListener(new MouseAdapter() {
			// LIC2 LINK (mig)
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Clicar no Link TRELLO
				try {
					Desktop.getDesktop().browse(new URI("http://www.miglayout.com/"));
				} catch (IOException | URISyntaxException e1) {
			    	e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// Mudar mouse para mãozinha ao passar em cima e muda o visual do link
				lblLic2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblLic2.setText("<html><a href='aa'>MiG Layout (BSD License)</a></html>");
				// Nunca reparei que links ficavam sublinhados quando se passava o mouse em cima.
				// Fontes:
				// https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
				// https://stackoverflow.com/questions/11686938/how-to-change-the-mouse-pointer-to-finger-pointer-in-swing
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// Link volta ao normal
				lblLic2.setText("MiG Layout (BSD License)");
			}
			// FIM LIC2 LINK (mig)
		});
		lblLic2.setForeground(new Color(0, 0, 178));
		lblLic2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblLic2, "cell 0 2");
		
		lblLic1 = new JLabel("GNOME Desktop Icons (GPL 2)");
		lblLic1.setToolTipText("Pacote de ícones");
		lblLic1.addMouseListener(new MouseAdapter() {
			// LIC2 LINK (gnome)
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Clicar no Link TRELLO
				try {
					Desktop.getDesktop().browse(new URI("https://commons.wikimedia.org/wiki/GNOME_Desktop_icons"));
				} catch (IOException | URISyntaxException e1) {
			    	e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// Mudar mouse para mãozinha ao passar em cima e muda o visual do link
				lblLic1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblLic1.setText("<html><a href='aa'>GNOME Desktop Icons (GPL 2)</a></html>");
				// Nunca reparei que links ficavam sublinhados quando se passava o mouse em cima.
				// Fontes:
				// https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
				// https://stackoverflow.com/questions/11686938/how-to-change-the-mouse-pointer-to-finger-pointer-in-swing
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// Link volta ao normal
				lblLic1.setText("GNOME Desktop Icons (GPL 2)");
			}
			// FIM LIC2 LINK (gnome)
		});
		lblLic1.setForeground(new Color(0, 0, 178));
		lblLic1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblLic1, "cell 0 3");
		
		btnFechar = new JButton("FECHAR");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão fechar
				dispose();
				// Fim botão fechar
			}
		});
		
		lblLic3 = new JLabel("db4Free");
		lblLic3.setToolTipText("Para hospedar o banco remoto");
		lblLic3.setForeground(new Color(0, 0, 178));
		lblLic3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblLic3, "cell 0 4");
		
		lblLic4 = new JLabel(" ");
		lblLic4.setForeground(new Color(0, 0, 178));
		lblLic4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblLic4, "cell 0 5");
		contentPanel.add(btnFechar, "cell 0 6,alignx center,aligny baseline");
	}

}
