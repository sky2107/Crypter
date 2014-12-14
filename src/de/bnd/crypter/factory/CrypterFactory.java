/**
 * 
 */
package de.bnd.crypter.factory;

import de.bnd.crypter.exceptions.CrypterException;
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

	public static Crypter createCrypter(CrypterType type, String key) throws CrypterException, IllegalKeyException {

		switch (type) {
		case CAESAR:
			return new CrypterCaesar(key);
		case SUBSTITUTION:
			return new CrypterSubstitution(key);
		case REVERSE:
			return new CrypterReverse();
		case XOR:
			return new CrypterXOR(key);
		case NULL:
			return new CrypterNull();
		default:
			throw new CrypterException();
		}

	}

	public static Crypter createCrypter(CrypterType type) throws CrypterException, IllegalKeyException {

		switch (type) {
		case REVERSE:
		case NULL:
			return createCrypter(type, "");
		default:
			throw new CrypterException();
		}

	}

}
