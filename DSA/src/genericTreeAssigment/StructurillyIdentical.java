/*Given two Generic trees,
 *return true if they are structurally identical i.e.
 *they are made of nodes with the same values arranged in the same way.
 * */
package genericTreeAssigment;

import genericTree.GenericTreeNode;

public class StructurillyIdentical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean checkIdentical(GenericTreeNode<Integer> root1, GenericTreeNode<Integer> root2){

		if(root1.data != root2.data || root1.children.size() != root2.children.size()){
            return false;
        }
        
        for(int i=0; i<root1.children.size(); i++){
            boolean childAns = checkIdentical(root1.children.get(i), root2.children.get(i));
            if(!childAns){
                return false;
            }
        }
        
        return true;
	}

}
