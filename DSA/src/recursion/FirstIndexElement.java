package recursion;

public class FirstIndexElement {

	public static void main(String[] args) {
		
		int[] arr = {9,8,10,8};
		int x = 8;
		
		System.out.println(firstIndex(arr, 0, x));

	}
	
    static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length)
            return -1;
        
        if(arr[idx] == x)
            return idx;
        
        return firstIndex(arr, idx+1, x);
    }

}
