package de.bnd.crypter.implementations;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.exceptions.IllegalKeyException;

public class CrypterReverse extends AbstractCrypter {

	public CrypterReverse() throws IllegalKeyException {
		super("");
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return mirrorString(message);
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}
	
	private String mirrorString(String s){
		StringBuilder b = new StringBuilder();
		b.append(s);
		b.reverse();
		return b.toString();
	}

	@Override
	public boolean isKeyValid(String key) {
		return true;
	}

}
