package binaryTrees2;

import java.util.LinkedList;
import java.util.Queue;

import binaryTrees1.BinaryTreeNode;

public class ConstructBinaryTreeUsingPostorderAndInorder {

	public static void main(String[] args) {
		
		int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
		int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
		
		BinaryTreeNode<Integer> root = buildTree(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
		
		printLevelWise(root);
	}
	
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder, int postS, int postE, int inS, int inE){
        if(postS > postE || inS > inE){
            return null;
        }

        // if(postS == postE){
        //     BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postOrder[postS]);
        //     return root;
        // }
        // if(inS == inE){
        //     BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(inOrder[inS]);
        //     return root;
        // }

        int lPostS, lPostE, lInS, lInE;
        int rPostS, rPostE, rInS, rInE;

        int rootData = postOrder[postE];
        int rootIndex = 0;
        for(int i=inS; i<=inE; i++){
            if(inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        lInS = inS;                                          
        lInE = rootIndex-1;
        lPostS = postS;
        lPostE = lInE-lInS + lPostS;

        rPostS = lPostE + 1;
        rPostE = postE - 1;
        rInS = rootIndex + 1;
        rInE = inE; 

        BinaryTreeNode<Integer> leftSubtree = buildTree(postOrder, inOrder, lPostS, lPostE, lInS, lInE);
        BinaryTreeNode<Integer> rightSubtree = buildTree(postOrder, inOrder, rPostS, rPostE, rInS, rInE);

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
