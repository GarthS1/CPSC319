  
import java.util.ArrayList;
import java.util.Scanner;
	
	public class CPSC319W20A2 {
		public static void main(String args[]) {
			ArrayList<Word> input = new ArrayList<Word>();
			addInput(input);
			// sort by n^2 sort
		}
	/**
	 * Adds the word from the file 
	 * @param input Arraylist of Words to be added too 
	 */
	public static void addInput (ArrayList<Word> input) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
      if (line.equals("")) {
        break;
      }
      input.add(new Word(line));
    }
	  scanner.close();
	}
	
	/*public static void quickSort <T extends Comparable>(ArrayList<T> list) {
		
	}*/
}
	
	//have a word object with comarable sortedWord impmentsd Comperable<Word> 
	//@overirde compareTo (word o)
	// getworrd.lower case to comparTo (stirng) tolowercase (ingnore and do sort word )
	// quciksort with 
	// soer with c	omparabel List<T> list publiv static <T extends Comparable> 