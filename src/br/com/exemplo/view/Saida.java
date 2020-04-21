package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class Saida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSair;
	private JButton btnCancelar;
	private JLabel lblTemCertezaQue;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Saida dialog = new Saida();
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
	public Saida() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Confirmação de Saída");
		setAlwaysOnTop(true);
		setBounds(100, 100, 283, 166);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(10, 82, 102, 23);
		contentPanel.add(btnSair);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(122, 82, 135, 23);
		contentPanel.add(btnCancelar);
		
		lblTemCertezaQue = new JLabel("Tem certeza que deseja sair?");
		lblTemCertezaQue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTemCertezaQue.setBounds(18, 20, 234, 42);
		contentPanel.add(lblTemCertezaQue);
	}
}
