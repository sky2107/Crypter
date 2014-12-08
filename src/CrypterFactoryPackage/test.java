package CrypterFactoryPackage;

import java.io.ObjectInputStream.GetField;

import Exception.CrypterException;

public class test {

	public static void main(String[] args) {
		String message = "Caesar";

		int firstCapitals = (int) 'A';
		int lastCapitals = (int) 'Z';
		int first = (int) 'a';
		int last = (int) 'z';

		String newText = "";

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
		System.out.println(newText);

	}

}
