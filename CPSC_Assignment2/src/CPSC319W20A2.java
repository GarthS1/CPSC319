  
import java.util.*;
	
	public class CPSC319W20A2 {
		public static void main(String args[]) {
			ArrayList<Word> a = new ArrayList<Word>();
			addInput(a);
			quickSort(a, 0, a.size() - 1);
			/*for(Word w : a) {
				System.out.println(w);
			}*/
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
	 * @param list The list to be sorted 
	 */
	public static void quickSort(ArrayList<Word> list, int low, int high) {
		int index;
		if(low < high) {	
			index = findParition(list, low, high);
			quickSort(list, low, index - 1);
			quickSort(list, index + 1, high);			
		}
	}
	
	private static int findParition(ArrayList<Word> list, int low, int high) {
		int index = (int)(Math.random() * (high - low) + low); // picks a random pivot
		swap(list, index, low);
		int too_big_index = low;
		int too_small_index = high;
		while(too_small_index > too_big_index) {
			while(list.get(too_big_index).compareTo(list.get(index)) <= 0 && too_big_index < too_small_index){
				too_big_index++;
			}
			while(list.get(too_small_index).compareTo(list.get(index)) > 0) {
				too_small_index--;	
			}
			if(too_big_index < too_small_index) {
				swap(list, too_big_index, too_small_index);
			}
		}
		swap(list, too_small_index, index); 
		return too_small_index;
	}
	/**
	 * Swaps the Words of the ArrayList
	 * @param list The list which is being swapped
	 * @param index1 The index of the first element
	 * @param index2 The index of the second element
	 */
	private static void swap(ArrayList<Word> list, int index1, int index2) {
		Word temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
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