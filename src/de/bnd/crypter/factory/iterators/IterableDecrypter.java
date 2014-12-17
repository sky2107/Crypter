package de.bnd.crypter.factory.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.interfaces.Crypter;
/**
 * class for handling List etc. with Iterators to create Strings decrypted
 * 
 * @author Adrian, Marcel und Felix
 *
 */
public class IterableDecrypter implements Iterable<String> {

	private List<String> strings;

	/**
	 * 
	 * @param iterable
	 * @param crypter
	 * @throws CrypterException
	 */
	public IterableDecrypter(Iterable<String> iterable, Crypter crypter) throws CrypterException {
		strings = new ArrayList<String>();
		for (String s : iterable) {
			strings.add(crypter.decrypt(s));
		}
	}

	/**
	 * 
	 */
	public Iterator<String> iterator() {
		return new CrypterIterator(strings.toArray(new String[0]));
	}

}
