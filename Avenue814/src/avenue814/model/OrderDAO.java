package avenue814.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import avenue814.controller.database.DBConnection;

public class OrderDAO{
	private static Logger logger = Logger.getLogger("global");
	static Connection conn = DBConnection.getConnection();
	
	public OrderDAO() {
		super();
	}
	
	public OrderDAO(Connection conn) {
		this.conn = conn;
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
	
	public ArrayList<OrderBean> searchOrderById(int id) throws SQLException {
		PreparedStatement ps = null;
		try {
		String sql = "SELECT * FROM Ordini WHERE Ordini.id_user = "+id+";";
		ps = conn.prepareStatement(sql);
		
		
		logger.info("Eseguimento query: "+sql);

		
		ResultSet rs = ps.executeQuery();
		ArrayList<OrderBean> ordini = new ArrayList<OrderBean>();
		while(rs.next()) {
			OrderBean order = new OrderBean( rs.getInt("id_prodotto"),
								rs.getInt("id_ordini"),
								rs.getString("dataa"),"","",
								rs.getString("indirizzo"),"",
								rs.getString("method_pagament"));
			ordini.add(order);
		}
		return ordini;
		
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ps.close();
		}
		return null;
	}
}
