package binarySearchTree2;

public class BSTUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST b = new BST();
		
		b.insert(8);
		b.insert(5);
		b.insert(10);
		b.insert(2);
		b.insert(6);
		b.insert(7);
		
		
		b.printTree();
		
		System.out.println(b.isPresent(5));
		
		b.deleteData(5);
		
		System.out.println(b.isPresent(5));
		
		b.printTree();
		
		System.out.println(b.size());
	}

}
