/**
 * 
 */
package CrypterFactoryPackage;

import java.util.List;

import Exception.CrypterException;
import Interfaces.ICrypter;

/**
 * @author user
 *
 */
public abstract class CrypterFactory implements ICrypter {

	private String textWithCapitalLetters = "";

	/**
	 * @return the textWithCapitalLetters
	 */
	public String getTextWithCapitalLetters() {
		return textWithCapitalLetters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Interfaces.ICrypter#enteringText(java.lang.String)
	 */
	@Override
	public String setNewText(String message) {
		return enteringText(message);

	}

	private String enteringText(String message) {
		
		int firstCapitals = ( int )FIRSTLETTER;
		int lastCapitals = ( int )LASTLETTER;
		int first = ( int )SMALL_FIRSTLETTER;
		int last = ( int )SMALL_LASTLETTER;
		
		

		String newText = "";

		// maybe we can throw an exception
		if (message == "" || message == null) {
			return message;
		} else {

			// capital letters and small letters are transformed to capital
			// letters
			for (int index = 0; index < message.length(); index++) {
				char forTransforming = message.charAt(index);
				if (message.charAt(index) >= firstCapitals
						&& message.charAt(index) <= lastCapitals) {
					newText += message.charAt(index);
				} else if (message.charAt(index) >= first
						&& message.charAt(index) <= last) {
					forTransforming = (char) (message.charAt(index) - 32);
					newText += forTransforming;
				} else {
					// adding nothing
					newText += "";
				}

			}
		}

		return newText;
	}

}
