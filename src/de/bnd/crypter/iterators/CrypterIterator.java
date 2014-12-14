package de.bnd.crypter.iterators;

import java.util.Iterator;

public class CrypterIterator implements Iterator<String> {

	private int pos = 0;
	private String[] strings;

	public CrypterIterator(String[] strings) {
		this.strings = strings;
	}

	public boolean hasNext() {
		return (pos < strings.length);
	}

	public String next() {
		return strings[pos++];
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
