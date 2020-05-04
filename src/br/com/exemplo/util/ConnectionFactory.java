package br.com.exemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8
					
			/* Minha DB Online
			String login = "rob_root";
			String senha = "nuPFZ8nsew";		
			String url = "jdbc:mysql://db4free.net:3306/roberto_unicid";
			/* */
			
			/* Local */
			String login = "root";
			String senha = "root";
			String url = "jdbc:mysql://localhost:3306/roberto_unicid";
			
			return DriverManager.getConnection(url,login,senha);
		} catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}
}
