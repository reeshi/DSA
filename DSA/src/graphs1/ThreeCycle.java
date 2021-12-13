/*Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges,
 *then count the distinct 3-cycles in the graph.
 *A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.
 * */
package graphs1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeCycle {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int solve(boolean[][] graph, int n) {
        // write your code here
		int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]){
                    for(int k=0; k<n; k++){
                        if(k == i){
                            continue;
                        }
                        if(graph[j][k] && graph[i][k]){
                            count++;
                        }
                    }
                }
            }
        }
        
        return count / 6;
	}

	public static boolean[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int m = Integer.parseInt(strNums[1]);

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws IOException{
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}
	
}
