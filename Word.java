/**
 * Class word stores both the original string and the sorted string
 * @author garth.slaney
 *
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
	 * Default constructor for Word that generates sorted word
	 * @param word Original string used 
	 */
	public Word (String word) {
		this.setWord(word);
		setSortedWord(sort(word));
	}
	/**
	 * Elementary sort (selection sort) to make sortedWord
	 * @param word Word to be sorted
	 * @return sortedWord the word sorted 	
	 */
	private String sort(String word) {
		
		for(int i = 0; i < word.length(); i++) {
			char min = word.charAt(i);
			int j = i + 1;
			for (; j < word.length() - i; j++) {
				if( min < word.charAt(j)) {
					min = word.charAt(j);
				}
			 	char[] wordChars = word.toCharArray(); // convert to char array to change the one element of the array 
			 	wordChars[j] = min;
			 	word = String.valueOf(wordChars);
			}
		}
		return word;	
	}
	@Override
	public int compareTo(Word arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getSortedWord() {
		return sortedWord;
	}
	public void setSortedWord(String sortedWord) {
		this.sortedWord = sortedWord;
	}

}
