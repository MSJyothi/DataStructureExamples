package com.ds.binarysearchtree;

public class BinarySearchTree {

	private Node root;

	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public BinarySearchTree() {
		root = null;

	}

	public void insert(int item) {
		if (root == null) {
			root = new Node(item);
			return;
		} else {
			Node currentNode = root;
			while (true) {
				if (item < currentNode.value) {
					if (currentNode.left == null) {
						currentNode.left = new Node(item);
						break;
					}

					currentNode = currentNode.left;
				}

				else {
					if (currentNode.right == null) {
						currentNode.right = new Node(item);
						break;
					}
					currentNode = currentNode.right;
				}

			}

		}
	}

	public boolean delete(int item) {
		
		Node parent=null;
		
		if(root==null) {
			System.out.println("tree is empty");
			return false;
		}
		else {
		Node currentNode= root;
		while(currentNode!=null && item!=currentNode.value) {
			parent=currentNode;
			if(item<currentNode.value) {
				
				currentNode=currentNode.left;
			}
			else if(item > currentNode.value){
				currentNode=currentNode.right;
			}
		}
		if(currentNode==root) {
			root=null;
		}
		if(currentNode.left==null && currentNode.right==null) {
			if(parent.right==currentNode) {
				parent.right=null;
			}
			else {
			parent.left=null;
			}
			
		}
		
			
		return true;
		}

	}

	public boolean search(int item) {

		if (root == null) {
			System.out.println("tree is empty");
			return false;

		} else {
			Node currentNode = root;
			while (currentNode != null) {
				if (item == currentNode.value) {
					return true;
				} else if (item < currentNode.value) {

					currentNode = currentNode.left;
				} else {
					currentNode = currentNode.right;
				}
			}

		}
		return false;

	}

	public void preorder() {

		preorder(root);
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.value +",");
		preorder(node.left);
		preorder(node.right);

	}
	
	
	

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.value +",");
		inorder(node.right);

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + ",");

	}

	
	public static void main(String[] args) {
		
		BinarySearchTree binaryTree= new BinarySearchTree();
		binaryTree.insert(10);
		binaryTree.insert(12);
		binaryTree.insert(7);
		binaryTree.insert(5);
		binaryTree.insert(8);
		binaryTree.insert(15);
		
		System.out.println(binaryTree.search(7));
		System.out.println(binaryTree.search(18));
		binaryTree.preorder();
		System.out.println(" <- preorder");

		binaryTree.inorder();
		System.out.println(" <-  inorder");
		

		binaryTree.postorder();
		System.out.println(" <- postorder");
		
		binaryTree.delete(8);
		binaryTree.preorder();
		System.out.println(" <- preorder after deletion");
		
		}
		
}
