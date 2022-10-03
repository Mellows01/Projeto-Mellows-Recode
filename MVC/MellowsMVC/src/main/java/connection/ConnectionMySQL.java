package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {

	private static String URL = "jdbc:mysql://localhost:3306/mellows";
	private static String USUARIO = "root";
	private static String SENHA = "Jessic@22303109";

	public static Connection createConnectionMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		return connection;
	}
	
}