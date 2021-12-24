package avenue814.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import avenue814.control.database.DBConnection;

public class UserModelDS {
	
	private static Logger logger = Logger.getLogger("global");
	
	public UserModelDS() {
		super();
	}
	
	public UserBean getLogin(String email, String password) throws SQLException, ClassNotFoundException {
		logger.severe("Controllo il login...");
		
		Connection connection = DBConnection.getIstance().getCon();
		
		UserBean user = new UserBean();
		
		String sql = "SELECT * FROM Utente WHERE Utente.email LIKE '"+email+"' AND Utente.passw LIKE '"+password+"';";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user.setId(rs.getInt("id_utente"));
			user.setCarrello(new CarrelloBean());
			user.setCognome(rs.getString("cognome"));
			user.setNome(rs.getString("nome"));
			user.setEmail(rs.getString("email"));
			user.setRuolo(rs.getString("ruolo"));
			user.setUsername(rs.getString("username"));
		}
		
			
		if(user == null) {/*Eccezione*/}
		
		logger.severe("Login effetuato!!!");
		return user;
		
	}
	
}
