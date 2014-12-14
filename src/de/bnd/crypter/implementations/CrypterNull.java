package de.bnd.crypter.implementations;

import java.util.List;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.exceptions.IllegalKeyException;
import de.bnd.crypter.interfaces.Crypter;

public class CrypterNull extends AbstractCrypter {

	public CrypterNull() throws IllegalKeyException {
		super("");
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		return cypherTexte;
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
