package Tree;
import java.util.Scanner;
import java.util.LinkedList;

class Node{
	int value;
	Node left;
	Node right;
}

public class BinarySearchTree {
	
	public void insertIntoBST(Node root,Node node) {
		if(root.value==-1) {
			System.out.println("inserting value in root node");
			root.value = node.value;
		}else if(node.value<=root.value) {
			System.out.println("left");
			if(root.left!=null) {
				insertIntoBST(root.left,node);
			}else {
				root.left = node;
			}			
		}else {
			System.out.println("right");
			if(root.right!=null) {
				insertIntoBST(root.right,node);
			}else {
				root.right = node;
			}
		}
	}
	
	public boolean searchBST(Node root,int value) {
		if(root.value == -1) {
			System.out.println("no element to search!");
			return false;
		}else if(root.value == value){
			System.out.println("found!");
			return true;			
		}else if(value<root.value) {
			System.out.println("going left");
			if(root.left!=null) {
				return searchBST(root.left,value);
			}else {
				return false;
			}
		}else {
			System.out.println("going right");
			if(root.right!=null) {
				return searchBST(root.right,value);
			}else {
				return false;
			}
		}
	}
	
	public int getMinValue(Node root) {
		if(root.value==-1) {
			return -1;
		}else {
			if(root.left!=null) {
				return getMinValue(root.left);
			}else {
				return root.value;
			}
		}
	}
	
	public int getMaxValue(Node root) {
		if(root.value==-1) {
			return -1;
		}else {
			if(root.right!=null) {
				return getMaxValue(root.right);
			}else {
				return root.value;
			}
		}
	}
	
	public int getHeight(Node root) {
		if(root.left==null && root.right==null) {
			if(root.value==-1) {
				return -2;
			}else {
				return -1;
			}
			
		}else {
			int leftHeight=0;
			int rightHeight=0;
			if(root.left!=null) {
				leftHeight = getHeight(root.left);
			}
			if(root.right!=null) {
				rightHeight = getHeight(root.right);
			}
			
			if(leftHeight > rightHeight) {
				return leftHeight+1;
			}else {
				return rightHeight+1;
			}
		}
	}
	
	public void showBfsTraversal(Node root) {
		
		if(root.value==-1) {
			System.out.println("Tree not created!");
		}else {
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node visited = queue.remove(0);
				System.out.print(visited.value + "\t");
				if(visited.left!=null) {
					queue.add(visited.left);
				}
				if(visited.right!=null) {
					queue.add(visited.right);
				}
				
			}
		}
		
	}
	
	public void postorderTraversal(Node root) {
		// TODO Auto-generated method stub
		if(root.value==-1) {
			System.out.println("Tree not created");
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.value + "\t");
			return;
		}else {
			
			if(root.left!=null) {
				preorderTraversal(root.left);
			}
			
			if(root.right!=null) {
				preorderTraversal(root.right);
			}
			System.out.print(root.value + "\t");
		}
	}

	public void inorderTraversal(Node root) {
		// TODO Auto-generated method stub
		if(root.value==-1) {
			System.out.println("Tree not created");
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.value + "\t");
			return;
		}else {
			
			if(root.left!=null) {
				preorderTraversal(root.left);
			}
			System.out.print(root.value + "\t");
			if(root.right!=null) {
				preorderTraversal(root.right);
			}
		}
	}

	public void preorderTraversal(Node root) {
		// TODO Auto-generated method stub
		if(root.value==-1) {
			System.out.println("Tree not created");
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.value + "\t");
			return;
		}else {
			System.out.print(root.value + "\t");
			if(root.left!=null) {
				preorderTraversal(root.left);
			}
			if(root.right!=null) {
				preorderTraversal(root.right);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree thisClass = new BinarySearchTree();
		int choice;
		Node root = new Node();
		root.left = null;
		root.right = null;
		root.value = -1;
		do {
			System.out.println("\nEnter 1. to insert value into Binary search tree.\nEnter 2. to delete a value from Binary search tree.\nEnter 3 to search a value from Binary search tree.");
			System.out.println("Enter 4. to get the minimum value from the tree.\nEnter 5. to get the minimum value from the tree.\nEnter 6. to find the height of the tree.");
			System.out.print("Enter 7. for breadth first trversal.\nEnter 8. for depth first traversal.\nEnter 9. to exit.\nEnter your choice: ");
			choice = scan.nextInt();
			System.out.println("You entered choice is " + choice);
			switch(choice) {
				case 1:{
					System.out.print("Enter the value to insert: ");
					int value = scan.nextInt();
					Node node = new Node();
					node.value = value;
					node.left = null;
					node.right = null;
					thisClass.insertIntoBST(root,node);
					System.out.println(value + " has been inserted into your tree.");
				}break;
				case 2:{
					System.out.println("Karwana baki hai !!!");
				}break;
				case 3:{
					System.out.print("Enter the value to search: ");
					int value = scan.nextInt();
					boolean found = thisClass.searchBST(root,value);
					if(!found) {
						System.out.println(value + " not found in your tree.");
					}else {
						System.out.println(value + " found in your tree.");
					}
				}break;
				case 4: {
					int minValue = thisClass.getMinValue(root);
					if(minValue==-1) {
						System.out.println("No element found in the tree");
					}else {
						System.out.println(minValue + " is the minimum value found in your tree.");
					}
				}break;
				case 5:{
					int maxValue = thisClass.getMaxValue(root);
					if(maxValue==-1) {
						System.out.println("No element found in the tree");
					}else {
						System.out.println(maxValue + " is the maximum value found in your tree.");
					}
				}break;
				case 6:{
					int height = thisClass.getHeight(root);
					if(height==-2) {
						System.out.println("Tree not created! Height of an empty tree is -1");
					}else if(height==-1){
						System.out.println("0 is the height of the tree.");
					}else {
						System.out.println(height + " is the height of the tree.");
					}
				}break;
				case 7:{
					thisClass.showBfsTraversal(root);
				}break;
				case 8:{
					System.out.println("\nWhat type of depth first search algo do you want to use ?");
					System.out.println("Enter 1. for preorder traversal.\nEnter 2. for inorder traversal.\nEnter 3. for postorder traversal.");
					System.out.print("Enter your choice: ");
					int type = scan.nextInt();
					switch(type) {
						case 1:{
							thisClass.preorderTraversal(root);
						}break;
						case 2:{
							thisClass.inorderTraversal(root);
						}break;
						case 3:{
							thisClass.postorderTraversal(root);
						}break;
						default:{
							System.out.println("You have not entered a proper choice. Please try again.");
						}
					}
				}break;
				case 9: break;
				default:{
					System.out.println("You have not entered a proper choice. Please try again.");
				}
			}
		}while(choice!=9);
		scan.close();
	}	

}
