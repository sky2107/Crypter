package de.bnd.crypter.demos;

import de.bnd.crypter.factory.CrypterFactory;
import de.bnd.crypter.factory.CrypterFactory.CrypterType;
import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;


/**
 * Demo zum Entschlüsseln des Geheimtextes.
 * 
 * @author Adrian, Felix
 *
 */
public class DecryptSecretMessageDemo {

	public static void main(String[] args) throws IllegalKeyException,
			CrypterException {

		Crypter sub = CrypterFactory.createCrypter(CrypterType.SUBSTITUTION,
				"MNBVCXYLKJHGFDSAPOIUZTREWQ");
		Crypter cae = CrypterFactory.createCrypter(CrypterType.CAESAR, "L");
		Crypter rev = CrypterFactory.createCrypter(CrypterType.REVERSE, "");
		Crypter xor = CrypterFactory.createCrypter(CrypterType.XOR,
				"IAMTHEONEWHOKNOCKS");

		String msg = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		System.out.println("secret message -> " + msg);

		msg = xor.decrypt(msg);
		System.out.println("xor-decrypt with IAMTHEONEWHOKNOCKS -> " + msg);

		msg = rev.decrypt(msg);
		System.out.println("rev-decrypt -> " + msg);

		msg = cae.decrypt(msg);
		System.out.println("caesar-decrypt with L -> " + msg);

		msg = sub.decrypt(msg);
		System.out.println("sub-decrypt with MNBVCXYLKJHGFDSAPOIUZTREWQ -> "
				+ msg);

	}

}
