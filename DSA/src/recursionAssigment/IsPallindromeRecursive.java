package recursionAssigment;

public class IsPallindromeRecursive {

	public static void main(String[] args) {
		
		String str = "reeshr";
		
		System.out.println(isPalindrome(str, 0, str.length()-1));

	}

	static boolean isPalindrome(String str, int si, int ei){
		if(si >= ei){
			return true;
		}

		if(str.charAt(si) == str.charAt(ei)){
			return isPalindrome(str, si+1, ei-1);
		}else{
			return false;
		}
	}

}
