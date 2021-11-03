package binaryTrees1;

import java.util.Scanner;

public class BinaryTreeUse {

	public static void main(String[] args) {
		
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
//		
//		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
//		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
//		
//		root.left = rootLeft;
//		root.right = rootRight;
//		
//		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
//		BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
//		
//		rootLeft.right = twoRight;
//		rootRight.left = threeLeft;
		
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
		
////		printTree(root);
//		printTreeDetailed(root);
//		
//		System.out.println("Number of Nodes is " + numNodes(root));
		
//		preOrderTraversal(root);
//		System.out.println();
//		postOrderTraversal(root);
//		System.out.println();
//		inOrderTraversal(root);
		
		System.out.println("Largets " + largest(root));
		System.out.println("Height " + height(root));
		
		System.out.println("Leaf nodes " + numLeafNodes(root));
		
		printAtDepthK(root, 2);
		
	}
	
	// Print Nodes at depth k.
	// depth of nodes is defined as the how far a node is from root node.
	public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
		if(root == null) {
			return;
		}
		
		if(k == 0) {
			System.out.println(root.data);
		}
		
		printAtDepthK(root.left, k-1);
		printAtDepthK(root.right, k-1);
		
	}
	
	// Find the number of leaf nodes in Binary tree
	public static int numLeafNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		return numLeafNodes(root.left) + numLeafNodes(root.right);
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
	
	// Find the largest data in Binary tree.
	// return -1 if tree empty
	public static int largest(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return -1;
		}
		
		int largestLeft = largest(root.left);
		int largestRight = largest(root.right);
		
		return Math.max(root.data, Math.max(largestLeft, largestRight));
	}
	
	// print -> left , root, right
	public static void inOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		
		System.out.print(root.data + " ");
		
		inOrderTraversal(root.right);
	}
	
	// print -> left, right, root
	public static void postOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		
		System.out.print(root.data + " ");
	}
	
	//this is a pre-order traversal of tree
	// print -> root , left, right
	public static void preOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	// find the number of nodes in Binary tree
	public static int numNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int leftCount = numNodes(root.left);
		int rightCount = numNodes(root.right);
		
		return 1 + leftCount + rightCount;
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
	
	public static BinaryTreeNode<Integer> takeTreeInput(){
		System.out.println("Enter root data");
		
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		
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
