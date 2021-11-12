package binarySearchTree2;

import binaryTrees1.BinaryTreeNode;

public class BST {
	private BinaryTreeNode<Integer> root;
	private int size;
	
	public void insert(int x) {
		root = insertHelper(root, x);
		size++;
	}
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x){
		if(node == null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
			return newRoot;
		}
		
		if(x >= node.data) {
			node.right = insertHelper(node.right, x);
		}else {
			node.left = insertHelper(node.left, x);
		}
		
		return node;
	}
	
	public boolean isPresent(int x) {
		return isPresentHelper(root, x);
	}
	
	private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
		if(node == null) {
			return false;
		}
		
		if(node.data == x) {
			return true;
		}else if(x > node.data) {
			return isPresentHelper(node.right, x);
		}else {
			return isPresentHelper(node.left, x);
		}
	}
	
	public boolean deleteData(int x) {
		DeleteDataReturn output = deleteDataHelper(root, x);
		root = output.root;
		if(output.Deleted) {
			size--;
		}
		
		return output.Deleted;
	}
	
	private static DeleteDataReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return new DeleteDataReturn(null, false);
		}
		
		if(x > root.data) {
			DeleteDataReturn outputRight = deleteDataHelper(root.right, x);
			root.right = outputRight.root;
			outputRight.root = root;
			return outputRight;
		}
		
		if(x < root.data) {
			DeleteDataReturn outputLeft = deleteDataHelper(root.left, x);
			root.left = outputLeft.root;
			outputLeft.root = root;
			return outputLeft;
		}
		
		//no children.
		if(root.left == null && root.right == null) {
			return new DeleteDataReturn(null, true);
		}
		
		// only left child.
		if(root.left != null && root.right == null) {
			return new DeleteDataReturn(root.left, true);
		}
		
		// only right child.
		if(root.left == null && root.right != null) {
			return new DeleteDataReturn(root.right, true);
		}
		
		// Both children are present.
		int rightMin = minimum(root.right);
		root.data = rightMin;
		DeleteDataReturn outputRight = deleteDataHelper(root.right, rightMin);
		root.right = outputRight.root;
		return new DeleteDataReturn(root, true);
	}
	
	private static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		int minLeft = minimum(root.left);
		int minRight = minimum(root.right);
		
		return Math.min(root.data, Math.min(minLeft, minRight));
	}
	
	public int size() {
		return size;
	}
	
	public void printTree() {
		printTreeHelper(root);
	}
	
	private static void printTreeHelper(BinaryTreeNode<Integer> node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + ":");
		if(node.left != null) {
			System.out.print("L" + node.left.data + ", ");
		}
		
		if(node.right != null) {
			System.out.print("R" + node.right.data);
		}
		
		System.out.println();
		
		printTreeHelper(node.left);
		printTreeHelper(node.right);
	}
	
}
