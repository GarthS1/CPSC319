/**
 * My implementation of a linked list with only necessary functions
 * @author garth.slaney 
 *
 */
public class LinkedList<T> {
	/**
	 * The head of the linked list.
	 */
	Node <T> head;
	/**
	 * The tail of the linked list.
	 */
	Node <T> tail;
	/**
	 * The size of the linked list.
	 */
	int size;
	/**
	 * Default constructor for the linked list.
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * Prints the linked list values. 
	 */
	public void print() {
		Node <T> temp = head; 
		while(temp != null) {
			System.out.print(temp + " ");
			temp = temp.getNextNode();
		}
		System.out.println(" ");
	}
	/**
	 * Inserts at the head of the linked list. 
	 * @param v The value to be inserted. 
	 */
	public void insertHead(T v) {
		Node <T> node = new Node<T>(v, null);
		if(head == null && tail == null) {
			head = tail = node;
		}
		else {
			node.setNextNode(head);
			head = node;
		}
		size++;
	}
	/**
	 * Inserts at the tail of the linked list
	 * @param v The value to be inserted 
	 */
	public void insertTail(T v) {
		Node<T> node = new Node<T>(v,null);
		if(head == null && tail == null) {
			head = tail = node;
		}
		else {
			tail.nextNode = node;
			tail = node;
		}
	}
}