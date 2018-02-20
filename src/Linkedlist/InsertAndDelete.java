package Linkedlist;
import java.util.Scanner;
class Node{
	int value;
	Node next;
	Node(){}
	Node(int value){
		this.value = value;
	}
}

public class InsertAndDelete {
	
	public void insertAtEnd(Node head,int value) {
		Node node = new Node();
		node.value = value;
		node.next = null;
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;		
	}
	
	public int deleteFromEnd(Node head) {
		if(head==null) {
			return -1;
		}else {
			Node temp1 = head.next;
			Node temp2 = head;
			while(temp1.next != null) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			temp2.next = null;
			return temp1.value;
		}
		
	}
	
	public void insertAtBegining(Node head,int value) {
		if(head==null) {
			insertAtEnd(head,value);			
		}else {
			Node temp = head.next;
			Node node = new Node();
			node.value = value;
			node.next = temp;
			head.next = node;
		}	
	}
	
	public int deleteFromBegining(Node head) {
		if(head.next==null) {
			return -1;
		}else {
			Node temp1 = head.next;
			if(temp1.next==null) {
				head.next = null;
				return temp1.value;
			}else {
				int val = temp1.value;
				temp1 = temp1.next;
				head.next = temp1;
				return val;
			}
		}	
	}
	
	public void insertAtPosition(Node head, int value, int position) {
		if(head.next==null) {
			insertAtBegining(head,value);
		}else {
			Node temp1 = head.next;
			Node temp2 = head;
			while(temp1.next!=null & position!=1) {
				position--;
				temp1 = temp1.next;
				temp2 = temp2.next;				
			}if(position>1) {
				System.out.println("Element can't be inserted at given position because there is no such position available so inserting at last position.");
				insertAtEnd(head,value);
			}else {
				Node node = new Node();
				node.value = value;
				node.next = temp1;
				temp2.next = node;
			}
		}
		
	}
	
	public boolean deleteFirstInstanceOf(Node head,int value) {
		if(head==null) {
			return false;
		}else {
		Node temp1 = head.next;
		Node temp2 = head;
		while(temp1.next!=null && temp1.value!=value) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp1.value == value) {
			if(temp1.next == null) {
				temp2.next = null;
			}else {
				temp1 = temp1.next;
				temp2.next = temp1;
			}
			return true;
		}else {
			return false;
		}
		}
	}

	public void reverseLL(Node head) {
		if(head.next==null) {
			System.out.println("No elements to reverse");
		}else {
			Node temp1 = head.next;
			Node temp2 = null;
			if(temp1.next!=null) {
				Node temp3 = temp1.next;
				while(temp1.next!=null) {
					temp1.next = temp2;
					temp2 = temp1;
					temp1 = temp3;
					temp3 = temp3.next;
				}
				temp1.next = temp2;
				head.next = temp1;
			}
			System.out.println("Reversed successfully");
		}
	}
	
	
	public void printLL(Node head) {
		System.out.print("head -> ");
		if(head==null) {
			System.out.print("null");
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
				System.out.print(temp.value + " -> ");
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		InsertAndDelete thisClass = new InsertAndDelete();
		Node head = new Node();
		int choice;
		do {
		System.out.print("\nEnter 1 to enter a value to the end of a linked List.\nEnter 2 to delete last element from the linked list.");
		System.out.print("\nEnter 3 to enter a value to the start of a linked List.\nEnter 4 to delete first element from the linked list.");
		System.out.print("\nEnter 5 to enter a value at any given postion in your linked list.\nEnter 6 to delete the first instance of any givent element from the linked list.");
		System.out.print("\nEnter 7 to reverse the linked list.\nEnter 8 to view the linked list.\nEnter 9 to exit.\nEnter your choice: ");
		choice = scan.nextInt();
		switch(choice) {
			case 1:{
				System.out.print("Your entered choice is 1.\nEnter the value of the element to be added: ");
				int value = scan.nextInt();
				thisClass.insertAtEnd(head,value);
				System.out.println(value + " has been entered successfully in your linked list.");
			}break;
			case 2:{
				System.out.println("Your entered choice is 2.");
				int value = thisClass.deleteFromEnd(head);
				if(value==-1) {
					System.out.println("No element found to delete in your linked list.");
				}else {
					System.out.println("Last element (" + value +") has been successfull deleted from your linked list.");
				}
			}break;
			case 3:{
				System.out.print("Your entered choice is 3.\nEnter the value of the element to be added: ");
				int value = scan.nextInt();
				thisClass.insertAtBegining(head,value);
				System.out.println(value + " has been entered successfully in your linked list.");
			}break;
			case 4:{
				System.out.println("Your entered choice is 4.");
				int value = thisClass.deleteFromBegining(head);
				if(value==-1) {
					System.out.println("No element found to delete in your linked list.");
				}else {
					System.out.println("First element (" + value +") has been successfull deleted from your linked list.");
				}				
			}break;
			case 5:{
				System.out.print("Your entered choice is 5.\nEnter the value of the element to be added: ");
				int value = scan.nextInt();
				System.out.print("Enter the position at which you want to insert the element: ");
				int position = scan.nextInt();
				thisClass.insertAtPosition(head,value,position);
				System.out.println(value + " has been entered successfully at position the given position in your linked list.");
			}break;
			case 6:{
				System.out.print("Your entered choice is 6.\nEnter the value of the element to be deleted: ");
				int value = scan.nextInt();
				boolean isDeleted = thisClass.deleteFirstInstanceOf(head,value);
				if(!isDeleted) {
					System.out.println("No element found such as "+ value + " to delete in your linked list.");
				}else {
					System.out.println("First instance of " + value +" has been successfull deleted from your linked list.");
				}
								
			}break;
			case 7:{
				System.out.println("Your entered choice is " + choice + ".");
				thisClass.reverseLL(head);
			}break;
			case 8:{
				System.out.println("Your entered choice is " + choice + ".Currently your linked list stands as: \n");
				thisClass.printLL(head);
			}break;
			case 9:{
				System.out.println("Your entered chioce is " + choice + ". Thank you for visiting :)");
			}break;
			default:{
				System.out.println("You have not entered a correct choice, please try again.");
			}
		}
		}while(choice!=9);
	}

	

}
