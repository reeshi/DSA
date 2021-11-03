// given a binary tree . check it is balanced or not.
package binaryTrees2;

import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class CheckBalanced {

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
		
		System.out.println("Is Balanced " + isBalancedBetter(root).isBalanced);

	}
	
	// this a better approach for this problem.
	// it will perform O(n) in worst case.
	// In this approach we are asking two things from left and right subtree
	// height and whether it is balanced or not
	public static BinaryTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			BinaryTreeReturn ans = new BinaryTreeReturn(0, true);
			return ans;
		}
		
		BinaryTreeReturn left = isBalancedBetter(root.left);
		BinaryTreeReturn right = isBalancedBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(left.height, right.height);
		
		if(Math.abs(left.height - right.height) > 1) {
			isBal = false;
		}
		
		if(!left.isBalanced || !right.isBalanced) {
			isBal = false;
		}
		
		BinaryTreeReturn ans = new BinaryTreeReturn(height, isBal);
		
		return ans;
	}
	
	// Function for checking a tree is balanced or not.
	// in worst case it will perform O(n square).
	// but if input tree is perfect balanced than it will perform O(nlogn).
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		
		// calculate the height of left subtree.
		int leftHeight = height(root.left);
		// calculate the height of right subtree.
		int rightHeight = height(root.right);
		
		// if differance of height > 1 than it is not balanced.
		if(Math.abs(leftHeight-rightHeight) > 1) {
			return false;
		}
		
		boolean isLeft = isBalanced(root.left);
		boolean isRight = isBalanced(root.right);
		
		return isLeft && isRight;
	}
	
	// Height of binary tree
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null){
            return 0;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        if(leftHeight > rightHeight){
            return 1+leftHeight;
        }else{
            return 1+rightHeight; 
        }
        
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
