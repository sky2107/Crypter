package de.bnd.crypter.factory.iterators;

import java.util.Iterator;
/**
 * Crypteriterator. Ein ganz normaler Stringiterator, der für unseren Kontext umbenannt wurde
 * @author Adrian, Felix 
 *
 */
class CrypterIterator implements Iterator<String> {

	private int pos = 0;
	private String[] strings;

	/**
	 * Erstellt ene Instanz des Iterators.
	 * @param strings
	 */
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
