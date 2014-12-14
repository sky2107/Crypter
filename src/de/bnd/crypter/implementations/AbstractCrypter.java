package de.bnd.crypter.implementations;

import java.util.ArrayList;
import java.util.List;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.exceptions.IllegalKeyException;
import de.bnd.crypter.interfaces.Crypter;

public abstract class AbstractCrypter implements Crypter {

	private final String key;

	public AbstractCrypter(String key) throws IllegalKeyException {
		if (isKeyValid(key))
			this.key = key;
		else
			throw new IllegalKeyException();
	}

	public abstract boolean isKeyValid(String key);

	public abstract String encrypt(String message) throws CrypterException;

	public abstract String decrypt(String cypherText) throws CrypterException;

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new ArrayList<String>();
		for (String s : messages) {
			result.add(encrypt(s));
		}
		return result;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		List<String> result = new ArrayList<String>();
		for (String s : cypherTexte) {
			result.add(decrypt(s));
		}
		return result;
	}

	public String getKey() {
		return key;
	}

}
