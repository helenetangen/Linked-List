package linkedlist;


public class LinkedList {
	
	
	public class Node {
		private int id;
		private Node next;
		
		public Node(int id){
			this.id = id;
			this.next = null;
		}
		
		public Node(int id, Node next){
			this.id = id;
			this.next = next;
		}
		
		public int getId(){
			return this.id;
		}
		
		public Node getNext(){
			return this.next;
		}
		
		public void setNext(Node newNext){
			this.next = newNext;
		}
	}
	
	
	private Node head;
	private Node tail;
	
	
	public LinkedList(){
		
	}
	
	
	public void addNode(Node node){
		if (head == null){
			head = node;
			tail = node;
		}
		else{
			tail.setNext(node);
			tail = node;
		}
	}
	
	
	public void removeNode(int id){
		current  = head;
		previous = null;
		
		while (current != null){
			if (current.getId() == id){
				if (current == head && current == tail){
					head = null;
					tail = null; 
				}
				else if (current == head){
					head = current.getNext();
				}
				else if (current == tail){
					tail = previous;
					previous.setNext(null);
				}
				else{
					previous.setNext(current.getNext());
				}
			}
			previous = current;
			current  = current.getNext();
		}
	}
	
	
}
