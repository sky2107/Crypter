package de.bnd.crypter.factory.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.interfaces.Crypter;

public class IterableDecrypter implements Iterable<String> {

	private List<String> strings;

	public IterableDecrypter(Iterable<String> iterable, Crypter crypter) throws CrypterException {
		strings = new ArrayList<String>();
		for (String s : iterable) {
			strings.add(crypter.decrypt(s));
		}
	}

	public Iterator<String> iterator() {
		return new CrypterIterator(strings.toArray(new String[0]));
	}

}
