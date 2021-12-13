/*Gary has a board of size NxM. Each cell in the board is a coloured dot.
 *There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z).
 *Now Gary is getting bored and wants to play a game.
 *The key of this game is to find a cycle that contain dots of same colour.
 *Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition
 *
 *1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent.
   Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
   
Since Gary is colour blind, he wants your help.
Your task is to determine if there exists a cycle on the board
 * */
package graphs1;

public class ConnectingDots {
	
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    boolean[][] visited;
    boolean findCycle = false;
    
    void dfs(String[] board, int x, int y, int fromX, int fromY, char needColor, int N, int M){
        if(x < 0 || x >= N || y < 0 || y >= M || board[x].charAt(y) != needColor){
            return;
        }
        
        if(visited[x][y] == true){
            findCycle = true;
            return;
        }
        
        visited[x][y] = true;
        
        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX == fromX && newY == fromY){
                continue;
            }
            dfs(board, newX, newY, x, y, needColor, N, M);
        }
        
    }

    int solve(String[] board , int n, int m)
	{
		visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false){
                    dfs(board, i, j, -1, -1, board[i].charAt(j), n, m);
                    if(findCycle){
                        break;
                    }
                }
            }
            if(findCycle){
                break;
            }
        }
        
        if(findCycle){
            return 1;
        }else{
            return 0;
        }
	}
    
}
