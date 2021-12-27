package avenue814.model;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Definisce l'entità Carrello 
 * */
public class CarrelloBean {
	
	private static Logger logger = Logger.getLogger("global");
	
	private ArrayList<ProductBean> listaProdotti;
	private double prezzoTot;
	
	public CarrelloBean() {
		logger.info("Creazione carrello...");
		
		listaProdotti = new ArrayList<ProductBean>();
		prezzoTot = 0;
		
		logger.info("Carrello creato :)");
	}
	
	
	/**
	 * 
	 * 
	 * */
	public void addProduct(ProductBean item) {
		logger.info("Aggiunta prodotto "+item.getNome()+" in corso...");
		if(item == null) {/*Eccezione*/}
		
		listaProdotti.add(item);
		prezzoTot += item.getPrezzo();
		
		logger.info("Prodotto "+item.getNome()+" aggiunto al carrello");
	}
	
	public void removeProduct(ProductBean item) {
		logger.info("Rimozione prodotto "+item.getNome()+" in corso...");
		if(item == null) {/*Eccezione*/}
		
		listaProdotti.remove(searchProductGetIndex(item));
		prezzoTot -= item.getPrezzo();
		
		logger.info("Prodotto "+item.getNome()+" eliminato dal carrello");
	}
	
	public int searchProductGetIndex(ProductBean item) {
		for(int i = 0; i < listaProdotti.size(); i++) {
			if(listaProdotti.get(i).getId() == item.getId()) {
				return i;
			}
		}
		return -1;
	}
	
	public ProductBean searchProduct(String nome) {
		for(int i = 0; i < listaProdotti.size(); i++) {
			if(listaProdotti.get(i).getNome().equals(nome)) {
				return listaProdotti.get(i);
			}
		}
		return null;
	}
	
	public ProductBean getProductByCounter(int a) {
		return listaProdotti.get(a);
	}
	
	
	public void addPrice(double a) {prezzoTot += a;}
	
	public void refreshTot() {
		logger.info("Ricalcolo del prezzo totale del carrello...");
			int tot = 0;
			if(listaProdotti.size() == 0 ) {/*Eccezione*/}
		for(int i = 0; i < listaProdotti.size(); i++) {
			tot += listaProdotti.get(i).getPrezzo();
		}
		prezzoTot = tot;
		logger.info("Ricalcolo completato :)");
	}

	/**
	 * @return listaProdotti restituisce la lista prodotti del carrello
	 * */
	public ArrayList<ProductBean> getListaProdotti() {
		return listaProdotti;
	}

	/**
	 * @param listaProdotti listaProdotti del carrello
	 * */
	public void setListaProdotti(ArrayList<ProductBean> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	
	/**
	 * @return prezzoTot restituisce il prezzo totale del carrello
	 * */
	public double getPrezzoTot() {
		return prezzoTot;
	}

	
	/**
	 * @param prezzoTot prezzo totale del carrello
	 * */
	public void setPrezzoTot(double prezzoTot) {
		this.prezzoTot = prezzoTot;
	}
	
	
	
}
