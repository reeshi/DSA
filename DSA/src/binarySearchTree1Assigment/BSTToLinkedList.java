/*Given a BST, convert it into a sorted linked list. You have to return the head of LL.
 * */
package binarySearchTree1Assigment;

import binaryTrees1.BinaryTreeNode;
import linkedList1.Node;

public class BSTToLinkedList {

	public static void main(String[] args) {
		
		

	}
	
	// function that convert BST into sorted LinkedList.
    public static Node<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
      if(root == null){
          return null;
      }

      Node<Integer> left = constructLinkedList(root.left);
      Node<Integer> right = constructLinkedList(root.right);
      Node<Integer> tail = left;
      Node<Integer> rootNode = new Node<Integer>(root.data);
      if(left != null){
          while(tail.next != null){ 
              tail = tail.next;
          }
          tail.next = rootNode;
          rootNode.next = right;
          return left;
      }else{
          rootNode.next = right;
         return rootNode;
      }

 }

}
