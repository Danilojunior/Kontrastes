package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public static Connection getConnection(){
		//Objeto para permitir a conex�o
		Connection con =null;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoKontrastes","postgres","postgres");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			
			System.out.println("N�o pode conectar : "+ e.getMessage());
		}
		return con; 
	}
	
	

}
