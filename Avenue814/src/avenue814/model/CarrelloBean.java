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
	 * @param item prodotto che verrà aggiunto al carrello
	 * @throws ProdottoNullException 
	 * 
	 * */
	public void addProduct(ProductBean item) throws NullPointerException {
		logger.info("Aggiunta prodotto "+item.getNome()+" in corso...");
		
		listaProdotti.add(item);
		prezzoTot += item.getPrezzo();
		
		logger.info("Prodotto "+item.getNome()+" aggiunto al carrello");
	}
	
	/**
	 * @param item prodotto che verrà rimosso dal carrello
	 * */
	public void removeProduct(ProductBean item) throws NullPointerException {
		logger.info("Rimozione prodotto "+item.getNome()+" in corso...");
		
		int i = searchProductGetIndex(item);
		if(i < 0) {logger.info("Prodotto non trovato :(");}else {
			listaProdotti.remove(i);
			prezzoTot -= item.getPrezzo();
		
		logger.info("Prodotto "+item.getNome()+" eliminato dal carrello");
		}
		
	}
	
	/**
	 * @param item ricerca il prodotto nella lista
	 * @return l'indice del prodotto
	 * */
	public int searchProductGetIndex(ProductBean item) {
		for(int i = 0; i < listaProdotti.size(); i++) {
			if(listaProdotti.get(i).getId() == item.getId()) {
				return i;
			}
		}
		return -1;
	}
	

	
	/**
	 * Metodo che serve per calcolare il prodotto del carrello
	 * @param a il prezzo del prodotto che verrà sommato a quello del carrello
	 * */
	
	public void addPrice(double a) {prezzoTot += a;}
	
	public void refreshTot() {
		logger.info("Ricalcolo del prezzo totale del carrello...");
			double tot = 0;
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
