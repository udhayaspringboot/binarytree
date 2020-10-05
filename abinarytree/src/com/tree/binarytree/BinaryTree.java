package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class BinaryTree {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {

			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	private Node root = null;

	void insert(Node node, int data) {

		// Node node = new Node(data);

		if (node.data == 0) {
			node.data = data;
			System.out.println("empty");
		} else {
			if (data < node.data) {
				if (node.left != null) {
					insert(node.left, data);
				} else {
					System.out.println("  Inserted " + data + " to left of Node " + node.data);
					node.left = new Node(data);
				}
			} else if (data > node.data) {
				if (node.right != null) {
					insert(node.right, data);
				} else {
					System.out.println("  Inserted " + data + " to right of Node " + node.data);
					node.right = new Node(data);
				}
			}
		}
	}

	void search(Node node, int data) {
		if (node != null) {
			System.out.println("Current node val is" + node.data);
			if (node.data == data) {
				System.out.println("value found");
			} else {
				if (node.data > data) {
					System.out.println("left val increases");
					search(node.left, data);

				} else {
					System.out.println("right val increases");
					search(node.right, data);

				}
			}

		}

	}

	void update(Node node, int olddata, int data) {
		if (node != null) {
			System.out.println("Current node val is" + node.data);
			if (node.data == olddata) {
				node.data = data;
				System.out.println("value updated");
			} else {
				if (node.data > olddata) {
					System.out.println("left val increases");
					update(node.left, olddata, data);

				} else {
					System.out.println("right val increases");
					update(node.right, olddata, data);

				}
			}

		}

	}

	void display(Node node) {
		// System.out.println("Values are ");
		if (node != null) {
			display(node.left);
			System.out.println(node.data);
			display(node.right);
		}
	}

	

	void deleteDeepest(Node root, Node delNode) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		Node temp = null;

// Do level order traversal until last node  
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp == delNode) {
				temp = null;
				return;

			}
			if (temp.right != null) {
				if (temp.right == delNode) {
					temp.right = null;
					return;
				} else
					q.add(temp.right);
			}

			if (temp.left != null) {
				if (temp.left == delNode) {
					temp.left = null;
					return;
				} else
					q.add(temp.left);
			}
		}
	}

//Function to delete given element  
//in binary tree 
	 void delete(Node root, int key) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			if (root.data == key)
				return;
			else
				return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null, keyNode = null;

// Do level order traversal until 
// we find key and last node.  
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.data == key)
				keyNode = temp;

			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}

		if (keyNode != null) {
			int x = temp.data;
			deleteDeepest(root, temp);
			keyNode.data = x;
		}
	}

	public static void main(String[] args) {

		BinaryTree bTree = new BinaryTree();

		Node rootnode = bTree.new Node(25);
		System.out.println("Building tree with root value " + rootnode.data);
		System.out.println("=================================");
		bTree.insert(rootnode, 11);
		bTree.insert(rootnode, 15);
		bTree.insert(rootnode, 50);
		bTree.insert(rootnode, 27);
		bTree.insert(rootnode, 79);
		System.out.println("values are ");
		bTree.display(rootnode);

		bTree.search(rootnode, 50);
		bTree.update(rootnode, 15, 10);
		bTree.display(rootnode);
		System.out.println("..........delete..........");
		bTree.delete(rootnode, 10);
		bTree.display(rootnode);
		
		 int choice=0;  
		 char ch = ' ';
		    Scanner sc = new Scanner(System.in);  
		    Node rootNode = null ;
		    //StackArrayImpl s = new StackArrayImpl();  
		    System.out.println("*********Binary Tree operations*********\n");  
		    System.out.println("\n------------------------------------------------\n");  
		    do
		    {  
		        System.out.println("\nChose one from the below options...\n");  
		        System.out.println("\n1.Insert\n2.Delete\n3.Show\n4.Update\n5.Search");  
		        System.out.println("\n Enter your choice \n");        
		        choice = sc.nextInt();  
		        switch(choice)  
		        {  
		            case 1:  
		            {   if(rootNode ==null)
		            {
		            	System.out.println("Enter the root element to insert");
		            	rootNode =  bTree.new Node(sc.nextInt()); break;
		            }else
		            {
		            	System.out.println("enter the element to insert");
		            	 bTree.insert(rootNode, sc.nextInt());   break;
		            }
		            	
		               
		                 
		            }  
		            case 2:  
		            {  
		            	System.out.println("Enter the element to delete ");
		                bTree.delete(rootNode, sc.nextInt());
		                break;  
		            }  
		            case 3:  
		            {  
		               bTree.display(rootNode);
		                break;  
		            }  
		            case 4:  
		            {  
		            	System.out.println("Enter old value and new value for updation ");
		               bTree.update(rootNode, sc.nextInt(), sc.nextInt()); bTree.display(rootNode);
		                break;  
		            }  
		            case 5:
		            {
		            	System.out.println("Enter the value to search ");
		            	bTree.search(rootNode, sc.nextInt());
		            }
		            default:  
		            {  
		                System.out.println("Please Enter valid choice ");  
		            }  
		        }
		            System.out.println("Do you want to continue ? (Y/N)");
					Scanner acb = new Scanner(System.in);
					ch = acb.next().charAt(0);
				
		    }while (ch == 'y' || ch == 'Y');
		        
		    
	
		

	}

}
