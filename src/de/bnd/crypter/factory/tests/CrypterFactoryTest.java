package de.bnd.crypter.factory.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.bnd.crypter.factory.CrypterFactory;
import de.bnd.crypter.factory.CrypterFactory.CrypterType;
import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;

/**
 * Crypterfactorytest
 * @author Adrian, Felix
 *
 */
public class CrypterFactoryTest {

	Crypter cae;
	Crypter nil;
	Crypter rev;
	Crypter sub;
	Crypter xor;

	@Test
	public void testCreateCrypter() {

		try {
			cae = CrypterFactory.createCrypter(CrypterType.CAESAR, "L");
			sub = CrypterFactory.createCrypter(CrypterType.SUBSTITUTION,
					"MNBVCXYLKJHGFDSAPOIUZTREWQ");
			rev = CrypterFactory.createCrypter(CrypterType.REVERSE, "");
			xor = CrypterFactory.createCrypter(CrypterType.XOR, "TPERULES");
			nil = CrypterFactory.createCrypter(CrypterType.NULL, "");

		} catch (Exception e) {
			fail("No Exception expected!");
		}

	}

	@Test
	public void testForIllegalKeyException() throws CrypterException {

		try {
			cae = CrypterFactory.createCrypter(CrypterType.CAESAR, "LA");
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}
		
		try {
			cae = CrypterFactory.createCrypter(CrypterType.CAESAR, "");
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}
		
		try {
			cae = CrypterFactory.createCrypter(CrypterType.CAESAR, "@");
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}
		
		try {
			cae = CrypterFactory.createCrypter(CrypterType.CAESAR, null);
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}
		
		try {
			sub = CrypterFactory.createCrypter(CrypterType.SUBSTITUTION,
					"MNBVCXYLKJHGFDSAPOIUZTREWQAAAAAAAAAAAAA");
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}
		
		try {
			sub = CrypterFactory.createCrypter(CrypterType.SUBSTITUTION,
					"MN");
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}
		
		try {
			xor = CrypterFactory.createCrypter(CrypterType.XOR, "TPERULES*");
			fail("IllegalKeyException expected!");
		} catch (IllegalKeyException e) {
		}

	}

}
