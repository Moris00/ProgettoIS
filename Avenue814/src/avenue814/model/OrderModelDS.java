package avenue814.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import avenue814.control.database.DBConnection;

public class OrderModelDS {
	private static Logger logger = Logger.getLogger("global");
	private DataSource ds;
	
	public OrderModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public void addOrderDS(OrderBean order) throws SQLException, ClassNotFoundException{
		PreparedStatement ps = null;
		try {
		Connection conn = DBConnection.getIstance().getCon();
		
		
		logger.info("Inserimento ordine dell'utente "+order.getId_user()+"...");
		String sql = "INSERT INTO Ordini (id_user, id_prodotto, indirizzo, method_pagament, dataa) VALUES (?,?,'"+order.getIndirizzo()+"','"+order.getMetodo_di_pagamento()+"', '"+order.getData()+"');";
		ps = conn.prepareStatement(sql);
		
		
		logger.info("Eseguimento query: "+sql);
		
		ps.setInt(1, order.getId_user());
		ps.setInt(2, order.getId_prodotto());

		
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
