package arrays;

import java.util.Scanner;

public class Sort01 {

	public static void main(String[] args) {
		
		int[] input = takeArrayInput();
		
		sortZeroesAndOne(input);
		
		printArray(input);

	}
	
    public static void sortZeroesAndOne(int[] arr) {
    	int i = 0;
        int j = 0;
        
        while(i < arr.length){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
    }
    
	static int[] takeArrayInput() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		return arr;
	}
	
	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
