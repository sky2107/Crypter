package de.bnd.crypter.factory;

import java.util.ArrayList;
import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;

/**
 * Abstrakte Crypterklasse
 * 
 * @author Adrian, Felix
 *
 */
abstract class AbstractCrypter implements Crypter {

	private final String key;

	/**
	 * Konstruktor.
	 * @param key Schlüssel
	 * @throws IllegalKeyException
	 */
	public AbstractCrypter(String key) throws IllegalKeyException {
		if (key != null && isKeyValid(key))
			this.key = key;
		else
			throw new IllegalKeyException();
	}

	/**
	 * Zeigt an ob ein Schlüssel gültig ist.
	 * @param key Schlüssel
	 * @return true, wenn gültig
	 */
	protected abstract boolean isKeyValid(String key);

	public String encrypt(String message) throws CrypterException {
		return encryptStrategy(validateMessage(message,
				getMessageReplaceRegexEncrypt()));
	}

	public String decrypt(String message) throws CrypterException {
		return decryptStrategy(validateMessage(message,
				getMessageReplaceRegexDecrypt()));
	}

	/**
	 * korrigiert eine Nachricht. Großschribung und Ersetzung.
	 * @param msg Nachricht
	 * @return Ersetzung
	 */
	private String validateMessage(String msg, String replace){
		
		String regex = replace;
		msg = msg.toUpperCase();
		msg = msg.replaceAll(regex, "");
		return msg;
		
	}

	/**
	 * Holt eine Ersetzungsvorschrift für das Veerschlüsseln
	 * @return Ersetzungsvorschrift als RegEx
	 */
	protected String getMessageReplaceRegexEncrypt() {
		return "[^A-Z]";
	}

	/**
	 * Holt eine Ersetzungsvorschrift für das Entschlüsseln
	 * @return Ersetzungsvorschrift als RegEx
	 */
	protected String getMessageReplaceRegexDecrypt() {
		return "[^A-Z]";
	}

	/**
	 * Die VerschlüsselungsStrategie
	 * @param message NAchricht
	 * @return verschlüsselte Nachricht
	 * @throws CrypterException
	 */
	protected abstract String encryptStrategy(String message)
			throws CrypterException;

	/**
	 * Die Entschlüsselungsstrategie
	 * @param cypherText Nachricht
	 * @return entschlüsselte Nachricht
	 * @throws CrypterException
	 */
	protected abstract String decryptStrategy(String cypherText)
			throws CrypterException;

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new ArrayList<String>();
		for (String s : messages) {
			result.add(encrypt(s));
		}
		return result;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> result = new ArrayList<String>();
		for (String s : cypherTexte) {
			result.add(decrypt(s));
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}

}
