package de.bnd.crypter.implementations;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.exceptions.IllegalKeyException;

public class CrypterXOR extends AbstractCrypter {
	;

	public CrypterXOR(String key) throws IllegalKeyException {
		super(key);
	}
	
	private char mapInt(int i) {
		int res;
		switch (i) {
		case 0:
			res = '@';
			break;
		case 27:
			res = '[';
			break;
		case 28:
			res = '\\';
			break;
		case 29:
			res = ']';
			break;
		case 30:
			res = '^';
			break;
		case 31:
			res = '_';
			break;
		default:
			res = i + 'A' - 1;
			break;
		}
		return (char) res;
	}

	private int mapChar(char c) {
		int res;
		switch (c) {
		case '@':
			res = 0;
			break;
		case '[':
			res = 27;
			break;
		case '\\':
			res = 28;
			break;
		case ']':
			res = 29;
			break;
		case '^':
			res = 30;
			break;
		case '_':
			res = 31;
			break;
		default:
			res = c - 'A' + 1;
			break;
		}
		return res;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = mapChar(message.charAt(i));
			int k = mapChar(getKey().charAt(i % getKey().length()));
			int v = m ^ k;
			s.append(mapInt(v));
		}
		return s.toString();
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < cypherText.length(); i++) {
			int c = mapChar(cypherText.charAt(i));
			int k = mapChar(getKey().charAt(i % getKey().length()));
			int v = c ^ k;
			s.append(mapInt(v));
		}

		return s.toString();
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
