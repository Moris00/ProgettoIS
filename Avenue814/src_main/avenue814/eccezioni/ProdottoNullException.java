package avenue814.eccezioni;

public class ProdottoNullException extends Exception{

	public ProdottoNullException() {
		super("Prodotto non valido");
	}
	
	public ProdottoNullException(String msg) {
		super(msg);
	}
}
