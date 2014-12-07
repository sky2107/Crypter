/**
 * 
 */
package Interfaces;

import java.util.List;

import Exception.CrypterException;

/**
 * GrundlegendesInterface,um Verschluesselung durchzufuehren. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschluesseln ( ueber die { @link#encrypt (
 * String) } Methode ) und wieder entschluesseln ( ueber die { @link#decrypt (
 * String) } Methode ).
 *
 * Der Eingabetext ({ @literal message }) darf nur aus den Gross - Buchstaben A
 * - Z bestehen. Kleinbuchstaben werden in Grossbuchstaben umgewandelt, alle
 * anderen Zeichen werden ohne Rueckmeldung entfernt ( einschliesslich der
 * Leerzeichen ). Zwischen den beiden Methoden muss bei gleichem Schluessel { @code
 * key }
 *
 * folgendes gelten: {@code text.equals(decrypt(encrypt(text))==true}.
 *
 *
 */
public interface ICrypter {

	/**
	 * barrier where the codes are in action
	 * 65 - 90 unicode reference
	 */
	public static final char FISRTLETTER = 'A';
	public static final char LASTLETTER = 'Z';
	public static final char SMALL_FISRTLETTER = 'a';
	public static final char SMALL_LASTLETTER = 'z';
	
	/**
	 * constant names for the decrypt and encrypt modes
	 */
	public static final String CAESAR = "CAESAR";
	public static final String SUBSTITUTION = "SUBSTITUTION";
	public static final String REVERSE = "REVERSE";
	public static final String XOR = "XOR";
	public static final String NULL = "NULL";

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param message
	 *            Nachricht, die Verschluesselt werden soll.
	 *
	 * @return verschlusselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public String encrypt(String message) throws CrypterException;

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param messages
	 *            Nachrichten, die Verschluesselt werden soll.
	 *
	 * @return verschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public List<String> encrypt(List<String> messages) throws CrypterException;

	/**
	 * Entschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param cypherText
	 *            Nachricht, die entschluesselt werden soll.
	 *
	 * @return entschluesselter Text.
	 * @throws CrypterException
	 *             Wird geworfen , wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public String decrypt(String cypherText) throws CrypterException;

	/**
	 * Entschlusselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param cypherTexte
	 *            Nachrichten, die entschluesselt werden soll.
	 *
	 * @return entschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException;

	/**
	 * only captal letters no other sign is possible Space or other signs will
	 * be removed lower case letters will be transformed into capital letters
	 * for example a into A
	 * 
	 * @param message
	 * @return text with only captal letters no other sign is possible
	 */
	public String setNewText(String message);

}
