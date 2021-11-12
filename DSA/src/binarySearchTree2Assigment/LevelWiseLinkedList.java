/*Given a binary tree, write code to create a separate linked list for each level.
 *You need to return the array which contains head of each level linked list
 * */
package binarySearchTree2Assigment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binaryTrees1.BinaryTreeNode;
import linkedList1.Node;

public class LevelWiseLinkedList {

	public static void main(String[] args) {
		

	}
	
	// function to contruct linked list from binary tree
    public static ArrayList<Node<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();        
        pendingChildren.add(root);
        pendingChildren.add(null);

        ArrayList<Node<Integer>> ans = new ArrayList<Node<Integer>>();
        Node<Integer> head = null;
        Node<Integer> tail = null;

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildren.poll();

            if(front == null){
                if(pendingChildren.isEmpty()){
                    ans.add(head);
                    break;
                }else{
                    pendingChildren.add(null);
                    ans.add(head);
                    head = null;
                }
            }else{

                if(head == null){
                    head = new Node<Integer>(front.data);
                    tail = head;
                }else{
                    tail.next = new Node<Integer>(front.data);
                    tail = tail.next;
                }

                if(front.left != null){
                    pendingChildren.add(front.left);
                }

                if(front.right != null){
                    pendingChildren.add(front.right);
                }
            }
        }

        return ans;
    }

}
