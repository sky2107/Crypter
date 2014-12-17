package de.bnd.crypter.factory;

import java.util.function.BiFunction;
import java.util.function.Function;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
/**
 * Caesar crypter
 * 
 * @author Adrian, Felix
 *
 */
class CrypterCaesar extends AbstractCrypter {

	/**
	 * Konstruktor
	 * @param key Schl�ssel
	 * @throws IllegalKeyException
	 */
	public CrypterCaesar(String key) throws IllegalKeyException {
		super(key);
	}

	@Override
	public String encryptStrategy(String message) throws CrypterException {
		return convertString(message, (c) -> (encryptChar(c)));
	}

	@Override
	public String decryptStrategy(String cypherText) throws CrypterException {
		return convertString(cypherText, (c) -> (decryptChar(c)));
	}

	/**
	 * Verschl�sselt einen einzelnen Char
	 * @param x Char
	 * @return verschl�sselter Char
	 */
	private char encryptChar(char x) {
		return convertChar(x, (val, k) -> (val + k));
	}

	/**
	 * Entschl�sselt einen einzelnen Char
	 * @param x Char
	 * @return entschl�sselter Char
	 */
	private char decryptChar(char x) {
		return convertChar(x, (val, k) -> (val - k));
	}

	/**
	 *  konvertiert einen Char (verschiebt ihn)
	 * @param x char
	 * @param f Verschiebungsfunktion
	 * @return verschobener Char
	 */
	private char convertChar(char x, BiFunction<Integer, Integer, Integer> f) {
		int val = charToInt(x);
		int k = charToInt(getKey().charAt(0));
		int res = f.apply(val, k) < 0 ? 26 + f.apply(val, k) : f.apply(val, k) % 26;
		return intToChar(res);
	}

	/**
	 * konvertiert einen String (verschiebt ihn)
	 * @param message String
	 * @param f Verschiebungsfunktion
	 * @return verschobener String
	 * @throws CrypterException
	 */
	private String convertString(String message, Function<Character, Character> f) throws CrypterException {

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			s.append(f.apply(message.charAt(i)));
		}

		return s.toString();

	}

	/**
	 * int to char wobei A = 0
	 * @param c int
	 * @return char
	 */
	private char intToChar(int c) {
		return (char) (c + 'A');
	}

	/**
	 * char to int wobei A = 0
	 * @param c char
	 * @return int
	 */
	private int charToInt(char c) {
		return c - 'A';
	}

	@Override
	public boolean isKeyValid(String key) {
		return key.length()==1&&key.matches("^[A-Z]+$");
	}

}
