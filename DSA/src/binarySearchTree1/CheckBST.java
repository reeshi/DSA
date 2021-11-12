// Check the given binary tree is BST or not.
// return true if it is BST else return false.
package binarySearchTree1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class CheckBST {

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		
//		System.out.println(isBST(root));
		
//		System.out.println(isBSTBetter(root).isBST);
		
		System.out.println(isBSTBetter2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		

	}
	
	// this is solution is better than previous two solution.
	public static boolean isBSTBetter2(BinaryTreeNode<Integer> root, int minRange, int maxRange) {
		if(root == null) {
			return true;
		}
		
		if(root.data < minRange || root.data > maxRange) {
			return false;
		}
		
		boolean isLeftWithinRange = isBSTBetter2(root.left, minRange, root.data - 1);
		boolean isRightWithinRange = isBSTBetter2(root.right, root.data, maxRange);
		
		return isLeftWithinRange && isRightWithinRange;
	}
	
	// this is a better solution
	// time complexity is O(N).
	// it is returning three things in one call i.e min,max and isBST.
	public static IsBSTReturn isBSTBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		
		IsBSTReturn leftAns = isBSTBetter(root.left);
		IsBSTReturn rightAns = isBSTBetter(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		
		if(leftAns.max >= root.data || rightAns.min < root.data) {
			isBST = false;
		}
		
		if(!leftAns.isBST || !rightAns.isBST) {
			isBST = false;
		}
		
		IsBSTReturn ans = new IsBSTReturn(min, max, isBST);
		
		return ans;
	}
	
	// checks if a binary tree is BST or not.
	// if a given binary tree is balanced than time complexity is O(nlogn).
	// else o(n*n).
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		
		int leftMax = maximum(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		
		int rightMin = minimum(root.right);
		if(rightMin < root.data) {
			return false;
		}
		
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		
		return isLeftBST && isRightBST;
		
	}
	
	// find the maximum of tree.
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int leftMax = maximum(root.left);
		int rightMax = maximum(root.right);
		
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}
	
	// find the minimum of tree.
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		
		return Math.min(root.data, Math.min(leftMin, rightMin));
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the root");
		int rootData = sc.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		pendingChildren.add(root);
		
		while(!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChildren.poll();
			
			System.out.println("Enter the left child of " + front.data);
			int left = sc.nextInt();
			if(left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
				front.left = leftChild;
				pendingChildren.add(leftChild);
			}
			
			System.out.println("Enter the right child of " + front.data);
			int right = sc.nextInt();
			if(right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
				front.right = rightChild;
				pendingChildren.add(rightChild);
			}
		}
		
		return root;
	}

}
