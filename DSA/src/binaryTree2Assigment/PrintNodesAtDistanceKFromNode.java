/*You are given a Binary Tree of type integer, a target node, and an integer value K
 * 
 * Print the data of all nodes that have a distance K from the target node.
 * The order in which they would be printed will not matter.
 * */
package binaryTree2Assigment;

import binaryTrees1.BinaryTreeNode;

public class PrintNodesAtDistanceKFromNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		helperFunction(root, node, k);
    }
    
    public static int helperFunction(BinaryTreeNode<Integer> root, int node, int k){
        if(root == null){
            return -1;
        }
        
        if(root.data == node){
            printAtDepthK(root, k);
            return 0;
        }
        
        int lDistance = helperFunction(root.left, node, k);
		if(lDistance != -1){
            if(lDistance + 1 == k){
                System.out.println(root.data);
            }else{
                printAtDepthK(root.right, k-lDistance-2);
            }
            return lDistance + 1;
        }
        
        int rDistance = helperFunction(root.right, node, k);
		if(rDistance != -1){
            if(rDistance + 1 == k){
                System.out.println(root.data);
            }else{
                printAtDepthK(root.left, k-rDistance-2);
            }
            return rDistance + 1;
        }
        
        return -1;
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if(root == null) {
            return;
        }

        if(k == 0) {
            System.out.println(root.data);
        }

        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);

    }


}
