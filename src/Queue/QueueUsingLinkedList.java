package Queue;
import java.util.Scanner;

class Node{
	int value;
	Node next;
}

public class QueueUsingLinkedList {
	
	public void enqueue(Node front, Node rear,int value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = null;
		if(front.next==null && rear.next==null) {
			front.next = newNode;
			rear.next = newNode;
		}
		else {
			Node temp = rear.next;
			temp.next = newNode;
			temp = temp.next;
			rear.next = temp;
		}
	}
	
	public int dequeue(Node front, Node rear) {
		if(front.next==null) {
			return -1;
		}else {
			if(front.next==rear.next) {
				Node temp = front.next;
				front.next = null;
				rear.next = null;
				return temp.value;
			}else {
				Node temp = front.next;
				front.next = temp.next;
				temp.next = null;
				return temp.value;
			}
		}
	}
	
	public void printQueue(Node front, Node rear) {
		if(front.next==null && rear.next==null) {
			System.out.println("front -> null, rear -> null");
		}else {
			System.out.print("front <- ");
			Node temp = front;
			while(temp.next!=null) {
				temp = temp.next;
				System.out.print(temp.value + " <- ");
			}
			System.out.println("rear");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		QueueUsingLinkedList thisClass = new QueueUsingLinkedList();
		Node front = new Node();
		Node rear = new Node();
		front.next = null;
		rear.next = null;
		int choice;
		do {
			System.out.print("\nEnter 1. to Enqueue.\nEnter 2. to Dequeue.\nEnter 3. to print the queue.\nEnter 4. to exit.\nEnter your choice: ");
			choice = scan.nextInt();
			System.out.println("Your entered choice is " + choice);
			switch(choice) {
				case 1:{
					System.out.print("Enter a value to insert in a queue: ");
					int value = scan.nextInt();
					thisClass.enqueue(front,rear,value);
					System.out.println(value + " has been successfully add to your queue.");
				}break;
				case 2:{
					int value = thisClass.dequeue(front,rear);
					if(value==-1) {
						System.out.println("No element to remove.");
					}else {
						System.out.println(value + " has been successfully removed from your queue.");
					}
				}break;
				case 3:{
					thisClass.printQueue(front,rear);
				}break;
				case 4: break;
				default: {
					System.out.println("You have not entered a correct choice. Please try again.");
				}
			}
		}while(choice!=4);
		
	}

}
