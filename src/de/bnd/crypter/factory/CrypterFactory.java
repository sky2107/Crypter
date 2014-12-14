/**
 * 
 */
package de.bnd.crypter.factory;

import de.bnd.crypter.exceptions.IllegalKeyException;
import de.bnd.crypter.implementations.CaesarCrypter;
import de.bnd.crypter.interfaces.Crypter;

/**
 * @author user
 *
 */
public class CrypterFactory {

	/**
	 * Crypter types
	 */
	public enum CrypterType {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL
	}

	public static Crypter createCrypter(CrypterType type, String key) throws IllegalKeyException {

		if (!isKeyValid(key)) {
			throw new IllegalKeyException();
		}

		switch (type) {
		case CAESAR:
			return new CaesarCrypter(key.charAt(0));
		case SUBSTITUTION:
			// TODO
		case REVERSE:
			// TODO
		case XOR:
			// TODO
		case NULL:
			// TODO
		}

		return null;

	}

	private static boolean isKeyValid(String key) {
		// TODO
		return true;
	}

}
