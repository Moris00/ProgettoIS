package avenue814.model;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.sql.*;


import avenue814.control.database.DBConnection;

public class ProductModelDS {
	
	private static Logger logger = Logger.getLogger("global");
	private DataSource ds;
	
	public ProductModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<ProductBean> retrieveAllProductBySesso(String sesso) throws ClassNotFoundException, SQLException{
		logger.info("Ricerca prodotti in base al sesso in corso...");
		Connection connection = ds.getConnection();
		
		
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
		
		ps.close();
		connection.close();
		
		
		logger.info("Ricerca completata!!");
		return listaProdotti;
	}
	
	public ArrayList<ProductBean> retrieveAllProductBySessoAndCategoria(String sesso, String categoria) throws ClassNotFoundException, SQLException{
		logger.info("Ricerca prodotti in base al sesso in corso...");
		Connection connection = ds.getConnection();
		
		
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
		
		if(ps != null && connection != null) {ps.close();
		connection.close();}
		
		logger.info("Ricerca completata!!");
		return listaProdotti;
	}
	
	public ProductBean retrieveProductById(int id) throws SQLException, ClassNotFoundException {
		Connection conn = ds.getConnection();
		
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
			
			if(ps != null) {
				rs.close();
				ps.close();
			conn.close();}
			
			return bean;
		}
		
		if(ps != null && conn != null) {ps.close();
		conn.close();}
		
		return null;
	}
	
	public ProductBean retrieveProductByName(String name) throws SQLException, ClassNotFoundException{
		Connection conn = ds.getConnection();
		
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

			if(ps != null) {
				rs.close();
				ps.close();
			conn.close();}
			
			return bean;
		}
		
		if(ps != null) {ps.close();}
		
		return null;
	}
	
	public void toUpdateDisp(ProductBean item, boolean disp) throws SQLException {
		Connection connection = ds.getConnection();
		
		String sql = "UPDATE Prodotti SET Prodotti.disponibilità = ? WHERE Prodotti.id_prodotti LIKE ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setBoolean(1, disp);
		ps.setInt(2, item.getId());
		
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}

	public void aggiungiQuantità(ProductBean item) throws SQLException {
		Connection connection = ds.getConnection();
		String sql = "UPDATE Prodotti SET Prodotti.quantità = ? WHERE Prodotti.id_prodotti LIKE ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, item.getQuantità());
		ps.setInt(2, item.getId());
		
		ps.executeUpdate();
		
		ps.close();
		connection.close();	
		
	}
	
	public ArrayList<String> getPathFiles() throws SQLException {
		ArrayList<String> pathfiles = new ArrayList<String>();
		
		Connection connection = ds.getConnection();
		String sql = "SELECT Prodotti.pathImage FROM Prodotti;";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pathfiles.add(rs.getString("pathImage"));
		}
		
		rs.close();
		ps.close();
		connection.close();
		
		return pathfiles;
	}
	
	public void doSave(ProductBean product) throws SQLException {
		
		Connection connection = ds.getConnection();
		String sql = "INSERT INTO Prodotti(nome, prezzo, descrizione, categoria, quantità, pathImage, sesso) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, product.getNome());
		ps.setDouble(2, product.getPrezzo());
		ps.setString(3, product.getDescrizione());
		ps.setString(4, product.getCategoria());
		ps.setInt(5, product.getQuantità());
		ps.setString(6, product.getPath_image());
		ps.setString(7, product.getSesso());
	}
}
