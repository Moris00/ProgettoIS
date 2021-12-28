package avenue814.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import avenue814.control.database.DBConnection;

public class UserModelDS {
	
	private static Logger logger = Logger.getLogger("global");
	static Connection conn = DBConnection.getConnection();
	
	public UserModelDS() {
		super();
	}
	
	public UserBean getLogin(String email, String password) throws SQLException, ClassNotFoundException {
		logger.severe("Controllo il login...");

		
		UserBean user = new UserBean();
		
		String sql = "SELECT * FROM Utente WHERE Utente.email LIKE '"+email+"' AND Utente.passw LIKE '"+password+"';";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
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
		
		if(ps != null) {ps.close();}
		if(user == null) {/*Eccezione*/}
		
		logger.severe("Login effetuato!!!");
		return user;
		
	}
	
	public boolean isNewUser(UserBean user) throws SQLException {
		
		String sql = "Select * From Utente WHERE Utente.email LIKE '"+user.getEmail()+"';";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			rs.close();
			ps.close();
			return false;
		}
		rs.close();
		ps.close();
		return true;
		
	}
	
	public void addNewUser(UserBean user) throws SQLException {
		logger.info("Inserimento del nuovo utente al DS, l'account: "+user.getEmail());
		
		String sql = "INSERT INTO Utente (email, passw, nome, cognome, username, ruolo) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getNome());
		ps.setString(4, user.getCognome());
		ps.setString(5, user.getUsername());
		ps.setString(6, user.getRuolo());
		
		ps.executeUpdate();
		
		logger.info("L'account "+user.getEmail()+" aggiunto");
		ps.close();
	}
}
