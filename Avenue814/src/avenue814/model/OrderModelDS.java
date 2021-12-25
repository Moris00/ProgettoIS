package avenue814.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import avenue814.control.database.DBConnection;

public class OrderModelDS {
	private static Logger logger = Logger.getLogger("global");
	
	public OrderModelDS() {
		super();
	}
	
	public void addOrderDS(OrderBean order) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getIstance().getCon();
		
		
		String sql = "INSERT INTO Ordini VALUES (?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
	}
}
