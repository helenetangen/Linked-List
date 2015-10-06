package linkedlist;


import java.util.HashMap;


public class LinkedList {
	
	
	public class Node {
		private int id;
		private Node next;
		
		public Node(int id){
			this.id = id;
			this.next = null;
		}
		
		public int getId(){
			return this.id;
		}
		
		public void setId(int newId){
			this.id = newId;
		}
		
		public Node getNext(){
			return this.next;
		}
		
		public void setNext(Node newNext){
			this.next = newNext;
		}
	}
	
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		
		//Test nodes
		Node nodeOne   = list.new Node(1);
		Node nodeTwo   = list.new Node(2);
		Node nodeThree = list.new Node(3);
		Node nodeFour  = list.new Node(1);
		Node nodeFive  = list.new Node(2);
		Node nodeSix   = list.new Node(1);
		
		//Add nodes
		list.addNode(nodeOne);
		list.addNode(nodeTwo);
		list.addNode(nodeThree);
		list.addNode(nodeFour);
		list.addNode(nodeFive);
		list.addNode(nodeSix);
		list.printLinkedList();
		
		//Remove duplicates
		list.removeDuplicatesWithoutBuffer();
		list.printLinkedList();
	}
	
	
	private Node head;
	private Node tail;
	
	
	public LinkedList(){
		head = null;
		tail = null;
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
		Node current  = head;
		Node previous = null;
		
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
	
	
	public void removeNode(Node node){
		if (node == head && node == tail){
			head = null;
			tail = null;
		}
		else if (node == head){
			head = node.getNext();
		}
		Node current  = head;
		Node previous = null;
		while (current != null){
			if (current == node){
				previous.setNext(current.getNext());
				if (current == tail){
					tail = previous;
				}
			}
			previous = current;
			current = current.getNext();
		}
	}
	
	
	public void removeDuplicates(){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Node current = head;
		while (current != null){
			if (map.containsKey(current.getId())){
				current = current.getNext();
				this.removeNode(current);
			}
			else{
				map.put(current.getId(), 1);
				current = current.getNext();
			}
			
		}
	}
	
	
		public void removeDuplicatesWithoutBuffer(){
		Node current = head;
		while (current != null){
			Node kid = current.getNext();
			while (kid != null){
				if (current.getId() == kid.getId()){
					Node next = kid.getNext();
					this.removeNode(kid);
					kid = next;
				}
				else{
					kid = kid.getNext();
				}
			}
			current = current.getNext();
		}
	}
	
	
	public void printLinkedList(){
		Node current = head;
		System.out.println("------------");
		System.out.println("Linked List:");
		while (current != null){
			System.out.println(current.getId());
			current = current.getNext();
		}
		System.out.println("------------");
	}
	
	
}
