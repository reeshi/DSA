/*Given a binary search tree and an integer S,
 *find pair of nodes in the BST which sum to S.
 *You can use extra space of the order of O(log n)
 * */
package binarySearchTree2Assigment;

import java.util.Stack;

import binaryTrees1.BinaryTreeNode;

public class PairSumInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if(root == null){
            return;
        }

        Stack<BinaryTreeNode<Integer>> s1 = new Stack<BinaryTreeNode<Integer>>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<BinaryTreeNode<Integer>>();

        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;
        BinaryTreeNode<Integer> curr1 = root, curr2 = root;

        while(true){

            // normal inOrder Traversal.
            while(done1 == false){
                if(curr1 != null){
                    s1.push(curr1);
                    curr1 = curr1.left;
                }else{
                    if(s1.isEmpty()){
                        done1 = true;
                    }else{
                        curr1 = s1.pop();
                        val1 = curr1.data;
                        curr1 = curr1.right;
                        done1 = true;
                    }
                }
            }

            // reverse inorder traversal.
            while(done2 == false){
                if(curr2 != null){
                    s2.push(curr2);
                    curr2 = curr2.right;
                }else{
                    if(s2.isEmpty()){
                        done2 = true;
                    }else{
                        curr2 = s2.pop();
                        val2 = curr2.data;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }

            if(val1 >= val2){
                return;
            }

            if((val1 != val2) && (val1 + val2 == s)){
                System.out.println(val1 + " " + val2);
                done1 = false;
                done2 = false;
            }else if((val1 + val2) > s){
                done2 = false;
            }else{
                done1 = false;
            }

        }
    }

}
