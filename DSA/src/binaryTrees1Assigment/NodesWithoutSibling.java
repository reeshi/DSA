/*For a given Binary Tree of type integer, print all the nodes without any siblings.
 * */
package binaryTrees1Assigment;

import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class NodesWithoutSibling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
		
		printNodesWithoutSibling(root);
	}
	
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root == null){
            return;
        }
        
        if(root.left != null && root.right != null){
            
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
            
        }else if(root.left != null){
            
            System.out.print(root.left.data + " ");
            printNodesWithoutSibling(root.left);
            
        }else if(root.right != null){
            
            System.out.print(root.right.data + " ");
            printNodesWithoutSibling(root.right);
            
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
	
}
