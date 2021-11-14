/*Given a generic tree and an integer n.
 *Find and return the node with next larger element in the Tree i.e.
 *find a node with value just greater than n
 * */
package genericTreeAssigment;

import genericTree.GenericTreeNode;

class Pair2 {
    GenericTreeNode<Integer> ans;
    int minDIff;
    Pair2(GenericTreeNode<Integer> ans, int minDIff){
        this.ans = ans;
        this.minDIff = minDIff;
    }
}

public class NextLargerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static GenericTreeNode<Integer> findNextLargerNode(GenericTreeNode<Integer> root, int n){
		return helperFunction(root, n).ans;
	}
    
    public static Pair2 helperFunction(GenericTreeNode<Integer> root, int n){
        GenericTreeNode<Integer> ans = null;
        int minDIff = Integer.MAX_VALUE;
        
        if(root.data > n && root.data - n < minDIff){
            ans = root;
            minDIff = root.data - n;
        }
        
        for(int i=0; i<root.children.size(); i++){
            Pair2 childAns = helperFunction(root.children.get(i), n);
            if(childAns.minDIff < minDIff){
                ans = childAns.ans;
                minDIff = childAns.minDIff;
            }
        }
        
        Pair2 rootAns = new Pair2(ans, minDIff);
        return rootAns;
    }

}
