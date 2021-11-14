/*Given a tree,
 *find and return the node for which sum of data of all children and the node itself is maximum.
 *In the sum, data of node itself and data of immediate children is to be taken
 * */
package genericTreeAssigment;

import genericTree.GenericTreeNode;

class Pair {
    GenericTreeNode<Integer> ans;
    int sum;
    Pair(GenericTreeNode<Integer> ans, int sum){
        this.ans = ans;
        this.sum = sum;
    }
}

public class MaxSumNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static GenericTreeNode<Integer> maxSumNode(GenericTreeNode<Integer> root){
		return helperFunction(root).ans;
	}
    
    public static Pair helperFunction(GenericTreeNode<Integer> root){
    	GenericTreeNode<Integer> ans = root;
        int sum = root.data;
        for(int i=0; i<root.children.size(); i++){
            sum += root.children.get(i).data;
        }
        
        for(int i=0; i<root.children.size(); i++){
            Pair child = helperFunction(root.children.get(i));
            if(child.sum > sum){
                sum = child.sum;
                ans = child.ans;
            }
        }
        
        Pair rootAns = new Pair(ans, sum);
        return rootAns;
    }

}
