package avenue814.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Definisce l'entità Ordine
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
	
	public int getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public OrderBean(int id_prodotto, String date, String nome, String cognome, String indirizzo, String telefono, String metodo_di_pagamento){
		this.id_prodotto = id_prodotto;
		this.data = date;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.metodo_di_pagamento = metodo_di_pagamento;
	}
	
	


	public int getId_order() {
		return id_order;
	}



	public void setId_order(int id_order) {
		this.id_order = id_order;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
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
