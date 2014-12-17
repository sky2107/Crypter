package de.bnd.crypter.factory.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.interfaces.Crypter;

/**
 * Ein IterableCrypter, der auf eine über Strings iterierbare Struktur eine
 * Verschlüsselung anwendet. Das Ergebnis ist in diesem IterableCrypter
 * gespeichert.Diese Klasse selbst ist auch iterierbarr (über Strings).
 * 
 * @author Adrian, Felix 
 *
 */
public class IterableCrypter implements Iterable<String> {

	private List<String> strings;

	/**
	 * Erstellt eine Instanz.
	 * @param iterable Stringliste die Verschlüsselt werden soll.
	 * @param crypter Verschlüssler
	 * @throws CrypterException Probleme beim verschlüsseln
	 */
	public IterableCrypter(Iterable<String> iterable, Crypter crypter)
			throws CrypterException {
		strings = new ArrayList<String>();
		for (String s : iterable) {
			strings.add(crypter.encrypt(s));
		}
	}

	/**
	 * Gibt den Iterator auf dieser Menge zurück.
	 */
	public Iterator<String> iterator() {
		return new CrypterIterator(strings.toArray(new String[0]));
	}

}
