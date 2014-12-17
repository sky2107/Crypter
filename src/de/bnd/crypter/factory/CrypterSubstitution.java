package de.bnd.crypter.factory;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
/**
 * Substituationscrypter
 * 
 * @author Adrian, Felix
 *
 */
class CrypterSubstitution extends AbstractCrypter {

	/**
	 * Konstruktor
	 * @param key Schlüssel
	 * @throws IllegalKeyException
	 */
	public CrypterSubstitution(String key) throws IllegalKeyException {
		super(key);
	}

	@Override
	public String encryptStrategy(String message) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int pos = message.charAt(i) - 'A';
			s.append(getKey().charAt(pos));
		}
		return s.toString();
	}

	@Override
	public String decryptStrategy(String cypherText) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < cypherText.length(); i++) {
			int pos = getKey().indexOf(cypherText.charAt(i));
			s.append((char)(pos + 'A'));
		}
		return s.toString();
	}

	@Override
	public boolean isKeyValid(String key) {
		return key.length()==26&&key.matches("^[A-Z]+$");
	}

}
