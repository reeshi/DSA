//Given a string S, remove consecutive duplicates from it recursively.
package recursion;

public class RemoveDuplicates {

	public static void main(String[] args) {
		

		System.out.println(removeConsecutiveDuplicates("aaaabbbbaaaa"));

	}
	
	public static String removeConsecutiveDuplicates(String s) {
		
        if(s.length() <= 1)
            return s;
        
        String smallerOutput = removeConsecutiveDuplicates(s.substring(1));
        
        if(s.charAt(0) == smallerOutput.charAt(0)){
            return smallerOutput;
        }else{
            return s.charAt(0) + smallerOutput;
        }

	}

}
