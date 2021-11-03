/*Given a BST and an integer k.
 *Find if the integer k is present in given BST or not.
 *You have to return true, if node with data k is present, return false otherwise.
 *
  Note: Assume that BST contains all unique elements
 * */
package binarySearchTree1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class SearchInBST {

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		
		System.out.println(searchInBST(root, 27));

	}
	
	// search in BST
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root == null){
            return false;
        }
        
        if(root.data == k){
            return true;
        }else if(k < root.data){
            return searchInBST(root.left, k);
        }else{
            return searchInBST(root.right, k);
        }
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
