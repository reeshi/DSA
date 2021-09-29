package recursion;

public class RemovePi {

	public static void main(String[] args) {
		
		System.out.println(removePi("abcpipipipi"));

	}
	
	static String removePi(String str) {
		if(str.length() <= 1) {
			return str;
		}
		
		if(str.substring(0, 2).equals("pi")) {
			// call recursion on string of length n-2
			String smallerOutput = removePi(str.substring(2));
			return 3.14 + smallerOutput;
		}else {
			// call recursion on string of length n-1
			String smallerOutput = removePi(str.substring(1));
			return str.charAt(0) + smallerOutput;
		}
	}

}
