/*For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
 *create the binary tree using the given two arrays/lists.
 *You just need to construct the tree and return the root.
 * */
package binaryTrees2;

import java.util.LinkedList;
import java.util.Queue;

import binaryTrees1.BinaryTreeNode;

public class ConstructBinaryTreeUsingInorderAndPreorder {

	public static void main(String[] args) {
		
		int[] preOrder = {5, 6, 2, 3, 9, 10};
		int[] inOrder = {2, 6, 3, 9, 5, 10,};
		
		BinaryTreeNode<Integer> root = buildTree(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
		printLevelWise(root);
		
	}
	
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder, int preS, int preE, int inS, int inE){
        // if arrays is empty than we don't need to do anything.
    	if(preS > preE || inS > inE){
            return null;
        }
        
//        if(preS == preE){
//            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[preS]);
//            return root;
//        }
//        if(inS == inE){
//            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(inOrder[inS]);
//            return root;
//        }
        
        int lPreS, lPreE, lInS, lInE;
        int rPreS, rPreE, rInS, rInE;
        
        int rootData = preOrder[preS];
        int rootIndex = 0;
        for(int i=inS; i<=inE; i++){
            if(inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        
        lInS = inS; 
        lInE = rootIndex-1;
        lPreS = preS + 1;
        lPreE = lInE-lInS + lPreS;
        
        rPreS = lPreE + 1;
        rPreE = preE;
        rInS = rootIndex + 1;
        rInE = inE; 
        
        BinaryTreeNode<Integer> leftSubtree = buildTree(preOrder, inOrder, lPreS, lPreE, lInS, lInE);
        BinaryTreeNode<Integer> rightSubtree = buildTree(preOrder, inOrder, rPreS, rPreE, rInS, rInE);
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = leftSubtree;
        root.right = rightSubtree;
        
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
