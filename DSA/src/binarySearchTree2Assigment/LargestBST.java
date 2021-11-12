/*Given a Binary tree, find the largest BST subtree.
 *That is, you need to find the BST with maximum height in the given binary tree.
 *You have to return the height of largest BST
 * */
package binarySearchTree2Assigment;

import binaryTrees1.BinaryTreeNode;

public class LargestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return helperFunction(root).height;
	}
    
    public static BSTReturn helperFunction(BinaryTreeNode<Integer> root){
        if(root == null){
            return new BSTReturn(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        BSTReturn left = helperFunction(root.left);
        BSTReturn right = helperFunction(root.right);
        
        boolean isBst = false;
        if(left.isBst && right.isBst){
            if(left.maximum < root.data && root.data <= right.minimum){
                isBst = true;
            }
        }
        
        int min = Math.min(root.data, Math.min(left.minimum, right.minimum));
        int max = Math.max(root.data, Math.max(left.maximum, right.maximum));
        
        int height = 0;
        if(isBst){
            height = 1 + Math.max(left.height, right.height);
        }else{
            height = Math.max(left.height, right.height);
        }
        
        BSTReturn ans = new BSTReturn(isBst, min, max, height);
        
        return ans;
    }

}
