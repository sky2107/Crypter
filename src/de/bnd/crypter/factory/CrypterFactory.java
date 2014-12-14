/**
 * 
 */
package de.bnd.crypter.factory;

import de.bnd.crypter.exceptions.IllegalKeyException;
import de.bnd.crypter.implementations.CrypterCaesar;
import de.bnd.crypter.implementations.CrypterNull;
import de.bnd.crypter.implementations.CrypterReverse;
import de.bnd.crypter.implementations.CrypterSubstitution;
import de.bnd.crypter.implementations.CrypterXOR;
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
			return new CrypterCaesar(key.charAt(0));
		case SUBSTITUTION:
			return new CrypterSubstitution(key);
		case REVERSE:
			return new CrypterReverse();
		case XOR:
			return new CrypterXOR(key);
		case NULL:
			return new CrypterNull();
		}

		return null;

	}

	private static boolean isKeyValid(String key) {
		// TODO
		return true;
	}

}
