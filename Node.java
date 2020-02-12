/**
 * Stores objects of type T 
 * @author garth.slaney
 * @version 1.0 
 * @param <T>
 */
public class Node<T> {
	/**
	 * Generic value to store in Node
	 */
	T value;
	/**
	 * Next node in the linked list
	 */
	Node <T> nextNode;
	/**
	 * Constructor with object of type T
	 * @param v value to be set to
	 * @param node Next node in linked list  
	 */
	public Node(T v, Node<T> node) {
		setValue(v);
		setNextNode(node);
	}
	/**
	 * Changes the value of the object stored
	 * @param v value to be change to
	 */
	public void setValue(T v) {
		value = v;
	}
	/**
	 * Returns value of T
	 * @return T
	 */
	public T getValue() {
		return value;
	}
	
	public void setNextNode(Node <T> nextNode) {
		this.nextNode = nextNode;
	}
	/**
	 * 
	 * @return
	 */
	public Node<T> getNextNode() {
		return nextNode;
	}
	
	/**
	 * Converts the object T into a string that can be printed 
	 */
	@Override
	public String toString() {
		String s;
		s = String.valueOf(value);
		return s;
	}
}
