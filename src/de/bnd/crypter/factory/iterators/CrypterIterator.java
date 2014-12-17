package de.bnd.crypter.factory.iterators;

import java.util.Iterator;
/**
 * Crypter Iterator with actually only 2 methods working
 * for handling Lists for examples
 * 
 * @author Adrian, Marcel und Felix
 *
 */
class CrypterIterator implements Iterator<String> {

	private int pos = 0;
	private String[] strings;

	/**
	 * 
	 * @param strings
	 */
	public CrypterIterator(String[] strings) {
		this.strings = strings;
	}

	/**
	 * 
	 */
	public boolean hasNext() {
		return (pos < strings.length);
	}

	/**
	 * 
	 */
	public String next() {
		return strings[pos++];
	}

	/**
	 * 
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
