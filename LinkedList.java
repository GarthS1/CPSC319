/**
 * My implementation of a linked list 
 * @author garth.slaney 
 *
 */
public class LinkedList<T> {
	Node <T> head;
	Node <T> tail;
	int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public void print() {
		Node <T> temp = head; 
		while(temp != null) {
			System.out.println(temp);
			temp = temp.getNextNode();
		}
	}
	
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
}
