package com.baeldung.demo;

public class BinaryTree {
	Node root;

	public BinaryTree() {

	}
	public BinaryTree(int value) {
		this.root = new Node(value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null)
			return new Node(value);
		else {
			if (current.value > value)
				return addRecursive(current.left, value);
			else if(current.value < value)
				return addRecursive(current.right, value);
			else 
				return current; 

		}

	}
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private static boolean containsNodeRecursive(Node current, int value) {
		if (current == null)
			return false;
		if (current.value == value)
			return true;

//		return containsNodeRecursive(current.left, value) || containsNodeRecursive(current.right, value);

		return value < current.value 
				? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);

	}
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
	
//	3.3. Deleting an Element
	
	private Node deleteRecursive(Node current, int value) {
		if(current==null) return null; 
		if(current.value==value) {
			if (current.left == null && current.right == null) {
			    return null;
			}
			if (current.right == null) {
			    return current.left;
			}
			 
			if (current.left == null) {
			    return current.right;
			}
		}
		if(value < current.value) {
			current.left = deleteRecursive(current.left, value); 
			return current;
		}
		current.right = deleteRecursive(current.right, value); 
		return current ;
		
	}
	
	private Node deleeRecurisive(int value) {
		return deleteRecursive(root, value); 
	}
	
	private int findSmallestValue(Node root) {
		
		return root.left==null ? root.value :findSmallestValue(root.left);
	}
	private int findSmallestValue() {
		return findSmallestValue(root); 
	}
	
	public void traverseInOrder(Node node) {

		if(node != null) {

			traverseInOrder(node.left);
			System.out.print(node.value + "  ");
			traverseInOrder(node.right);

		}
	}
	
	public void traverseInOrder() {
		traverseInOrder(root);
	}
	
	
	
	public static void main(String[] args) {
	
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(12); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(0);
//		System.out.println(tree.containsNode(2));
//		tree.traverseInOrder();
		System.out.println(tree.findSmallestValue());
		
	}
	
}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		super();
		this.value = value;
	}

}
