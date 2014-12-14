package de.bnd.crypter.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.interfaces.Crypter;

public class CaesarCrypter implements Crypter {

	private final char key;

	public CaesarCrypter(char key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return convertString(message, (c) -> (encryptChar(c)));
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new ArrayList<String>();
		for (String s : messages) {
			result.add(encrypt(s));
		}
		return result;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return convertString(cypherText, (c) -> (decryptChar(c)));
	}

	@Override
	public List<String> decrypt(List<String> cypherText) throws CrypterException {
		List<String> result = new ArrayList<String>();
		for (String s : cypherText) {
			result.add(decrypt(s));
		}
		return result;
	}

	private char encryptChar(char x) {
		return convertChar(x, (val, k) -> (val + k));
	}

	private char decryptChar(char x) {
		return convertChar(x, (val, k) -> (val - k));
	}

	private char convertChar(char x, BiFunction<Integer, Integer, Integer> f) {
		int val = charToInt(x);
		int k = charToInt(key);
		int res = f.apply(val, k) < 0 ? 26 + f.apply(val, k) : f.apply(val, k) % 26;
		return intToChar(res);
	}

	private String convertString(String message, Function<Character, Character> f) throws CrypterException {

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			s.append(f.apply(message.charAt(i)));
		}

		return s.toString();

	}

	private char intToChar(int c) {
		return (char) (c + 'A');
	}

	private int charToInt(char c) {
		return c - 'A';
	}

}
