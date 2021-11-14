/*Given a generic tree and an integer x,
 *check if x is present in the given tree or not.
 *Return true if x is present, return false otherwise.
 * */
package genericTreeAssigment;

import genericTree.GenericTreeNode;

public class CheckIfContains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean checkIfContainsX(GenericTreeNode<Integer> root, int x){

        if(root.data == x){
            return true;
        }
        
        for(int i=0; i<root.children.size(); i++){
            boolean isPresentInChild = checkIfContainsX(root.children.get(i), x);
            if(isPresentInChild){
                return true;
            }
        }
        
        return false;

	}

}
