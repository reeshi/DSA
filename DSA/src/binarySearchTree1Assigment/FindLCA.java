/*Given a binary search tree and data of two nodes,
 *find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST
 *
 *LCA: 
 *	LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants.
 * */
package binarySearchTree1Assigment;

import binaryTrees1.BinaryTreeNode;

public class FindLCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if(root == null){
            return -1;
        }

        if(root.data == a){
            boolean isLeftPresnt = searchInBST(root.left, b);
            boolean isRightPresent = searchInBST(root.right, b);

            if(isLeftPresnt || isRightPresent){
                return root.data;
            }

            return root.data;
        }

        if(root.data == b){
            boolean isLeftPresnt = searchInBST(root.left, a);
            boolean isRightPresent = searchInBST(root.right, a);

            if(isLeftPresnt || isRightPresent){
                return root.data;
            }

            return root.data;
        }

        boolean isLeftPresnt = searchInBST(root.left, a);
        boolean isRightPresent = searchInBST(root.right, b);

        if(isLeftPresnt && isRightPresent){
            return root.data;
        }else if(!isLeftPresnt && !isRightPresent){
            return -1;
        }

        int leftLCA = getLCA(root.left, a, b);
        int rightLCA = getLCA(root.right, a, b);

        if(leftLCA != -1){
            return leftLCA;
        }else{
            return rightLCA;
        }

    }

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

}
