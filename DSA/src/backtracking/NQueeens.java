/*You are given N, and for a given N x N chessboard,
 *find a way to place N queens such that no queen can attack any other queen on the chess board.
 *A queen can be killed when it lies in the same row, or same column,
 *or the same diagonal of any of the other queens. You have to print all such configurations
 * */
package backtracking;

public class NQueeens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeQueens(4);
	}
	
	public static void placeQueens(int n) {
		int[][] board = new int[n][n];
		placeQueensHelper(board, n, 0);
	}
	
	private static void placeQueensHelper(int[][] board, int n, int r) {
		if(r == n) {
			// print the path.
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
			
		}
		
		for(int c=0; c < n; c++) {
			
			if(isSafeToPlaceQueen(board, r, c)) {
				board[r][c] = 1;
				placeQueensHelper(board, n, r+1);
				board[r][c] = 0;
			}
			
		}
	}
	
	private static boolean isSafeToPlaceQueen(int[][] board, int r, int c) {
		// top
		for(int row = r-1, col = c; row >= 0; row--) {
			if(board[row][col] == 1) {
				return false;
			}
		}
		
		// left diagonal
		for(int row = r-1, col = c-1; row >= 0 && col >= 0; row--, col--) {
			if(board[row][col] == 1) {
				return false;
			}
		}
		
		// right diagonal
		for(int row = r-1, col = c+1; row >= 0 && col < board[0].length; row--, col++) {
			if(board[row][col] == 1) {
				return false;
			}
		}
		
		return true;
		
	}

}
