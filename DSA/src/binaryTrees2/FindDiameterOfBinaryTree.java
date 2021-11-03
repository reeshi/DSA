/*For a given Binary of type integer, find and return the ‘Diameter’.
 * 
 * The diameter of a tree can be defined as the maximum distance between two leaf nodes.
   Here, the distance is measured in terms of the total number of nodes
   present along the path of the two leaf nodes, including both the leaves.
 * */
package binaryTrees2;

import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class FindDiameterOfBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
		
		System.out.println("Diameter is "+diameterOfBinaryTree(root).diameter);

	}
	
	// function to find a diameter of binary tree
    public static BinaryTreeReturn2 diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        if(root == null){
            BinaryTreeReturn2 ans = new BinaryTreeReturn2(0,0);
            return ans;
        }
        
        BinaryTreeReturn2 left = diameterOfBinaryTree(root.left);
        BinaryTreeReturn2 right = diameterOfBinaryTree(root.right);
        
        int diameter = left.height + right.height + 1;
        
        diameter = Math.max(diameter, Math.max(left.diameter, right.diameter));
        
        int height = 1 + Math.max(left.height, right.height);
        
        BinaryTreeReturn2 ans = new BinaryTreeReturn2(height, diameter);
        
        return ans;
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
