package binaryTree2Assigment;

/*For a given a Binary Tree of type integer,
 *print it in a level order fashion where each level will be printed on a new line.
 *Elements on every level will be printed in a linear fashion and a single space will separate them.
 * */
import java.util.LinkedList;
import java.util.Queue;

import binaryTrees1.BinaryTreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();        
        pendingChildren.add(root);
        pendingChildren.add(null);

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildren.poll();

            if(front == null){
                if(pendingChildren.isEmpty()){
                    break;
                }else{
                    pendingChildren.add(null);
                    System.out.println();
                }
            }else{
                System.out.print(front.data + " ");
                if(front.left != null){
                    pendingChildren.add(front.left);
                }

                if(front.right != null){
                    pendingChildren.add(front.right);
                }
            }



        }
    }

}
