package de.bnd.crypter.demos;

import java.util.Arrays;
import java.util.List;

import de.bnd.crypter.factory.CrypterFactory;
import de.bnd.crypter.factory.CrypterFactory.CrypterType;
import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;
import de.bnd.crypter.factory.iterators.IterableCrypter;

public class IterableCrypterDemo {

	public static void main(String[] args) throws IllegalKeyException, CrypterException {

			Crypter caesar = CrypterFactory.createCrypter(CrypterType.CAESAR,
					"U");
			Crypter xor = CrypterFactory.createCrypter(CrypterType.XOR,
					"TPEISTCOOL");
			List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
			IterableCrypter iterableCrypter = new IterableCrypter(
					new IterableCrypter(liste, caesar), xor);
			for (String cypherText : iterableCrypter) {
				System.out.println(cypherText);
			}

	}

}
