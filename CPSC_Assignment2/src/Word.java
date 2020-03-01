/**
 * Class word stores both the original string and the sorted string
 * @author garth.slaney
 */
public class Word implements Comparable<Word> {
	/**
	 * The original string inputed into the word
	 */
	private String word;
	/**
	 * The sorted string used to compare
	 */
	private String sortedWord;
	/**
	 * Constructor for Word that generates sorted word
	 * @param word Original string used 
	 */
	public Word (String word) {
		this.word = word;
		sortedWord = sort(word);
	}
	/**
	 * Elementary sort (selection sort) to make sortedWord
	 * @param word Word to be sorted
	 * @return sortedWord the word sorted 	
	 */
	private String sort(String word) {
		char[] wordChars = word.toCharArray(); // convert to char array to change the elements of the array 
		for(int i = word.length() - 1; i >= 0 ; i--) {
			char max = wordChars[i];
			int maxPos = i;
			int j = 0;
			for (; j < i ; j++) {
				if( max < wordChars[j]) {
					max = wordChars[j];
					maxPos = j;
				}
			}
		 	char temp = wordChars[i];
		 	wordChars[i] = max;
		 	wordChars[maxPos] = temp;
		}
	 	word = String.valueOf(wordChars);
		return word;	
	}
	
	@Override
	public int compareTo(Word arg0) {
		return getWord().compareTo(arg0.getWord());
	}
	/**
	 * Getter for String
	 * @return String of original word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Getter for sorted String 
	 * @return Sorted word 
	 */
	public String getSortedWord() {
		return sortedWord;
	}
	@Override
	public String toString() {
		return getWord();
	}
}