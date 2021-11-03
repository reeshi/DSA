package binaryTrees2;

import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class RemoveLeafNodes {

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
		
		root = removeLeavesNodes(root);
		
		printTreeDetailed(root);
		
	}
	
	// Remove the leaves node
	public static BinaryTreeNode<Integer> removeLeavesNodes(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		
		if(root.left == null && root.right == null) {
			return null;
		}
		
		root.left = removeLeavesNodes(root.left);
		root.right = removeLeavesNodes(root.right);
		
		return root;
	}
	
	// Better way to take input of tree
	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isleft){
		if(isRoot) {
			System.out.println("Enter root data");
		}else {
			if(isleft) {
				System.out.println("Enter the left child of " + parentData);
			}else {
				System.out.println("Enter the right child of " + parentData);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
		
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
	}
	
	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + ":");
		if(root.left != null) {
			System.out.print("L" + root.left.data + ", ");
		}
		
		if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		
		System.out.println();
		
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
		
	}
	
}
