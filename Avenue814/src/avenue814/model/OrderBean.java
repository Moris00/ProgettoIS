package avenue814.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Definisce l'entita Ordine
 * */
public class OrderBean{

	private int id_prodotto;
	private int id_order; 
	private int id_user;
	private String data;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String metodo_di_pagamento;
	
	/**
	 * 
	 * @param id_order id dell'ordine
	 * @param date data dell'ordine che è stata effettuato
	 * @param nome nome di chi ha effetuato l'ordine
	 * @param cognome cognome di chi ha effettualo l'ordine
	 * @param indirizzo destinazione dell'ordine
	 * @param telefono telefono di chi ha effettuato l'ordine
	 * @param metodo_di_pagamento metodo di pagamento utilizzato per effetuare l'ordine 
	 * 
	 * */
	
	public OrderBean(int id_prodotto,int id_order, String date, String nome, String cognome, String indirizzo, String telefono, String metodo_di_pagamento){
		this.id_prodotto = id_prodotto;
		this.id_order = id_order;
		this.data = date;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	
	public OrderBean(int id_prodotto, String date,int id_utente, String nome, String cognome, String indirizzo, String telefono, String metodo_di_pagamento){
		this.id_prodotto = id_prodotto;
		this.id_user = id_utente;
		this.data = date;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	
	/**
	 *  @return id_prodotto restituisce l'id del prodotto
	 * */
	public int getId_prodotto() {
		return id_prodotto;
	}

	/**
	 * @param id_prodotto id del prodotto
	 * */
	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	/**
	 * @return id dell'user
	 * 
	 * */
	 
	public int getId_user() {
		return id_user;
	}

	/**
	 * @param id_user id dell'user
	 * 
	 * */
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	/**
	 * @param id_prodotto id del prodotto
	 * @param data dell'ordine
	 * @param nome nome dell'utente che ha effettuato l'ordine
	 * @param cognome cognome dell'utente che ha effettuato l'ordine
	 * @param indirizzo indirizzo dell'utente che ha effettuato l'ordine
	 * @param telefono numero di telefono inserito durante l'invio dell'ordine
	 * @param metodo_di_pagamento metodo utiizzato per il pagamento dell'ordine
	 * */
	public OrderBean(int id_prodotto, String date, String nome, String cognome, String indirizzo, String telefono, String metodo_di_pagamento){
		this.id_prodotto = id_prodotto;
		this.data = date;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	

	/**
	 * @return id dell'ordine
	 * */
	public int getId_order() {
		return id_order;
	}


	/**
	 * @param id_order id dell'ordine
	 * */
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}



	/**
	 * @return data in cui è stato effettuato l'ordine
	 * */
	public String getData() {
		return data;
	}



	/**
	 * @param data data in cui è stato effettuato l'cquisto
	 * */
	public void setData(String data) {
		this.data = data;
	}



	/**
	 * @return nome dell'user che ha effettuato l'ordine
	 * */
	public String getNome() {
		return nome;
	}



	/**
	 * @param nome nome dell'user che ha effettuato l'ordine
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}



	/**
	 * @return cognome dell'user che ha effettuato l'ordine
	 * */
	public String getCognome() {
		return cognome;
	}



	/**
	 * @param cognome cognome dell'user che ha effettuato l'ordine 
	 * */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	/**
	 * @return indirizzo destinazione dell'ordine
	 * */
	public String getIndirizzo() {
		return indirizzo;
	}



	/**
	 * @param indirizzo dstinazione dell'ordine
	 * */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	/**
	 * @return nuemro di telefono dell'user che ha effettuato l'ordine
	 * */
	public String getTelefono() {
		return telefono;
	}



	/**
	 * @param telefono numero di telefono dell'user che effettuato l'ordine
	 * */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	/**
	 * @return  metodo utilizzato per il pagamento dell'ordine
	 * */
	public String getMetodo_di_pagamento() {
		return metodo_di_pagamento;
	}



	/**
	 * @param metodo_di_pagamento metodo utilizzato per il pagamento dell'ordine
	 * */
	public void setMetodo_di_pagamento(String metodo_di_pagamento) {
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	
	
	
	
}
