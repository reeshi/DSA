package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		
		towerOfHanoi(2, 'a', 'b', 'c');

	}
	
	static void towerOfHanoi(int disks, char s, char h, char d) {
		if(disks == 0) {
			return;
		}
		
		towerOfHanoi(disks-1, s, d, h);
		
		System.out.println("Move " + disks + " from " + s +" "+ d);
		
		towerOfHanoi(disks-1, h, s, d);
		
	}

}
