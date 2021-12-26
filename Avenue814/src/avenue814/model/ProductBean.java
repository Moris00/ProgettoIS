package avenue814.model;

/**
 * Definisce l'entità Prodotto
 * 
 * */
public class ProductBean {

	private int id;
	private String nome;
	private double prezzo;
	private String descrizione;
	private String categoria;
	private int quantità;
	private String path_image;
	private String sesso;
	private boolean disponabilità;
	
	/**
	 * @param id numero che identifica il prodotto
	 * @param nome nome del prodotto
	 * @param prezzo prezzo del prodotto
	 * @param descrizione descrizione dettagliata del prodotto
	 * @param categoria categoria del prodotto
	 * @param quantità quantità del prodotto
	 * @param path_image il percorso file per l'immagine del prodotto
	 * @param sesso sesso del prodotto
	 *
	 * */
	public ProductBean(int id, String nome, double prezzo, String descrizione, String categoria, int quantità, String path_image, String sesso, boolean disponibilità) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.quantità = quantità;
		this.path_image = path_image;
		this.sesso = sesso;
		this.disponabilità=disponibilità;
	}
	
	public ProductBean(String nome, double prezzo, String descrizione, String categoria, int quantità, String path_image, String sesso, boolean disponibilità) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.quantità = quantità;
		this.path_image = path_image;
		this.sesso = sesso;
		this.disponabilità=disponibilità;
	}
	
	/**
	 * @return id restituisce id del prodotto
	 * 
	 * */
	public int getId() {
		return id;
	}

	
	
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
	 * @return quantità restituisce la quantità del prodotto
	 * */
	public int getQuantità() {
		return quantità;
	}

	
	/**
	 * @param quantità quantità del prodotto
	 * */
	public void setQuantità(int quantità) {
		this.quantità = quantità;
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
	 * @return disponibilità restituisce la disponibilità del prodotto
	 * */
	public boolean isDisponabilità() {
		return disponabilità;
	}

	
	/**
	 * @param disponibilità disponibilità del prodotto
	 * */
	public void setDisponabilità(boolean disponabilità) {
		this.disponabilità = disponabilità;
	}
	
	
	
}
