/**
 * 
 */
package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CrypterFactoryPackage.CrypterCaesar;

/**
 * @author user
 *
 */
public class CaesarTest {

	CrypterCaesar test1;
	CrypterCaesar test2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		test1 = new CrypterCaesar("C");
		test2 = new CrypterCaesar("C");
		
		test1.encrypt("Caesa r");
		
		test2.encrypt("Ca esaR ");
		test2.decrypt(test2.getEncryptMessage());
		
	}

	@Test
	public void test() {
		assertEquals(test1.getKey(), 3);
		
		
		assertEquals(test2.getDecryptMessage(), "CAESAR");
	}

}
