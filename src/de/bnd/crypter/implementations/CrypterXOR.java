package de.bnd.crypter.implementations;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.exceptions.IllegalKeyException;

public class CrypterXOR extends AbstractCrypter {

	public CrypterXOR(String key) throws IllegalKeyException {
		super(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = message.charAt(i) - 'A' + 1;
			int k = getKey().charAt(i % getKey().length()) - 'A' + 1;
			int v = m ^ k;
			s.append((char) (v + 'A' - 1));
		}
		return s.toString();
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < cypherText.length(); i++) {
			int c = cypherText.charAt(i) - 'A' + 1;
			int k = getKey().charAt(i % getKey().length()) - 'A' + 1;
			int v = c ^ k;
			s.append((char) (v + 'A' - 1));
		}

		return s.toString();
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
