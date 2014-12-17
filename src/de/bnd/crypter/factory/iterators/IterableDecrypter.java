package de.bnd.crypter.factory.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.interfaces.Crypter;
/**
 * Ein IterableCrypter, der auf eine �ber Strings iterierbare Struktur eine
 * Entschl�sselung anwendet. Das Ergebnis ist in diesem IterableCrypter
 * gespeichert.Diese Klasse selbst ist auch iterierbarr (�ber Strings).
 * 
 * @author Adrian, Felix 
 *
 */
public class IterableDecrypter implements Iterable<String> {

	private List<String> strings;

	/**
	 * Erstellt eine Instanz.
	 * @param iterable Stringliste die Verschl�sselt werden soll.
	 * @param crypter Verschl�ssler
	 * @throws CrypterException Probleme beim verschl�sseln
	 */
	public IterableDecrypter(Iterable<String> iterable, Crypter crypter) throws CrypterException {
		strings = new ArrayList<String>();
		for (String s : iterable) {
			strings.add(crypter.decrypt(s));
		}
	}

	/**
	 * Gibt den Iterator auf dieser Menge zur�ck.
	 */
	public Iterator<String> iterator() {
		return new CrypterIterator(strings.toArray(new String[0]));
	}

}
