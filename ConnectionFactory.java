package br.com.livros.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "xxxxx";
	
	private static final String DATABASE_URL = "jdbc;mysql;//localhost;3306/sa4livros";
	
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] agrs) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conexão feita com sucesso");
				con.close();
		}
	}
	
}
