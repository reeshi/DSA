package genericTree;

import java.util.*;

public class GenericTreeUse {

	public static void main(String[] args) {
		
//		GenericTreeNode<Integer> root = new GenericTreeNode<Integer>(1);
//		
//		GenericTreeNode<Integer> node1 = new GenericTreeNode<Integer>(2);
//		GenericTreeNode<Integer> node2 = new GenericTreeNode<Integer>(3);
//		GenericTreeNode<Integer> node3 = new GenericTreeNode<Integer>(4);
//		GenericTreeNode<Integer> node4 = new GenericTreeNode<Integer>(5);
//		GenericTreeNode<Integer> node5 = new GenericTreeNode<Integer>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		
//		node2.children.add(node4);
//		node2.children.add(node5);
		
		GenericTreeNode<Integer> root = takeInputLevelWise();
		
		printTree(root);
		
		System.out.println("Number of nodes : " + numNodes(root));
	}
	
	// print the post-order traversal of given tree.
	public static void printPostOrder(GenericTreeNode<Integer> root){
		for(int i=0; i<root.children.size(); i++){
            printPostOrder(root.children.get(i));
        }
        
        System.out.print(root.data + " ");
	}
	
	//  count and return the number of leaf nodes present in the given tree
	public static int countLeafNodes(GenericTreeNode<Integer> root){

		int countLeafNodes = 0;
        if(root.children.size() == 0){
            countLeafNodes++;
            return countLeafNodes;
        }
        
        for(int i=0; i<root.children.size(); i++){
            int childLeafNodes = countLeafNodes(root.children.get(i));
            countLeafNodes += childLeafNodes;
        }
        
        return countLeafNodes;

	}
	
	// Find the height of generic tree.
	public static int getHeight(GenericTreeNode<Integer> root){
		int height = 1;
        int maxHeightChild = 0;
        for(int i=0; i<root.children.size(); i++){
            int childHeight = getHeight(root.children.get(i));
            maxHeightChild = Math.max(maxHeightChild, childHeight);
        }
        
        height += maxHeightChild;
        
        return height;
	}
	
	//  find and return number of Nodes which are greater than x
	public static int numNodeGreater(GenericTreeNode<Integer> root,int x){

		int count = 0;
        if(root.data > x){
            count++;
        }
        
        for(int i=0; i<root.children.size(); i++){
            int childCount = numNodeGreater(root.children.get(i), x);
            count += childCount;
        }
        
        return count;

	}
	
	// print Generic tree level wise.
	public static void printLevelWise(GenericTreeNode<Integer> root){
		
        Queue<GenericTreeNode<Integer>> pendingChildrens = new LinkedList<>();
        pendingChildrens.add(root);
        pendingChildrens.add(null);
        
        while(!pendingChildrens.isEmpty()){
            GenericTreeNode<Integer> front = pendingChildrens.poll();
            if(front == null){
                if(pendingChildrens.isEmpty()){
                    break;
                }else{
                    pendingChildrens.add(null);
                    System.out.println();
                }
            }else{
                System.out.print(front.data + " ");
                for(int i=0; i<front.children.size(); i++){
                    pendingChildrens.add(front.children.get(i));
                }
            }
        }

	}
	
	// Take input level wise.
	// this is better way to take input of tree.
	public static GenericTreeNode<Integer> takeInputLevelWise(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root data : ");
		int rootData = sc.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		Queue<GenericTreeNode<Integer>> pendingChildrens = new LinkedList<>();
		GenericTreeNode<Integer> root = new GenericTreeNode<Integer>(rootData);
		pendingChildrens.add(root);
		
		while(!pendingChildrens.isEmpty()) {
			GenericTreeNode<Integer> front = pendingChildrens.poll();
			System.out.println("Enter the number of childs of " + front.data);
			int numChild = sc.nextInt();
			
			for(int i=0; i<numChild; i++) {
				System.out.println("Enter the " + i + "th child of " + front.data);
				int childData = sc.nextInt();
				GenericTreeNode<Integer> childNode = new GenericTreeNode<Integer>(childData);
				front.children.add(childNode);
				pendingChildrens.add(childNode);
			}
		}
		
		return root;
	}
	
	
	// this is a recursive way to take input of tree
	// but this is not a good way
	// Level wise input is better.
	public static GenericTreeNode<Integer> takeInputRecursive(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootData = sc.nextInt();
		
		// if a user want to create empty tree.
		if(rootData == -1) {
			return null;
		}
		
		GenericTreeNode<Integer> root = new GenericTreeNode<Integer>(rootData);
		
		System.out.println("Enter the number of child of " + rootData);
		int numChild = sc.nextInt();
		
		for(int i=0; i<numChild; i++) {
			GenericTreeNode<Integer> childNode = takeInputRecursive();
			root.children.add(childNode);
		}
		
		return root;
	}
	 
	// find a number nodes is generic tree.
	public static int numNodes(GenericTreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int count = 1;
		for(int i=0; i<root.children.size(); i++) {
			int childCount = numNodes(root.children.get(i));
			count += childCount;
		}
		
		return count;
	}
	
	public static void printTree(GenericTreeNode<Integer> root) {
		
		// this is a special case not a base case.
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + ":");
		for(int i=0; i<root.children.size(); i++) {
			System.out.print(root.children.get(i).data + " ");
		}
		
		System.out.println();
		
		// the base case for this code is
		// if a node has not a children in that case the for loop will not run.
		for(int i=0; i<root.children.size(); i++) {
			GenericTreeNode<Integer> currChild = root.children.get(i);
			printTree(currChild);
		}
		
	}

}
