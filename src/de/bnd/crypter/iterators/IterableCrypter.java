package de.bnd.crypter.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.interfaces.Crypter;

public class IterableCrypter implements Iterable<String> {

	private List<String> strings;

	public IterableCrypter(Iterable<String> iterable, Crypter crypter) throws CrypterException {
		strings = new ArrayList<String>();
		for (String s : iterable) {
			strings.add(crypter.encrypt(s));
		}
	}

	public Iterator<String> iterator() {
		return new CrypterIterator(strings.toArray(new String[0]));
	}

}
