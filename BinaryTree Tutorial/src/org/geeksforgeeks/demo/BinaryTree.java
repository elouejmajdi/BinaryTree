package org.geeksforgeeks.demo;

public class BinaryTree {

	Node root;

	public BinaryTree(int value) {
		root = new Node(value);
	}

	public BinaryTree() {
		super();
	}
	
	static Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		} else {

			if (data <= node.value) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
			return node;

		}

	}
	
	static int minValue(Node node) {
		Node current = node ; 
		while(current.left!=null) {
			current= current.left; 
		}
		return current.value; 
		
	}
	
	static boolean ifNodeExists(Node node, int key) {
		if (node == null)
			return false;
		if (node.value == key)
			return true;
		
		boolean res = ifNodeExists(node.left, key);
		boolean res2 = ifNodeExists(node.right, key); 
		return res || res2 ; 

	}
	
	
	
	public static void main(String[] args) {

//		BinaryTree tree = new BinaryTree();
//
//		tree.root = new Node(1);
//
//		tree.root.left = new Node(2);
//		tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1 
               1 
             /   \ 
            2      3 
          /    \    /  \ 
        null null null null  */
  
  
//        tree.root.left.left = new Node(4); 
        
        /* 4 becomes left child of 2 
        1 
    /       \ 
   2          3 
 /   \       /  \ 
4    null  null  null 
/   \ 
null null 
*/
		
      
        
		
		
		
		
		BinaryTree tree = new BinaryTree(); 
        Node root = null; 
        root = tree.insert(root, 4); 
        tree.insert(root, 2); 
        tree.insert(root, 1); 
        tree.insert(root, 3); 
        tree.insert(root, 6); 
        tree.insert(root, 5); 
        Node root1 = root ; 
  
//        System.out.println("Minimum value of BST is " + minValue(root)); 
        
        System.out.println(ifNodeExists(root1, 6));
        
        
		
	}
	

}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

}