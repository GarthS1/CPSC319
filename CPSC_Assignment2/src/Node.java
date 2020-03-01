/**
 * Stores objects of type T 
 * @author garth.slaney
 * @version 1.0 
 * @param <T> The object type in node 
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
	 * @return T The value of the node 
	 */
	public T getValue() {
		return value;
	}
	/**
	 * Sets the nextNode of the linked list
	 * @param nextNode The next node of the linked list
	 */
	public void setNextNode(Node <T> nextNode) {
		this.nextNode = nextNode;
	}
	/**
	 * Gets the next node
	 * @return The next node of the linked list
	 */
	public Node<T> getNextNode() {
		return nextNode;
	}
	
	@Override
	public String toString() {
		String s;
		s = String.valueOf(value);
		return s;
	}
}
