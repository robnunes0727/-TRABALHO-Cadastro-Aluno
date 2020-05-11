package br.com.exemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8
			
			String login;
			String senha;
			String url;
			
			if (Globals.banco == 0) {			
				/* Local */
				System.out.println("Conectando ao Banco de Dados local...");
				login = "root";
				senha = "root";
				url = "jdbc:mysql://localhost:3306/roberto_unicid";
			} else {
				/* Online, será apagado quando a nota sair */
				System.out.println("Conectando ao Banco de Dados remoto...");
				login = "rob_root";
				senha = "nuPFZ8nsew";		
				url = "jdbc:mysql://db4free.net:3306/roberto_unicid";
			}
			
			return DriverManager.getConnection(url,login,senha);
		} catch(Exception e) {
			throw new Exception("SQL " + e.getMessage());
		}
	}
}
