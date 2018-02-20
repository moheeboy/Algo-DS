package Linkedlist;
import java.util.Scanner;

class Node1{
	int value;
	Node1 next;
	Node1 previous;
}

public class DoublyLinkList {
	
	public void insertAtEnd(Node1 head,int value) {
		Node1 node = new Node1();
		node.value = value;
		node.next = null;
		if(head.next==null) {
			head.next = node;
			node.previous = null;
		}else {
			Node1 temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
			node.previous = temp;
		}
	}
	
	public int deleteFromEnd(Node1 head) {
		if(head.next==null) {
			return -1;
		}else {
			Node1 temp1 = head.next;
			Node1 temp2 = head;
			while(temp1.next!=null) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			temp1.previous = null;
			temp2.next = null;
			return temp1.value;
		}
	}
	
	public void insertAtBegining(Node1 head,int value) {
		if(head.next==null) {
			insertAtEnd(head,value);
		}else {
			Node1 node = new Node1();
			node.value = value;
			node.previous = null;
			Node1 temp = head.next;
			node.next = temp;
			temp.previous = node;
			head.next = node;
		}
	}
	
	public int deleteFromBegining(Node1 head) {
		if(head.next==null) {
			return -1;
		}else {
			Node1 temp1 = head.next;
			if(temp1.next==null) {
				head.next = null;
				return temp1.value;
			}else {
				temp1 = temp1.next;
				Node1 temp2 = head.next;
				temp2.next = null;
				temp1.previous = null;
				head.next = temp1;
				return temp2.value;				
			}
		}
	}
	
	public void printDLL(Node1 head) {
		System.out.print("head -> ");
		if(head.next==null) {
			System.out.print("null");
		}else {
			Node1 temp = head;
			Node1 temp1 = head.next;
			while(temp1.next!=null) {
				temp = temp.next;
				temp1 = temp1.next;
				System.out.print(temp.value + " <=> ");
			}
			temp = temp.next;
			System.out.print(temp.value);
			System.out.println(" -> null");
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DoublyLinkList thisClass = new DoublyLinkList();
		Node1 head = new Node1();
		int choice;
		do {
			System.out.print("\nEnter 1 to enter a value to the end of a doubly linked List.\nEnter 2 to delete last element from the doubly linked list.");
			System.out.print("\nEnter 3 to enter a value to the start of a doubly linked List.\nEnter 4 to delete first element from the doubly linked list.");
			System.out.print("\nEnter 5 to view the linked list.\nEnter 6 to exit.\nEnter your choice: ");
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
				System.out.println("Your entered choice is " + choice + ".Currently your linked list stands as: \n");
				thisClass.printDLL(head);
			}break;
			case 6:{
				System.out.println("Your entered chioce is " + choice + ". Thank you for visiting :)");
			}break;
			default:{
				System.out.println("You have not entered a correct choice, please try again.");
			}
		}
		}while(choice!=6);
	}

}
