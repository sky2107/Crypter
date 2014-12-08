/**
 * 
 */
package CrypterFactoryPackage;

/**
 * 
 * 
 * 
 * @author user
 *
 */
public enum Konstanten {

	/**
	 * Decoding and encoding systems
	 */
	CAESAR(65,90), SUBSTITUTION(65,90), REVERSE(65,90), XOR(65,90), NULL(65,90);

	private final int FIRST_LETTER;
	private final int LAST_LETTER;

	private Konstanten(int firstLetter, int lastLetter) {
		this.FIRST_LETTER = firstLetter;
		this.LAST_LETTER = lastLetter;

	}

	/**
	 * Position of the first Letter A
	 * 
	 * @return the startingPoint
	 */
	public int getFIRST_LETTER() {
		return FIRST_LETTER;
	}

	/**
	 * indicates where to stop by Z
	 * 
	 * @return the barrier
	 */
	public int getLAST_LETTER() {
		return LAST_LETTER;
	}
	
	
	
	public int getStartingPoint(int key){
		
		//for the beginning 1 - 26 are allowed for the key
		if (key == 0 || key <65 || key >91){
			key = 1;
		}else{
			key= key - (getLAST_LETTER()-1) ;
		}
		
		final int STARTING_POINT = getFIRST_LETTER()+key;
		
		return STARTING_POINT;
	}
	
	

}
