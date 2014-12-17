package de.bnd.crypter.factory;

import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;

/**
 * Nullcrypter
 * 
 * @author Adrian, Felix
 *
 */
class CrypterNull extends AbstractCrypter {

	/**
	 * Konstruktor
	 * 
	 * @throws IllegalKeyException
	 */
	public CrypterNull() throws IllegalKeyException {
		super("A");
	}

	@Override
	public String encryptStrategy(String message) throws CrypterException {
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		return messages;
	}

	@Override
	public String decryptStrategy(String cypherText) throws CrypterException {
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		return cypherTexte;
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
