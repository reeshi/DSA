/*Given a string you need to print longest possible substring that has exactly M unique characters.
 *If there are more than one substring of longest possible length, then print any one of them.
 *
 *"aabbcc", k = 1
  Max substring can be any one from {"aa" , "bb" , "cc"}.

 "aabbcc", k = 2
 Max substring can be any one from {"aabb" , "bbcc"}.

 "aabbcc", k = 3
 There are substrings with exactly 3 unique characters
 {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 Max is "aabbcc" with length 6.

 "aaabbb", k = 3
 There are only two unique characters, thus show error message.
 * */
package slidingWindow;

public class LongestSubstring {

	public static void main(String[] args) {
		
		String str = "abcbdbdbbdcdabd";
		int k = 2;
		
		System.out.println(findLongestSubstring(str, k));

	}
	
	static String findLongestSubstring(String str, int k) {
		// frequency aaray
		int[] freq = new int[26];
		
		// insert first char into freq array
		freq[str.charAt(0) - 'a']++;
		
		// than tarvel the whole string 
		int s = 0, e = 0;
		int max_windowSize = 0, max_s = 0, max_e = 0;
		
		while(e < str.length()-1) {
			e++;
			freq[str.charAt(e) - 'a']++;
			
			// if window is not valid than make window valid
			if(!isValid(freq, k)) {
				while(!isValid(freq, k)) {
					freq[str.charAt(s) - 'a']--;
					s++;
				}
			}
			
			// update the max_windowSize value if it is less than current window size;
			if(max_windowSize < e - s + 1) {
				max_windowSize = e - s + 1;
				max_s = s;
				max_e = e;
			}
		}
		
		return str.substring(max_s, max_e+1); 
	}
	
	static boolean isValid(int[] arr, int k) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				count++;
			}
		}
		
		return (count <= k);
	}

}
