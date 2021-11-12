/*For a given a Binary Tree of type integer,
 *find and return the minimum and the maximum data values.
 * */
package binaryTree2Assigment;

import binaryTrees1.BinaryTreeNode;

public class MinimumAndMaximumOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        
		if(root == null){
            Pair<Integer, Integer> ans = new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE);
            return ans;
        }
        
        Pair<Integer, Integer> leftAns = getMinAndMax(root.left);
        Pair<Integer, Integer> rightAns = getMinAndMax(root.right);
        
        int min = Math.min(leftAns.minimum, rightAns.minimum);
        int max = Math.max(leftAns.maximum, rightAns.maximum);
        
        min = Math.min(root.data, min);
        max = Math.max(root.data, max);
        
        Pair<Integer, Integer> ans = new Pair<Integer, Integer>(min, max);
        return ans;
        
	}

}
