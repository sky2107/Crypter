package de.bnd.crypter.factory;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
/**
 * Reversecrypter
 * 
 * @author Adrian, Felix
 *
 */
class CrypterReverse extends AbstractCrypter {

	/**
	 * Konstruktor.
	 * @throws IllegalKeyException
	 */
	public CrypterReverse() throws IllegalKeyException {
		super("A");
	}

	@Override
	public String encryptStrategy(String message) throws CrypterException {
		return mirrorString(message);
	}

	@Override
	public String decryptStrategy(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}
	
	/**
	 * Spiegelt einen String
	 * @param s String
	 * @return gespiegelter String
	 */
	private String mirrorString(String s){
		StringBuilder b = new StringBuilder();
		b.append(s);
		b.reverse();
		return b.toString();
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
