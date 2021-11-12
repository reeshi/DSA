/*For a given a Binary Tree of type integer,
 *duplicate every node of the tree and attach it to the left of itself.
 *The root will remain the same. So you just need to insert nodes in the given Binary Tree.
 * */
package binaryTree2Assigment;

import binaryTrees1.BinaryTreeNode;

public class CreateAndInsertDuplicateNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null){
            return;
        }
        
        BinaryTreeNode<Integer> duplicateNode = new BinaryTreeNode<Integer>(root.data);
        
        BinaryTreeNode<Integer> left = root.left;
        BinaryTreeNode<Integer> right = root.right;
        
        insertDuplicateNode(left);
        insertDuplicateNode(right);
        
        duplicateNode.left = left;
        root.left = duplicateNode;
        root.right = right;
        
	}

}
