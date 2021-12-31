package avenue814.model;

/**
 * Definisce l'entit� Prodotto
 * 
 * */
public class ProductBean {

	private int id;
	private String nome;
	private double prezzo;
	private String descrizione;
	private String categoria;
	private int quantita;
	private String path_image;
	private String sesso;
	private boolean disponibilita;
	private int id_prop;
	
	/**
	 * @param id numero che identifica il prodotto
	 * @param nome nome del prodotto
	 * @param prezzo prezzo del prodotto
	 * @param descrizione descrizione dettagliata del prodotto
	 * @param categoria categoria del prodotto
	 * @param quantit� quantit� del prodotto
	 * @param path_image il percorso file per l'immagine del prodotto
	 * @param sesso sesso del prodotto
	 *
	 * */
	public ProductBean(int id, String nome, double prezzo, String descrizione, String categoria, int quantita, String path_image, String sesso, boolean disponibilita, int id_prop) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.quantita = quantita;
		this.path_image = path_image;
		this.sesso = sesso;
		this.disponibilita=disponibilita;
		this.id_prop = id_prop;
	}
	
	public ProductBean(String nome, double prezzo, String descrizione, String categoria, int quantita, String path_image, String sesso, boolean disponibilita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.quantita = quantita;
		this.path_image = path_image;
		this.sesso = sesso;
		this.disponibilita=disponibilita;
	}
	
	/**
	 * @return id restituisce id del prodotto
	 * 
	 * */
	public int getId() {
		return id;
	}

	public int getId_prop() {return id_prop;}
	public void setId_prop(int id_prop) {this.id_prop = id_prop;}
	
	/**
	 * @param id id del prodotto
	 * 
	 * */
	public void setId(int id) {
		this.id = id;
	}

	
	
	/**
	 * @return nome restituisce nome del prodotto
	 * */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome nome del prodotto
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * @return prezzo restituisce il prezzo del prodotto
	 * */
	public double getPrezzo() {
		return prezzo;
	}

	
	/**
	 * @param prezzo prezzo del prodotto
	 * */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return descrizione restituisce la descrizione del prodotto
	 * */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione descrizione del prodotto
	 * */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	/**
	 * @return categoria restituisce la categoria del prodotto
	 * */
	public String getCategoria() {
		return categoria;
	}

	
	/**
	 * @param categoria categoria del prodotto
	 * */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	/**
	 * @return quantita restituisce la quantita del prodotto
	 * */
	public int getQuantita() {
		return quantita;
	}

	
	/**
	 * @param quantita quantita del prodotto
	 * */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	
	/**
	 * @return path_image restituisce il percorso file dell'immagine del prodotto
	 * */
	public String getPath_image() {
		return path_image;
	}

	
	/**
	 * @param path_image percorso file dell'immagine del prodotto
	 * */
	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}

	
	/**
	 * @return sesso restituisce il sesso del prodotto
	 * */
	public String getSesso() {
		return sesso;
	}

	
	/**
	 * @param sesso sesso del prodotto
	 * */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	
	/**
	 * @return disponibilit� restituisce la disponibilit� del prodotto
	 * */
	public boolean isDisponabilita() {
		return disponibilita;
	}

	
	/**
	 * @param disponibilit� disponibilit� del prodotto
	 * */
	public void setDisponibilita(boolean disponabilita) {
		this.disponibilita = disponabilita;
	}
	
	
	
}
