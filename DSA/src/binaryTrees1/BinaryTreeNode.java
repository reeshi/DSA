package binaryTrees1;

public class BinaryTreeNode<T> {
	// make it public because this will be visible in entire project.
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
