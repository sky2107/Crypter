package de.bnd.crypter.implementations;

import de.bnd.crypter.exceptions.CrypterException;

public class CrypterSubstitution extends AbstractCrypter {

	public CrypterSubstitution(String key) {
		super(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int pos = message.charAt(i) - 'A';
			s.append(getKey().charAt(pos));
		}
		return s.toString();
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < cypherText.length(); i++) {
			int pos = getKey().indexOf(cypherText.charAt(i));
			s.append((char)(pos + 'A'));
		}
		return s.toString();
	}

}
