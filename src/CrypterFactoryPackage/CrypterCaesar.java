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

	private String encryptMessage;

	/**
	 * the decoded message
	 * 
	 * @return encryptMessage
	 */
	public String getEncryptMessage() {
		return encryptMessage;
	}

	/**
	 * decoding Caesar system
	 */
	@Override
	public String encrypt(String message) throws CrypterException {

		this.encryptMessage = caesarEncrypt(setNewText(message));

		return encryptMessage;

	}

	private String caesarEncrypt(String message) {

		String secretMessage = "";
		int grenzeTest = 0;

		for (int index = 0; index < message.length(); index++) {
			grenzeTest = message.charAt(index) + getKey();
			if (grenzeTest <= 90) {
				secretMessage += (char) (grenzeTest);
			} else {
				secretMessage += (char) (grenzeTest - 26);
			}
		}

		return secretMessage;
	}

	private String decryptMessage;

	/**
	 * Original message
	 * 
	 * @return decryptMessage
	 */
	public String getDecryptMessage() {
		return decryptMessage;
	}

	/**
	 * finally to get the original message
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {

		if (cypherText == getEncryptMessage()) {
			return caesarDecrypt(getEncryptMessage());
		}

		return caesarDecrypt(cypherText);
	}

	private String caesarDecrypt(String message) {

		message = getEncryptMessage();
		String originalMessage = "";
		int grenzeTest = 0;

		for (int index = 0; index < message.length(); index++) {
			grenzeTest = message.charAt(index) - getKey();

			originalMessage += (char) (grenzeTest);

		}

		return originalMessage;
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
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

}
