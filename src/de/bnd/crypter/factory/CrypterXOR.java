package de.bnd.crypter.factory;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
/**
 * XOR crypter
 * 
 * @author Adrian, Felix
 *
 */
class CrypterXOR extends AbstractCrypter {


	private static final String[] map = { "@", "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_" };


	/**
	 * Konstruktor
	 * @param key Schlüssel
	 * @throws IllegalKeyException
	 */
	public CrypterXOR(String key) throws IllegalKeyException {
		super(key);
	}

	/**
	 * mapped int zu char
	 * @param i int
	 * @return char
	 */
	private char mapInt(int i) {
		return map[i].charAt(0);
	}

	/**
	 * mapped char zu int
	 * @param c char
	 * @return int
	 */
	private int mapChar(char c) {
		for (int i = 0; i < map.length; i++) {
			if (map[i].charAt(0) == c) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Entschlüsselt/Verschlüsselt einen Char
	 * @param value char
	 * @param key Schlüssel
	 * @return Entschlüsselter/Verschlüsselter Char
	 */
	private char encryptChar(char value, char key) {
		int v = mapChar(value);
		int k = mapChar(key);
		return mapInt(k ^ v);
	}

	@Override
	public String encryptStrategy(String message) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			s.append(encryptChar(message.charAt(i),
					getKey().charAt(i % getKey().length())));
		}
		return s.toString();
	}

	@Override
	public String decryptStrategy(String cypherText) throws CrypterException {
		return encryptStrategy(cypherText);
	}

	@Override
	public boolean isKeyValid(String key) {

		if (key.matches("^[A-Z]+$"))
			return true;
		else
			return false;
		
	}

	@Override
	protected String getMessageReplaceRegexDecrypt() {
		return "[^A-Z\\u0040\\u005B\\u005D\\u005E\\u005C\\u005F]";
	}
}
