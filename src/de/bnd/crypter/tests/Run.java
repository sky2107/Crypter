package de.bnd.crypter.tests;

import java.util.Arrays;
import java.util.List;

import de.bnd.crypter.exceptions.CrypterException;
import de.bnd.crypter.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.CrypterFactory;
import de.bnd.crypter.factory.CrypterFactory.CrypterType;
import de.bnd.crypter.interfaces.Crypter;
import de.bnd.crypter.iterators.IterableCrypter;

public class Run {

	public static void main(String[] args) {

		try {
			
			Crypter xor = CrypterFactory.createCrypter(CrypterType.XOR, "IAMTHEONEWHOKNOCKS");
			String msg = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";	
			System.out.println(msg);
			System.out.println("xor-decrypt with: IAMTHEONEWHOKNOCKS");
			msg = xor.decrypt(msg);
			System.out.println(msg+"\n");
			
			Crypter reverse = CrypterFactory.createCrypter(CrypterType.REVERSE);
			System.out.println(msg);
			System.out.println("reverse-decrypt");
			msg = reverse.decrypt(msg);
			System.out.println(msg+"\n");
			
			Crypter caesar = CrypterFactory.createCrypter(CrypterType.CAESAR, "L");
			System.out.println(msg);
			System.out.println("caesar-decrypt with: L");
			msg = caesar.decrypt(msg);
			System.out.println(msg+"\n");
			
			Crypter sub = CrypterFactory.createCrypter(CrypterType.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ");
			System.out.println(msg);
			System.out.println("sub-decrypt with: MNBVCXYLKJHGFDSAPOIUZTREWQ");
			msg = sub.decrypt(msg);
			System.out.println(msg+"\n");
			
			

		} catch (IllegalKeyException e) {
			e.printStackTrace();
		} catch (CrypterException e) {
			e.printStackTrace();
		}

	}

}
