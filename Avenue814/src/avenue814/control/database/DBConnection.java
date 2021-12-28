package avenue814.control.database;

import java.sql.*;
import java.util.logging.Logger;

public class DBConnection {

	private static Logger logger = Logger.getLogger("global");
	
	/**
	 * definisce la connessione con il database
	 */
	
	private static Connection conn = null;

	
	static {
		String url = "jdbc:mysql://localhost:3306/Avenue814";
		String user = "root";
		String password = "ciaone123";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	

	
}
