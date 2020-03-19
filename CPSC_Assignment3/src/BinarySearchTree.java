
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
		 * Get's word 
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
			insert( s);
		}
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
	
	public void display() {
		System.out.println( "Total number of words: " + totalNum(root) );
		System.out.println( "Number of unique words: " + uniqWords(root) );
		//System.out.println(n.getWord() + " " + n.getFrequency());
		//System.out.println(n.getWord() + " " + n.getFrequency());
	}
	
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
	
	private int totalNum(Node n) {
		if( n != null) {
			int l = totalNum( n.getLeft());
			int r = totalNum( n.getRight());
			return l + r + 1;
		}
		return 0;
		
	}

}
