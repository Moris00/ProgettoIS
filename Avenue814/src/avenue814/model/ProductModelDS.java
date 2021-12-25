package avenue814.model;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import avenue814.control.database.DBConnection;

public class ProductModelDS {
	
	private static Logger logger = Logger.getLogger("global");
	
	public ProductModelDS() {
		super();
	}
	
	public ArrayList<ProductBean> retrieveAllProductBySesso(String sesso) throws ClassNotFoundException, SQLException{
		logger.info("Ricerca prodotti in base al sesso in corso...");
		DBConnection conn = DBConnection.getIstance();
		Connection connection = conn.getCon();
		
		
		String sql = "SELECT * FROM Prodotti WHERE Prodotti.sesso LIKE '"+sesso+"';";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<ProductBean> listaProdotti = new ArrayList<ProductBean>();
		
		while(rs.next()) {
			ProductBean bean = new ProductBean(rs.getInt("id_prodotti"),
					rs.getString("nome"),
					rs.getDouble("prezzo"),
					rs.getString("descrizione"),
					rs.getString("categoria"),
					rs.getInt("quantità"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilità"));
			
			listaProdotti.add(bean);
			
			
		}
		
		
		logger.info("Ricerca completata!!");
		return listaProdotti;
	}
	
	public ArrayList<ProductBean> retrieveAllProductBySessoAndCategoria(String sesso, String categoria) throws ClassNotFoundException, SQLException{
		logger.info("Ricerca prodotti in base al sesso in corso...");
		Connection connection = DBConnection.getIstance().getCon();
		
		
		String sql = "SELECT * FROM Prodotti WHERE Prodotti.sesso LIKE '"+sesso+"' AND Prodotti.categoria LIKE '"+categoria+"';";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<ProductBean> listaProdotti = new ArrayList<ProductBean>();
		
		while(rs.next()) {
			ProductBean bean = new ProductBean(rs.getInt("id_prodotti"),
					rs.getString("nome"),
					rs.getDouble("prezzo"),
					rs.getString("descrizione"),
					rs.getString("categoria"),
					rs.getInt("quantità"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilità"));
			
			listaProdotti.add(bean);
			
			
		}
		
		
		
		logger.info("Ricerca completata!!");
		return listaProdotti;
	}
	
	public ProductBean retrieveProductById(int id) throws SQLException, ClassNotFoundException {
		Connection conn = DBConnection.getIstance().getCon();
		
		String sql = "SELECT * FROM Prodotti WHERE Prodotti.id_prodotti = "+id+";";
		logger.info("Ricerca del prodotto "+id+" in corso...");
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductBean bean = new ProductBean(rs.getInt("id_prodotti"),
					rs.getString("nome"),
					rs.getDouble("prezzo"),
					rs.getString("descrizione"),
					rs.getString("categoria"),
					rs.getInt("quantità"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilità"));
			logger.info("Ricerca completata!");
			return bean;
		}
		
		return null;
	}
	
	public ProductBean retrieveProductByName(String name) throws SQLException, ClassNotFoundException{
		Connection conn = DBConnection.getIstance().getCon();
		
		String sql = "SELECT * FROM Prodotti WHERE Prodotti.nome = '"+name+"';";
		logger.info("Ricerca del prodotto "+name+" in corso...");
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductBean bean = new ProductBean(rs.getInt("id_prodotti"),
					rs.getString("nome"),
					rs.getDouble("prezzo"),
					rs.getString("descrizione"),
					rs.getString("categoria"),
					rs.getInt("quantità"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilità"));
			logger.info("Ricerca completata!");
			return bean;
		}
		
		return null;
	}
	
}
