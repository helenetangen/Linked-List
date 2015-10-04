package linkedlist;


public class LinkedList {

	
	public class Node {
		private int id;
		private Node next;
		private Node previous;
		
		public Node(int id){
			this.id = id;
			this.next = null;
			this.previous = null;
		}
		
		public Node(int id, Node next, Node prevous){
			this.id = id;
			this.next = next;
			this.previous = prevous;
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
		
		public Node getPrevious(){
			return this.previous;
		}
		
		public void setPrevious(Node newPrevious){
			this.previous = newPrevious;
		}
	}
	
	
}
