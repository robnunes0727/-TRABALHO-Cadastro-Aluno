package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class CodigoSQL extends JDialog {

	/**
	 * Launch the application.

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			CodigoSQL dialog = new CodigoSQL();
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
	public CodigoSQL() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CodigoSQL.class.getResource("/icones/edit.png")));
		setTitle("Código SQL");
		setBounds(100, 100, 450, 468);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][30:30:30]"));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setToolTipText("DDL - Criações");
			getContentPane().add(tabbedPane, "cell 0 0,grow");
			{
				JPanel abaDDL = new JPanel();
				tabbedPane.addTab("DDL - Criações", null, abaDDL, "Criação de SCHEMA e TABELAS");
				abaDDL.setLayout(new MigLayout("", "[grow]", "[grow]"));
				{
					JScrollPane scrollPane = new JScrollPane();
					abaDDL.add(scrollPane, "cell 0 0,grow");
					{
						JTextArea txtDDL = new JTextArea();
						txtDDL.setEditable(false);
						txtDDL.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent e) {
								txtDDL.selectAll();
							}
						});
						txtDDL.setFont(new Font("Consolas", Font.PLAIN, 11));
						scrollPane.setViewportView(txtDDL);
						txtDDL.setText("-- MySQL Workbench Forward Engineering\r\n" + 
								"\r\n" + 
								"SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;\r\n" + 
								"SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;\r\n" + 
								"SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Schema roberto_unicid\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"DROP SCHEMA IF EXISTS `roberto_unicid` ;\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Schema roberto_unicid\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE SCHEMA IF NOT EXISTS `roberto_unicid` ;\r\n" + 
								"USE `roberto_unicid` ;\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`Aluno`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Aluno` (\r\n" + 
								"  `rgm` CHAR(8) NOT NULL,\r\n" + 
								"  `nome` VARCHAR(45) NOT NULL,\r\n" + 
								"  `nascimento` DATE NOT NULL,\r\n" + 
								"  `cpf` CHAR(11) NOT NULL,\r\n" + 
								"  `email` VARCHAR(45) NOT NULL DEFAULT 'NENHUM',\r\n" + 
								"  `endereco` VARCHAR(45) NOT NULL,\r\n" + 
								"  `municipio` VARCHAR(45) NOT NULL,\r\n" + 
								"  `uf` CHAR(2) NOT NULL,\r\n" + 
								"  `celular` VARCHAR(45) NOT NULL DEFAULT '000000000000',\r\n" + 
								"  PRIMARY KEY (`rgm`),\r\n" + 
								"  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`Curso`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Curso` (\r\n" + 
								"  `id` INT NOT NULL,\r\n" + 
								"  `nome` VARCHAR(80) NOT NULL,\r\n" + 
								"  `campus` VARCHAR(45) NOT NULL,\r\n" + 
								"  PRIMARY KEY (`id`))\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`Disciplina`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Disciplina` (\r\n" + 
								"  `id` INT NOT NULL,\r\n" + 
								"  `nome` VARCHAR(45) NOT NULL,\r\n" + 
								"  PRIMARY KEY (`id`))\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`Turma`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Turma` (\r\n" + 
								"  `id` INT NOT NULL,\r\n" + 
								"  `curso_id` INT NOT NULL,\r\n" + 
								"  `periodo` CHAR(1) NOT NULL,\r\n" + 
								"  `semestre` CHAR(7) NOT NULL,\r\n" + 
								"  PRIMARY KEY (`id`),\r\n" + 
								"  INDEX `fk_Turma_Curso1_idx` (`curso_id` ASC) VISIBLE,\r\n" + 
								"  CONSTRAINT `fk_Turma_Curso1`\r\n" + 
								"    FOREIGN KEY (`curso_id`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`Curso` (`id`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE)\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`AlunoEmTurma`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`AlunoEmTurma` (\r\n" + 
								"  `Aluno_rgm` CHAR(8) NOT NULL,\r\n" + 
								"  `Turma_id` INT NOT NULL,\r\n" + 
								"  INDEX `fk_Aluno_has_Turma_Turma1_idx` (`Turma_id` ASC) VISIBLE,\r\n" + 
								"  INDEX `fk_Aluno_has_Turma_Aluno1_idx` (`Aluno_rgm` ASC) VISIBLE,\r\n" + 
								"  UNIQUE INDEX `Aluno_rgm_UNIQUE` (`Aluno_rgm` ASC) VISIBLE,\r\n" + 
								"  PRIMARY KEY (`Aluno_rgm`),\r\n" + 
								"  CONSTRAINT `fk_Aluno_has_Turma_Aluno1`\r\n" + 
								"    FOREIGN KEY (`Aluno_rgm`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`Aluno` (`rgm`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE,\r\n" + 
								"  CONSTRAINT `fk_Aluno_has_Turma_Turma1`\r\n" + 
								"    FOREIGN KEY (`Turma_id`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`Turma` (`id`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE)\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`DisciplinaEmCurso`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`DisciplinaEmCurso` (\r\n" + 
								"  `Disciplina_id` INT NOT NULL,\r\n" + 
								"  `Curso_id` INT NOT NULL,\r\n" + 
								"  INDEX `fk_Disciplina_has_Curso_Curso1_idx` (`Curso_id` ASC) VISIBLE,\r\n" + 
								"  INDEX `fk_Disciplina_has_Curso_Disciplina1_idx` (`Disciplina_id` ASC) VISIBLE,\r\n" + 
								"  PRIMARY KEY (`Disciplina_id`, `Curso_id`),\r\n" + 
								"  CONSTRAINT `fk_Disciplina_has_Curso_Disciplina1`\r\n" + 
								"    FOREIGN KEY (`Disciplina_id`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`Disciplina` (`id`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE,\r\n" + 
								"  CONSTRAINT `fk_Disciplina_has_Curso_Curso1`\r\n" + 
								"    FOREIGN KEY (`Curso_id`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`Curso` (`id`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE)\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"-- Table `roberto_unicid`.`NotasFaltas`\r\n" + 
								"-- -----------------------------------------------------\r\n" + 
								"CREATE TABLE IF NOT EXISTS `roberto_unicid`.`NotasFaltas` (\r\n" + 
								"  `Aluno_rgm` CHAR(8) NOT NULL,\r\n" + 
								"  `Faltas` INT NOT NULL DEFAULT 0,\r\n" + 
								"  `Nota` FLOAT(3,1) NOT NULL DEFAULT 0,\r\n" + 
								"  `Disciplina_id` INT NOT NULL,\r\n" + 
								"  `Curso_id` INT NOT NULL,\r\n" + 
								"  PRIMARY KEY (`Aluno_rgm`, `Disciplina_id`, `Curso_id`),\r\n" + 
								"  INDEX `fk_NotasFaltas_AlunoEmTurma1_idx` (`Aluno_rgm` ASC) VISIBLE,\r\n" + 
								"  INDEX `fk_NotasFaltas_DisciplinaEmCurso1_idx` (`Disciplina_id` ASC, `Curso_id` ASC) VISIBLE,\r\n" + 
								"  CONSTRAINT `fk_NotasFaltas_AlunoEmTurma1`\r\n" + 
								"    FOREIGN KEY (`Aluno_rgm`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`AlunoEmTurma` (`Aluno_rgm`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE,\r\n" + 
								"  CONSTRAINT `fk_NotasFaltas_DisciplinaEmCurso1`\r\n" + 
								"    FOREIGN KEY (`Disciplina_id` , `Curso_id`)\r\n" + 
								"    REFERENCES `roberto_unicid`.`DisciplinaEmCurso` (`Disciplina_id` , `Curso_id`)\r\n" + 
								"    ON DELETE CASCADE\r\n" + 
								"    ON UPDATE CASCADE)\r\n" + 
								"ENGINE = InnoDB;\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"SET SQL_MODE=@OLD_SQL_MODE;\r\n" + 
								"SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;\r\n" + 
								"SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;\r\n");
						{
							JPopupMenu popupMenu = new JPopupMenu();
							addPopup(txtDDL, popupMenu);
							{
								JMenuItem mnCopiar = new JMenuItem("Copiar");
								mnCopiar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										txtDDL.copy();
									}
								});
								popupMenu.add(mnCopiar);
							}
							{
								JSeparator separator = new JSeparator();
								popupMenu.add(separator);
							}
							{
								JMenuItem mnSelecionar = new JMenuItem("Selecionar tudo");
								mnSelecionar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										txtDDL.selectAll();
									}
								});
								popupMenu.add(mnSelecionar);
							}
						}
					}
				}
			}
			{
				JPanel abaDML = new JPanel();
				tabbedPane.addTab("DML - Inserts", null, abaDML, "Inserção dos dados nas tabelas");
				abaDML.setLayout(new MigLayout("", "[grow]", "[grow]"));
				{
					JScrollPane scrollPane = new JScrollPane();
					abaDML.add(scrollPane, "cell 0 0,grow");
					{
						JTextArea txtDML = new JTextArea();
						txtDML.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								txtDML.selectAll();
							}
						});
						txtDML.setFont(new Font("Consolas", Font.PLAIN, 11));
						txtDML.setText("USE roberto_unicid;\n\n-- Adiciona cursos\nINSERT INTO Curso (id, nome, campus) VALUES \n(1, 'Análise e Desenvolvimento de Sistemas', 'Tatuapé'),\n(2, 'Ciên"
								+ "cia da Computação', 'Tatuapé'),\n(3, 'Medicina', 'Pinheiros');\n\n-- Adiciona disciplinas\nINSERT INTO Disciplina (id, nome) VALUES \n(1, 'Java'),\n(2, 'PHP'),\n"
								+ "(3, 'Farmacologia'),\n(4, 'Segurança de Dados'),\n(5, 'Virologia');\n\n-- Adiciona turmas\nINSERT INTO Turma (id, curso_id, periodo, semestre) VALUES \n(1, 3, 'M"
								+ "', '2019-02'),\n(2, 3, 'V', '2019-02'),\n(3, 1, 'M', '2020-01'),\n(4, 2, 'M', '2020-01'),\n(5, 3, 'M', '2020-01'),\n(6, 1, 'V', '2020-01'),\n(7, 2, 'V', '2020-01"
								+ "'),\n(8, 3, 'V', '2020-01'),\n(9, 1, 'N', '2020-01'),\n(10, 2, 'N', '2020-01');\n\n-- Associa cursos e disciplinas\nINSERT INTO DisciplinaEmCurso (Curso_id,Disci"
								+ "plina_id) VALUES\n(1,1),\n(1,2),\n(2,1),\n(2,2),\n(2,4),\n(3,3),\n(3,5);\n\n");
						scrollPane.setViewportView(txtDML);
						txtDML.setEditable(false);
						{
							JPopupMenu popupMenu = new JPopupMenu();
							addPopup(txtDML, popupMenu);
							{
								JMenuItem mnCopiar = new JMenuItem("Copiar");
								mnCopiar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										txtDML.copy();
									}
								});
								popupMenu.add(mnCopiar);
							}
							{
								JSeparator separator = new JSeparator();
								popupMenu.add(separator);
							}
							{
								JMenuItem mnSelecionar = new JMenuItem("Selecionar tudo");
								mnSelecionar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										txtDML.selectAll();
									}
								});
								popupMenu.add(mnSelecionar);
							}
						}
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 0 1,growx,aligny top");
			{
				JButton btnSair = new JButton("FECHAR");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnSair);
				getRootPane().setDefaultButton(btnSair);
			}
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
