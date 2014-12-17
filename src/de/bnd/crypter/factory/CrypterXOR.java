package de.bnd.crypter.factory;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;

class CrypterXOR extends AbstractCrypter {

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
		return encrypt(cypherText);
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
