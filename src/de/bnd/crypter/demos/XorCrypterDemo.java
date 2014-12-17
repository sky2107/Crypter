package de.bnd.crypter.demos;

import de.bnd.crypter.factory.CrypterFactory;
import de.bnd.crypter.factory.CrypterFactory.CrypterType;
import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;

public class XorCrypterDemo {

	public static void main(String[] args) throws IllegalKeyException,
			CrypterException {

		Crypter xor = CrypterFactory.createCrypter(CrypterType.XOR,
				"TPERULES");

		String msg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(msg);
		msg = xor.encrypt(msg);
		System.out.println(msg);
		msg = xor.decrypt(msg);
		System.out.println(msg);

	}

}
