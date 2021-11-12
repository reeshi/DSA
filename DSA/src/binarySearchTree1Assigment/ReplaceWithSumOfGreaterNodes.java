/*Given a binary search tree,
 *you have to replace each node's data with the sum of all nodes which are greater or equal than it.
 *You need to include the current node's data also.
 *
 *That is, if in given BST there is a node with data 5,
 *you need to replace it with sum of its data (i.e. 5)
 *and all nodes whose data is greater than or equal to 5
 *
 *Note: You don't need to return or print, just change the data of each node
 * */
package binarySearchTree1Assigment;

import binaryTrees1.BinaryTreeNode;

public class ReplaceWithSumOfGreaterNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        replace(root, 0);

	}
    
    // it will return the sum of BST.
    public static int replace(BinaryTreeNode<Integer> root, int sumOfGreaterNodes){
        if(root == null){
            return 0;
        }
        
        // Give the sum of right subTree
        int rightSum = replace(root.right, sumOfGreaterNodes);
        
        int temp = root.data;
        root.data += rightSum + sumOfGreaterNodes;
        
        // Give the sum Of left subTree.
        int leftSum = replace(root.left, root.data);
        
        return temp + rightSum + leftSum;
    }

}
