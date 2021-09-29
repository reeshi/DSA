package recursionAssigment;

public class StairCase {

	public static void main(String[] args) {
		
		System.out.println(staircase(4));

	}

	public static int staircase(int n){

		if(n == 0){
			return 1;
		}else if(n < 0){
			return 0;
		}

		int firstPath = staircase(n-1);
		int secondPath = staircase(n-2);
		int thirdPath = staircase(n-3);

		return firstPath + secondPath + thirdPath;

	}

}
