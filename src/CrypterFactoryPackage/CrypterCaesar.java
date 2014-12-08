/**
 * 
 */
package CrypterFactoryPackage;

import java.util.List;

import Exception.CrypterException;

/**
 * Caesar de and encoding System via KEY movement with the A-Z
 * 
 * @author Adrian, Marcel and Felix
 *
 */
public class CrypterCaesar extends CrypterFactory {

	private int keyCode;
	private String key;

	public CrypterCaesar(String key) {

		//this.keyCode = Konstanten.CAESAR.getStartingPoint((int) key.charAt(0));
		
		this.keyCode= ( int ) key.charAt(0) - Konstanten.CAESAR.getFIRST_LETTER()+1;

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

	/**
	 * decrypted message
	 */
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
		
		this.decryptMessage= originalMessage;

		return originalMessage;
	}

	/**
	 * to get the encrypted List
	 */
	private List<String> encryptListe;

	public List<String> getEncryptListe() {
		return encryptListe;
	};

	/**
	 * various Messages encrypted via util List
	 */
	@SuppressWarnings("null")
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {

		List<String> encryptListe = null;

		if (messages.isEmpty()) {
			return null;
		}
		for (int index = 0; index <= messages.lastIndexOf(messages); index++) {
			encryptListe.add(index, encrypt(setNewText(messages.get(index))));
		}

		this.encryptListe = encryptListe;

		return encryptListe;
	}

	/**
	 * getting the original List
	 */
	private List<String> originalList;

	public List<String> getOriginalList() {
		return originalList;
	};

	/**
	 * Original List
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> encryptListe = null;

		if (cypherTexte.isEmpty()) {
			return null;
		}
		for (int index = 0; index <= cypherTexte.lastIndexOf(cypherTexte); index++) {
			encryptListe
					.add(index, decrypt(setNewText(cypherTexte.get(index))));
		}

		this.originalList = encryptListe;

		return encryptListe;

	}

}
