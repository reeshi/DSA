package recursion;

public class SplitArray {

	public static void main(String[] args) {
		
		int[] arr = {1,4,3};
		
		System.out.println(splitArray1(arr, 0, 0, 0));

	}
	
    static boolean splitArray1(int arr[], int si, int lsum, int rsum){
        if(si == arr.length){
            if(lsum == rsum){
                return true;
            }else{
                return false;
            }
        }
        
        if(arr[si] % 5 == 0){
            lsum += arr[si];
        }else if(arr[si] % 3 == 0){
            rsum += arr[si];
        }else{
            boolean addingInLsum = splitArray1(arr, si+1, lsum + arr[si], rsum);
            boolean addingInRsum = splitArray1(arr, si+1, lsum, rsum + arr[si]);
            
            return addingInLsum || addingInRsum;
        }
        
        return splitArray1(arr, si+1, lsum, rsum);
    }

}
