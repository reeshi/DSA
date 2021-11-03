/*Given a sorted integer array A of size n, which contains all unique elements.
 *You need to construct a balanced BST from this input array.
 *Return the root of constructed BST.
 * */
package binarySearchTree1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees1.BinaryTreeNode;

public class ConstructBST {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		
		BinaryTreeNode<Integer> root = sortedArrayToBST(arr, 0, arr.length-1);
		
		printLevelWise(root);
	}
	
	public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int s, int e){
        if(s > e){
            return null;
        }
        
        int mid = (s + e) / 2;

        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        
        BinaryTreeNode<Integer> left = sortedArrayToBST(arr, s, mid-1);
    	BinaryTreeNode<Integer> right = sortedArrayToBST(arr, mid+1, e);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
	
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root == null){
            System.out.println(-1);
        }

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.print(front.data + ":");

            if(front.left != null){
                System.out.print("L:" + front.left.data + ",");
                pendingChildren.add(front.left);
            }else{
                System.out.print("L:" + -1 + ",");
            }

            if(front.right != null){
                System.out.print("R:" + front.right.data);
                pendingChildren.add(front.right);
            }else{
                System.out.print("R:" + -1);
            }
            
            System.out.println();
        }
        
        
    }

}
