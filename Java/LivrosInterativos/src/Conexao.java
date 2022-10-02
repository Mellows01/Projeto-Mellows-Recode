import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String username = "root";
	
	private static final String password = "";

	// dados de caminho, porta e nome da base de dados que irá serfeita a conexão
	private static final String database_url = "jdbc:mysql://localhost:3306/LI";

	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection connection = DriverManager.getConnection(database_url,username,password);
		return connection;
	}

}
