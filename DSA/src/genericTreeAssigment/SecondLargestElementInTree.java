/*Given a generic tree,
 *find and return the node with second largest value in given tree.
 *Return NULL if no node with required value is present
 * */
package genericTreeAssigment;

import genericTree.GenericTreeNode;

class Pair3{
    GenericTreeNode<Integer> max;
    GenericTreeNode<Integer> sMax;
    Pair3(GenericTreeNode<Integer> max, GenericTreeNode<Integer> sMax){
        this.max = max;
        this.sMax = sMax;
    }
}

public class SecondLargestElementInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static GenericTreeNode<Integer> findSecondLargest(GenericTreeNode<Integer> root){
		return helperFunction(root).sMax;
	}
    
    public static Pair3 helperFunction(GenericTreeNode<Integer> root){
    	GenericTreeNode<Integer> max = root;
    	GenericTreeNode<Integer> sMax = null;
        
        for(int i=0; i<root.children.size(); i++){
            Pair3 childAns = helperFunction(root.children.get(i));
            if(childAns.max.data > max.data){
                sMax = max;
                max = childAns.max;
                if(childAns.sMax != null && childAns.sMax.data > sMax.data){
                    sMax = childAns.sMax;
                }
            }else if(sMax != null && childAns.max.data > sMax.data && max.data != childAns.max.data){
                sMax = childAns.sMax;
            }else if(sMax == null){
                if(childAns.max.data != max.data){
                    sMax = childAns.max;
                }else{
                    sMax = childAns.sMax;
                }
            }
        }
        
        return new Pair3(max, sMax);
    }

}
