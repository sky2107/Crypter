package de.bnd.crypter.factory;

import java.util.ArrayList;
import java.util.List;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;

abstract class AbstractCrypter implements Crypter {

	private final String key;

	public AbstractCrypter(String key) throws IllegalKeyException {
		if (isKeyValid(key))
			this.key = key;
		else
			throw new IllegalKeyException();
	}

	protected abstract boolean isKeyValid(String key);
	
	public String encrypt(String message) throws CrypterException{
		return encryptStrategy(validateMessage(message));
	}
	
	public String decrypt(String message) throws CrypterException{
		return decryptStrategy(validateMessage(message));
	}
	
	private String validateMessage(String msg){
		
		String regex = getMessageValidationRegex();
		msg = msg.toUpperCase();
		msg = msg.replaceAll(regex, "");
		return msg;
		
	}
	
	protected String getMessageValidationRegex(){
		return "[^A-Z]";
	}

	protected abstract String encryptStrategy(String message) throws CrypterException;

	protected abstract String decryptStrategy(String cypherText) throws CrypterException;

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
