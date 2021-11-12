/*For a given Binary Tree of type integer and a number K,
 *print out all root-to-leaf paths where the sum of all the node data along the path is equal to K
 * */
package binaryTree2Assigment;

import binaryTrees1.BinaryTreeNode;

public class PathSumFromRootToLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		helperFunction(root, k, "");
	}
    
    public static void helperFunction(BinaryTreeNode<Integer> root, int k, String path){
        if(root == null || k < 0){
            return;
        }
        
        if(root.left == null && root.right == null){
            if(k == root.data){
                path = path + " " + root.data;
                System.out.println(path.trim());
            }else{
                return;
            }
        }
        
        if(path.length() == 0){
            path = Integer.toString(root.data);
        }else{
            path = path + " " + root.data;
        }
        
        helperFunction(root.left, k-root.data, path.trim());
        helperFunction(root.right, k-root.data, path.trim());
        
    }

}
