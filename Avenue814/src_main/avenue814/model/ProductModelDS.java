package avenue814.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.sql.*;


import avenue814.controller.database.DBConnection;

public class ProductModelDS {
	
	private static Logger logger = Logger.getLogger("global");
	static Connection conn = DBConnection.getConnection();
	
	public ProductModelDS() {
		super();
	}
	
	public ArrayList<ProductBean> retrieveAllProductBySesso(String sesso) throws ClassNotFoundException, SQLException{
		logger.info("Ricerca prodotti in base al sesso in corso...");
		
		
		String sql = "SELECT * FROM Prodotti WHERE Prodotti.sesso LIKE '"+sesso+"';";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<ProductBean> listaProdotti = new ArrayList<ProductBean>();
		
		while(rs.next()) {
			ProductBean bean = new ProductBean(rs.getInt("id_prodotti"),
					rs.getString("nome"),
					rs.getDouble("prezzo"),
					rs.getString("descrizione"),
					rs.getString("categoria"),
					rs.getInt("quantita"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilita"),
					rs.getInt("proprieta"));
			
			listaProdotti.add(bean);
			
			
		}
		
		ps.close();
		
		
		logger.info("Ricerca completata!!");
		return listaProdotti;
	}
	
	public ArrayList<ProductBean> retrieveAllProductBySessoAndCategoria(String sesso, String categoria) throws ClassNotFoundException, SQLException{
		logger.info("Ricerca prodotti in base al sesso in corso...");
		
		
		String sql = "SELECT * FROM Prodotti WHERE Prodotti.sesso LIKE '"+sesso+"' AND Prodotti.categoria LIKE '"+categoria+"';";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<ProductBean> listaProdotti = new ArrayList<ProductBean>();
		
		while(rs.next()) {
			ProductBean bean = new ProductBean(rs.getInt("id_prodotti"),
					rs.getString("nome"),
					rs.getDouble("prezzo"),
					rs.getString("descrizione"),
					rs.getString("categoria"),
					rs.getInt("quantita"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilita"),
					rs.getInt("proprieta"));
			
			listaProdotti.add(bean);
			
			
		}
		
		if(ps != null) {ps.close();}
		
		logger.info("Ricerca completata!!");
		return listaProdotti;
	}
	
	public ProductBean retrieveProductById(int id) throws SQLException, ClassNotFoundException {
		
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
					rs.getInt("quantita"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilita"),
					rs.getInt("proprieta"));
			logger.info("Ricerca completata!");
			
			if(ps != null) {
				rs.close();
				ps.close();}
			
			return bean;
		}
		
		if(ps != null) {ps.close();}
		
		return null;
	}
	
	public ProductBean retrieveProductByName(String name) throws SQLException, ClassNotFoundException{
		
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
					rs.getInt("quantita"),
					rs.getString("pathImage"),
					rs.getString("sesso"),
					rs.getBoolean("disponibilita"),
					rs.getInt("proprieta"));
			logger.info("Ricerca completata!");

			if(ps != null) {
				rs.close();
				ps.close();}
			
			return bean;
		}
		
		if(ps != null) {ps.close();}
		
		return null;
	}
	
	public void toUpdateDisp(ProductBean item, boolean disp) throws SQLException {
		
		String sql = "UPDATE Prodotti SET Prodotti.disponibilita = ? WHERE Prodotti.id_prodotti LIKE ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setBoolean(1, disp);
		ps.setInt(2, item.getId());
		
		ps.executeUpdate();
		
		ps.close();
	}

	public void aggiungiQuantita(ProductBean item) throws SQLException {
		String sql = "UPDATE Prodotti SET Prodotti.quantita = ? WHERE Prodotti.id_prodotti LIKE ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, item.getQuantita());
		ps.setInt(2, item.getId());
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	public ArrayList<String> getPathFiles() throws SQLException {
		ArrayList<String> pathfiles = new ArrayList<String>();
		
		String sql = "SELECT Prodotti.pathImage FROM Prodotti;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pathfiles.add(rs.getString("pathImage"));
		}
		
		rs.close();
		ps.close();
		
		return pathfiles;
	}
	
	public void doSave(ProductBean product, UserBean user) throws SQLException {
		
		String sql = "INSERT INTO Prodotti(nome, prezzo, descrizione, categoria, quantita, pathImage, sesso, proprieta) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, product.getNome());
		ps.setDouble(2, product.getPrezzo());
		ps.setString(3, product.getDescrizione());
		ps.setString(4, product.getCategoria());
		ps.setInt(5, product.getQuantita());
		ps.setString(6, product.getPath_image());
		ps.setString(7, product.getSesso());
		ps.setInt(8, user.getId());
		
		ps.executeUpdate();
		
		ps.close();
	}
}
