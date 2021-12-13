/*It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's.
 *But Gary wants the biggest piece of '1's and no '0's.
 *A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake.
 *Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
 * */
package graphs1;

public class LargestPiece {
	
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;
    
	public static int dfs(String[] edge, int n) {
		visited = new boolean[n][n];
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(edge[i].charAt(j) == '1' && visited[i][j] == false){
                    int ans = largestPiece(edge, i, j, -1, -1, n);
                    max = Math.max(max, ans);
                }
            }
        }
        
        return max;
	}

	public static int largestPiece(String[] edge, int x, int y,int fromX, int fromY, int n){
        if(x < 0 || x >= n || y < 0 || y >= n || edge[x].charAt(y) != '1' || visited[x][y]){
            return 0;
        }
        
        visited[x][y] = true;
        int count = 0;
        for(int i=0; i<4; i++){
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            
            if(newX == fromX && newY == fromY){
                continue;
            }
            count += largestPiece(edge, newX, newY, x, y, n);
        }
        
        return count + 1;
    }
	
}
