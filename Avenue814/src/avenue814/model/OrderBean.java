package avenue814.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Definisce l'entità Ordine
 * */
public class OrderBean{

	private CarrelloBean carrello;
	private int id_order; 
	private Date data;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String metodo_di_pagamento;
	
	/**
	 * @param carrello lista dei prodotti acquistati nel carrello dell'utente
	 * @param id_order id dell'ordine
	 * @param date data dell'ordine che è stata effettuato
	 * @param nome nome di chi ha effetuato l'ordine
	 * @param cognome cognome di chi ha effettualo l'ordine
	 * @param indirizzo destinazione dell'ordine
	 * @param telefono telefono di chi ha effettuato l'ordine
	 * @param metodo_di_pagamento metodo di pagamento utilizzato per effetuare l'ordine 
	 * 
	 * */
	
	public OrderBean(CarrelloBean carrello, int id_order, Date date, String nome, String cognome, String indirizzo, String telefono, String metodo_di_pagamento){
		this.carrello = carrello;
		this.id_order = id_order;
		this.data = (Date) data.clone();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	
	
	
	public void checkPagamento() {
		
		
		if(this.metodo_di_pagamento.equals("Contrassegno")) {
			carrello.addPrice(5.00);
		}else if(this.metodo_di_pagamento.equals("Visa") || this.metodo_di_pagamento.equals("Mastercard")){
			//Va bene, non ci sono costi aggiuntivi
		}else {
			/*Eccezione*/
		}
	}



	public CarrelloBean getCarrello() {
		return carrello;
	}



	public void setCarrello(CarrelloBean carrello) {
		this.carrello = carrello;
	}



	public int getId_order() {
		return id_order;
	}



	public void setId_order(int id_order) {
		this.id_order = id_order;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getMetodo_di_pagamento() {
		return metodo_di_pagamento;
	}



	public void setMetodo_di_pagamento(String metodo_di_pagamento) {
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	
	
	
	
}
