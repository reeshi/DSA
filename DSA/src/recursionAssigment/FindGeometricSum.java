package recursionAssigment;

public class FindGeometricSum {

	public static void main(String[] args) {
		
		System.out.println(findGeometricSum(3));

	}
	
	public static double findGeometricSum(int k){
		if(k == 0){
            return 1;
        }
		
		double ans = 1/(double)Math.pow(2, k) + findGeometricSum(k-1);

		return ans;
	}
    
//    static double power(int k){
//        if(k == 0){
//            return 1;
//        }
//        
//        return 2 * power(k-1);
//    }

}
