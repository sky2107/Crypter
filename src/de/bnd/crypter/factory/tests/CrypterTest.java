package de.bnd.crypter.factory.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.bnd.crypter.factory.CrypterFactory;
import de.bnd.crypter.factory.CrypterFactory.CrypterType;
import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;

/**
 * 
 * Cryptertest
 * 
 * @author Adrian, Felix
 *
 */
public class CrypterTest {

	Crypter cae;
	Crypter nil;
	Crypter rev;
	Crypter sub;
	Crypter xor;

	@Before
	public void setUp() throws Exception {
		cae = CrypterFactory.createCrypter(CrypterType.CAESAR, "L");
		sub = CrypterFactory.createCrypter(CrypterType.SUBSTITUTION,
				"MNBVCXYLKJHGFDSAPOIUZTREWQ");
		rev = CrypterFactory.createCrypter(CrypterType.REVERSE, "");
		xor = CrypterFactory.createCrypter(CrypterType.XOR, "TPERULES");
		nil = CrypterFactory.createCrypter(CrypterType.NULL, "");
	}

	@Test
	public void testEncryptStringCaesar() throws CrypterException {
		testEncrypt(cae, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"LMNOPQRSTUVWXYZABCDEFGHIJK");
	}

	@Test
	public void testEncryptStringSubstitution() throws CrypterException {
		testEncrypt(sub, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"MNBVCXYLKJHGFDSAPOIUZTREWQ");
	}

	@Test
	public void testEncryptStringReverse() throws CrypterException {
		testEncrypt(rev, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"ZYXWVUTSRQPONMLKJIHGFEDCBA");
	}

	@Test
	public void testEncryptStringNull() throws CrypterException {
		testEncrypt(nil, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	@Test
	public void testEncryptStringXOR() throws CrypterException {
		testEncrypt(xor, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"URFVPJB[]ZN^XBJCEBVF@ZRKMJ");
	}

	@Test
	public void testDecryptStringCaesar() throws CrypterException {
		testDecrypt(cae, "LMNOPQRSTUVWXYZABCDEFGHIJK",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	@Test
	public void testDecryptStringSubstitution() throws CrypterException {
		testDecrypt(sub, "MNBVCXYLKJHGFDSAPOIUZTREWQ",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	@Test
	public void testDecryptStringReverse() throws CrypterException {
		testDecrypt(rev, "ZYXWVUTSRQPONMLKJIHGFEDCBA",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	@Test
	public void testDecryptStringNull() throws CrypterException {
		testDecrypt(nil, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	@Test
	public void testDecryptStringXOR() throws CrypterException {
		testDecrypt(xor, "URFVPJB[]ZN^XBJCEBVF@ZRKMJ",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	public void testDecrypt(Crypter c, String a, String b)
			throws CrypterException {
		assertEquals(c.decrypt(a), b);
	}

	public void testEncrypt(Crypter c, String a, String b)
			throws CrypterException {
		assertEquals(c.encrypt(a), b);
	}

	@Test
	public void testEncryptListOfString() throws CrypterException {
		List<String> in = new ArrayList<>();
		in.add("A");
		in.add("B");
		in.add("C");
		assertEquals(cae.encrypt(in).toString(), "[L, M, N]");
	}

	@Test
	public void testDecryptListOfString() throws CrypterException {
		List<String> in = new ArrayList<>();
		in.add("L");
		in.add("M");
		in.add("N");
		assertEquals(cae.decrypt(in).toString(), "[A, B, C]");
	}

}
