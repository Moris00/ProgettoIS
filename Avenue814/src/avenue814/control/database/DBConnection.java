package avenue814.control.database;

import java.sql.*;
import java.util.logging.Logger;

public class DBConnection {

	private static Logger logger = Logger.getLogger("global");
	
	/**
	 * definisce la connessione con il database
	 */
	
	private static DBConnection instance = null;
	private Connection conn;
	private String databaseName;
	private String userName;
	private String password;
	private int hostPort;
	private String hostName;
	private static boolean isTest = false;
	
	/**
	 * Costruttore DB
	 * @param conn è lo stato della connessione
	 * @param hostName è il nome dell'host
	 * @param hostPort è il numero di porta dell'host
	 * @param databaseName è il nome del database
	 * @param userName è il nome dell'user
	 * @param password è la password dell'users
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * */
	public DBConnection() throws ClassNotFoundException, SQLException {
		logger.info("Creazione oggetto Database...");
		this.conn = null;
		this.hostName = "localhost";
		this.hostPort = 3306;
		this.databaseName = "Avenue814";
		this.userName = "root";
		this.password = "ciaone123";
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://" +this.hostName +":"+this.hostPort+"/"+this.databaseName+"?useSSL=false";
		
		this.conn = DriverManager.getConnection(url, this.userName, this.password);
		this.conn.setAutoCommit(false);
		
		logger.info("Database instanziato!!!");
	}
	
	/**
	 * Si ottiene un'istanza del database
	 * @return Restituisce un'istanza del database
	 * */
	public static DBConnection getIstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	/**
	 * Restituisce la connessione del database
	 * @return restituisce la connessione del database
	 * * */
	public synchronized Connection getCon() {
		return this.conn;
	} 
	
}
