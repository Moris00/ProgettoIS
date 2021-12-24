package avenue814.model;

/**
 * Questa classe rappresenta l'entita' Utente.
 */
public class UserBean{

	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String password;
	private int numero_ordini;
	private CarrelloBean carrello;
	private String ruolo;
	
	
	/**
	 * @param id numero identificativo dell'utente
	 * @param nome nome dell'utente
	 * @param cognome cognome dell'utente
	 * @param username soprannome dell'utente
	 * @param email email dell'utente
	 * @param password password dell'utente
	 * @param ruolo ruolo di lavoro dell'utente
	 * 
	 * */
	public UserBean(int id, String nome, String cognome, String username, String email, String password, String ruolo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.password = password;
		this.numero_ordini = 0;
		this.ruolo = ruolo;
		this.carrello = new CarrelloBean();
	}
	
	public UserBean() {
		
	}
	

	/**
	 * @return carrello restituisce il carrello dell'utente
	 * */
	public CarrelloBean getCarrello() {
		return carrello;
	}


	/**
	 * @param carrello carrello dell'utente
	 * */
	public void setCarrello(CarrelloBean carrello) {
		this.carrello = carrello;
	}



	/**
	 * @return id id dell'utente
	 * 
	 * */
	
	public int getId() {
		return id;
	}
	
	/**
	 * @param id id dell'utente
	 * 
	 * */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return nome nome dell'utente
	 * 
	 * */

	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome nome dell'utente
	 * 
	 * */

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return cognome cognome dell'utente
	 * 
	 * */

	public String getCognome() {
		return cognome;
	}
	
	/**
	 * @param cognome cognome dell'utente
	 * 
	 * */

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * @return username username dell'utente
	 * 
	 * */

	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username username dell'utente
	 * 
	 * */

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return email email dell'utente
	 * 
	 * */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email email dell'utente
	 * 
	 * */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return password password dell'utente
	 * 
	 * */

	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password password dell'utente
	 * 
	 * */

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return numero_ordini numero di ordini effettuati dall'utente
	 * 
	 * */

	public int getNumero_ordini() {
		return numero_ordini;
	}
	
	/**
	 * @param numero_ordini numero di oridni effettuati dall'utente
	 * 
	 * */

	public void setNumero_ordini(int numero_ordini) {
		this.numero_ordini = numero_ordini;
	}
	
	/**
	 * @return ruolo ruolo dell'utente
	 * 
	 * */

	public String getRuolo() {
		return ruolo;
	}

	/**
	 * @param ruolo ruolo dell'utente
	 * 
	 * */
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
}
