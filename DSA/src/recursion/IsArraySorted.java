package recursion;

public class IsArraySorted {

	public static void main(String[] args) {
		
		int[] arr = {1,2,6,4,5};
		
		System.out.println(isArraySorted(arr, 0));

	}
	
	static boolean isArraySorted(int[] arr, int idx) {
		if(idx == arr.length-1)
			return true;
		if(arr[idx] > arr[idx+1])
			return false;
		
		return isArraySorted(arr, idx+1);
	}

}
