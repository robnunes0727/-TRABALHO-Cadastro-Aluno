package br.com.exemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
					
			/* Minha DB */
			String login = "rob_root";
			String senha = "nuPFZ8nsew";		
			String url = "jdbc:mysql://db4free.net:3306/roberto_unicid";
			/* LINK PARA CONFERIR A TABELA: https://tabelas-ads.000webhostapp.com/ */
			
			return DriverManager.getConnection(url,login,senha);
		} catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}
}
