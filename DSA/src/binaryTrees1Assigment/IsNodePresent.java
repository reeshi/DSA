/*For a given Binary Tree of type integer and a number X,
 *find whether a node exists in the tree with data X or not
 * */
package binaryTrees1Assigment;

import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class IsNodePresent {

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
		
		System.out.println(isNodePresent(root, 4));

	}
	
	// find whether a node with data x is present or not.
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    if(root == null){
            return false;
        }
        
        if(root.data == x){
            return true;
        }
        
        boolean isLeftPresent = isNodePresent(root.left, x);
        boolean isRightPresent = isNodePresent(root.right, x);
        
        if(isLeftPresent || isRightPresent){
            return true;
        }else{
            return false;
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
