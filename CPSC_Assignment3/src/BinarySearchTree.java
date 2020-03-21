import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTree {
  /**
   * Class used to store the words in the tree 
   * @author Garth
   *
   */
	protected class Node {
		/**
		 * The word to be stored 
		 */
		String word;
		/**
		 * How many times the word appears in the file 
		 */
		int frequency;
		/** 
		 * The left child of the node
		 */
		Node left_child; 
		/**
		 * The right child of the node
		 */
		Node right_child;
		/**
		 * The default constructor of Node
		 * @param word The word the constructor holds 
		 */
		public Node( String word) {
			this.word = word;
			frequency = 1;
			left_child = null;
			right_child = null;
		}
		/**
		 * Gets word 
		 * @return word of the node 
		 */
		public String getWord() {
			return word;
		}
		/**
		 * Gets frequency 
		 * @return how many times the word appears 
		 */
		public int getFrequency() {
			return frequency;
		}
		/**
		 * Increments the frequency of the word 
		 */
		public void increaseFreq() {
			frequency++;
		}
		/**
		 * Set the left node
		 * @param left The left child 
		 */
		public void setLeft( Node left) {
			left_child = left;
		}
		/**
		 * Set the right node 
		 * @param right The right child
		 */
		public void setRight( Node right) {
			right_child = right;
		}
		/**
		 * Gets the left child 
		 * @return Left child 
		 */
		public Node getLeft() {
			return left_child;
		}
		/** 
		 * Gets the right child 
		 * @return Right child 
		 */
		public Node getRight() {
			return right_child;
		}
		@Override
		public String toString() {
			return getWord();
		}
	}
	/**
	 * The root of the tree which all other words are sorted too
	 */
	Node root; 
	/**
	 * Makes the search tree from a String array  
	 * @param words
	 */
	public BinarySearchTree( String[] words) {
		for( String s: words) {
			insert(s);
		}
	}
	/**
	 * Returns the root of the tree
	 * @return Root of the tree
	 */
	public Node getRoot() {
		return root;
	}
	/**
	 * Inserts the data properly into the binary tree 
	 * @param s The data to be inserted into the tree 
	 */
	public void insert( String s) {
		root = add( root, s);
	}
	/**
	 * Compares the value of each of the nodes to find where the proper insertion spot is 
	 * @param ref The node acting as a reference 
	 * @param s The data to be inserted 
	 * @return The node either new or past
	 */
	public Node add( Node ref, String s) {
		if( ref == null) {
			return new Node(s);
		}
		else if ( ref.getWord().compareTo(s) > 0) {
			ref.setLeft( add( ref.getLeft(), s) );
		}
		else if ( ref.getWord().compareTo(s) < 0) {
			ref.setRight( add( ref.getRight(), s) );
		}
		else {
			ref.increaseFreq(); // must match otherwise
			return ref;
		}
		return ref; // return just the node 
	}
	/**
	 * Displays the information of the tree 
	 * @param fileName 
	 */
	public void displayOutput(String fileName) {
		System.out.println( "Total number of words in " + fileName + " : " + totalNum(root) );
		System.out.println( "Number of unique words in " + fileName + " : " + uniqWords(root) );
		System.out.println( "The word(s) which occur(s) most often and the number of times that it/they occur(s)");
		ArrayList<Node> list = new ArrayList<Node>();
		mostWords(root, list);
		for( Node n: list) 
			System.out.println(n.getWord() + " = " + n.getFrequency() + " times");
		System.out.println("The maximum height of the tree = " + findMaxHeight(root));
	}
	/**
	 * Finds the max height of the tree 
	 * @param n The node currently at 
	 * @return The height currently at 
	 */
	private int findMaxHeight(Node n) {
		if (n == null )
			return 0;
		else {
			int l = findMaxHeight(n.getLeft());
			int r = findMaxHeight(n.getRight());
			if( l > r)
				return l + 1; 
			return r + 1;
		}
	}
	/**
	 * Finds the words that occurs most in the list using pre-order
	 * @param n The node currently at 
	 * @param list The list to keep track of all words that occur the most
	 */
	private void mostWords(Node n, ArrayList<Node> list) {
		if(n != null) {
			if ( list.isEmpty() ) {
				list.add(n);
			}
			else if(list.get(0).getFrequency() < n.getFrequency() ) {
				list.clear();
				list.add(n);
			}
			else if(list.get(0).getFrequency() == n.getFrequency() ) {
				list.add(n);
			}
		 mostWords( n.getLeft(), list);
		 mostWords( n.getRight(), list);
		}
	}
	/**
	 * Counts the number of unique words using in-order 
	 * @param n The node to search through 
	 * @return The number of unique words 
	 */
	private int uniqWords(Node n) {
		if( n != null ) {
			int num = 0;
			num += uniqWords( n.getLeft());
			if( n.getFrequency() == 1) {
				num++;
			}
			num += uniqWords( n.getRight());
			return num;
		}
		return 0;
	}
	/**
	 * Counts the total number of words using post-fix
	 * @param n The node 
	 * @return The total number of words
	 */
	private int totalNum(Node n) {
		if(n != null) {
			int l = totalNum( n.getLeft());
			int r = totalNum( n.getRight());
			return l + r + 1;
		}
		return 0;
	}
	/** 
	 * Runs the user interface for entering which word to look for and calls the search method to print the frequency if it exists or prints that it doesn't 
	 * @param scan The scanner for reading user input 
	 * @param fileName 
	 */
	public void lookUp(Scanner scan, String fileName) {
		System.out.println("Enter the word you are looking for in " + fileName + " : ");
		String word = scan.next();
		int freq = search(word, root);
		if( freq == 0) {
			System.out.println("Word not found!");
		}
		else {
			System.out.println("Found! It appears " + freq + " times in the input text file");
		}
	}
	/**
	 * Searches for a word in the tree 
	 * @param word The word looking for 
	 * @param n Current reference node 
	 * @return The frequency of the word 
	 */
	private int search(String word, Node n) {
		int freq = 0;
		if( n == null)
			return 0;
		if ( n.getWord().compareTo(word) > 0) {
			freq = search( word, n.getLeft());
		}
		else if ( n.getWord().compareTo(word) < 0) {
			freq = search( word, n.getRight());
		}
		else if( n.getWord().compareTo(word) == 0) {
			freq = n.getFrequency();
		}
		return freq;
	}
	
	public void inOrder(Node n) {
		if(n != null) {
			inOrder(n.getLeft());
			System.out.print(n.getWord() + " ");
			inOrder( n.getRight());
		}
	}
	public void preOrder(Node n) {
		if(n != null) {
			System.out.print(n.getWord() + " ");
			preOrder( n.getLeft());
			preOrder( n.getRight());
		}
	}
	public void postOrder(Node n) {
		if(n != null) {
			postOrder(n.getLeft());
			postOrder( n.getRight());
			System.out.print(n.getWord() + " ");
		}
	}
}
