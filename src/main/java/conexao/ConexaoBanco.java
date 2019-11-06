package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	static Connection connection;
	static final String USER = "pemaza";
	static final String PASS = "pemaza";
	
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		if(connection == null || connection.isClosed()) {
			String url = "jdbc:postgresql://192.168.151.84:5432/pgfil"; // Desenvolvimento
//			String url = "jdbc:postgresql://192.168.151.47:5432/pgfil"; // Homologação
			String driverJDBC = "org.postgresql.Driver";
			
			try {
				
				System.out.println("Conexao realizado com sucesso!!");
				
				Class.forName(driverJDBC).newInstance();
				connection = DriverManager.getConnection(url, USER, PASS);
				
				return connection;
			} catch(Exception e) {
				
				System.out.println("Conexao nao realizado");
				e.printStackTrace();
			}
		}
		return connection;	
	}
	
	public static Connection closeConnection() throws SQLException {
		
		if(connection != null && !connection.isClosed())
			connection.close();
		
		System.out.println("Voce desconectou com sucesso!!");
		return connection;
	}
}
