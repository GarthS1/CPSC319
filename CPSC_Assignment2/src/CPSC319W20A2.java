  
import java.util.*;
	
	public class CPSC319W20A2 {
		public static void main(String args[]) {
			ArrayList<Word> a = new ArrayList<Word>();
			addInput(a);
			quickSort(a);
			ArrayList<LinkedList<Word>> b = createList(a);
			for(LinkedList<Word> w : b) {
				w.print();
			}
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
	/**
	 * Quick sort the list to alphabetical order 
	 * @param <T> The object type to be sorted
	 * @param list The list to be sorted 
	 */
	public static void quickSort (ArrayList<Word> list) {
	
	}
	/**
	 * Creates an array of LinkedList from input
	 * @param input The sorted input
	 * @param output The array of LinkedList 
	 */
	private static ArrayList<LinkedList<Word>> createList(ArrayList<Word> input) {
		ArrayList<LinkedList<Word>> output = new ArrayList<LinkedList<Word>>();
		
		for(int i = 0; i < input.size(); i++) {
			if(input.get(i).getWord() != "") {
				LinkedList<Word> list = new LinkedList<Word>();
				list.insertHead(input.get(i));
				
				// traverse list looking for anagrams 
				for(int j = i + 1; j < input.size(); j++) {
					if(input.get(i).getSortedWord().equals(input.get(j).getSortedWord())) {
						list.insertTail(input.get(j));
						input.set(j, new Word("")); //set to a "null" word that can't be compared to 
					}
				}
				
				output.add(list);
			}
		}
		return output;
	}
}