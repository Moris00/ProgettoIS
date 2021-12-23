
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import avenue814.control.database.*;

public class main {

	public static void main(String[] args) {
		try {
			DBConnection db = DBConnection.getIstance();
			Connection conn = db.getCon();
			
			PreparedStatement pr = conn.prepareStatement("SELECT * FROM PRODOTTI");
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("nome"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
