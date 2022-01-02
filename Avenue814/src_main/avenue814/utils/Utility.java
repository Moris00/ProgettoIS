package avenue814.utils;

import java.util.Base64;

public class Utility {
	
	
	public static String encode(String stringa) { 
		byte[] encodeBytes = Base64.getEncoder().encode(stringa.getBytes());
		return new String(encodeBytes);
	}
	
	public static String decode(String stringa) {
		byte[] decodeBytes = Base64.getDecoder().decode(stringa.getBytes());
		return new String(decodeBytes);
	}
}
