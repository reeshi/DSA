package recursion;

public class LastIndexOfElement {

	public static void main(String[] args) {
		
		int[] arr = {9,8,10,8};
		int x = 8;
		
		System.out.println(lastIndexEle(arr, 0, x));

	}
	
    static int lastIndexEle(int[] arr, int idx, int x){
        if(idx == arr.length)
            return -1;
        
        int ans = lastIndexEle(arr, idx+1, x);
        
        if(ans == -1 && arr[idx] == x)
            return idx;
        else
            return ans;
        
    }

}
