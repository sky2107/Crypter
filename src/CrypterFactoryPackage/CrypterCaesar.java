/**
 * 
 */
package CrypterFactoryPackage;

import java.util.List;

import Exception.CrypterException;

/**
 * @author user
 *
 */
public class CrypterCaesar extends CrypterFactory {

	private int keyCode;
	private String key;

	public CrypterCaesar(String message, String key) {

		setKey(key);
		;
		this.keyCode = (int) key.charAt(0);
		this.keyCode = Konstanten.CAESAR.getStartingPoint(getKey());

		setNewText(message);

	}

	/**
	 * 
	 * @param key
	 */
	private void setKey(String key) {

		// only Capital letters any other sign will automatically tur to A
		if (key.charAt(0) <= 65 || key.charAt(0) >= 90) {
			key = "A";
		}

		this.key = key;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return keyCode;
	}

	/**
	 * 
	 */
	@Override
	public String encrypt(String message) throws CrypterException {

		return caesarEncrypt(setNewText(message));

	}

	private String caesarEncrypt(String message) {

		String secretMessage = "";
		int grenzeTest = 0;

		for (int index = 0; index < message.length(); index++) {
			grenzeTest = message.charAt(index) + getKey();
			if (grenzeTest <= 90) {
				secretMessage += (char) (grenzeTest);
			}else{
				secretMessage += (char) (grenzeTest-26);
			}
		}

		return secretMessage;
	}

	/**
	 * 
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

}
