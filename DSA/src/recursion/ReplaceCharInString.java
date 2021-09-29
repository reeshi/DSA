package recursion;

public class ReplaceCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(replaceCharString("abcxdxex", 'x', 'y'));

	}
	
	static String replaceCharString(String str, char a, char b) {
		if(str.length() == 0)
			return str;
		
		String smallerOutput = replaceCharString(str.substring(1), a, b);
		
		if(str.charAt(0) == a) {
			return b + smallerOutput;
		}else {
			return str.charAt(0) + smallerOutput;
		}
	}

}
