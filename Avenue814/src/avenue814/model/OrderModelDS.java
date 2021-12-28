package avenue814.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import avenue814.control.database.DBConnection;

public class OrderModelDS {
	private static Logger logger = Logger.getLogger("global");
	static Connection conn = DBConnection.getConnection();
	
	public OrderModelDS() {
		super();
	}
	
	public void addOrderDS(OrderBean order) throws SQLException, ClassNotFoundException{
		PreparedStatement ps = null;
		try {
		
		
		logger.info("Inserimento ordine dell'utente "+order.getId_user()+"...");
		String sql = "INSERT INTO Ordini (id_user, id_prodotto, indirizzo, method_pagament, dataa) VALUES("+order.getId_user()+","+order.getId_prodotto()+",'"+order.getIndirizzo()+"','"+order.getMetodo_di_pagamento()+"', '"+order.getData()+"');";
		ps = conn.prepareStatement(sql);
		
		
		logger.info("Eseguimento query: "+sql);

		
		int r = ps.executeUpdate();
		
		if(r == 1) logger.info("Inserimento ordine completata!!");
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ps.close();
		}
	}
}
