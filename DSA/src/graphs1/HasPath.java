/*Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers),
 *check if there exists any path between them or not. Print true if the path exists
 *and false otherwise.
 *	Note :
 *	1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
 *	2. E is the number of edges present in graph G
 * */
package graphs1;
import java.util.*;

public class HasPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int e = sc.nextInt();

		int[][] adjMatrix = new int[n][n];

		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}

		int source = sc.nextInt();
		int destination = sc.nextInt();


		// boolean[] visited = new boolean[n];
		// System.out.println(dfHasPath(adjMatrix, source, destination, visited));

		System.out.println(bfHasPath(adjMatrix, source, destination));
	}

	// bf traversal approach.
	public static boolean bfHasPath(int[][] adjMatrix, int source, int destination){
		if(destination >= adjMatrix.length){
			return false;
		}

		boolean[] visited = new boolean[adjMatrix.length];
		Queue<Integer> pendingVertex = new LinkedList<>();
		pendingVertex.add(source);
		visited[source] = true;

		while(!pendingVertex.isEmpty()){
			int currentVertex = pendingVertex.poll();
			for(int i=0; i<adjMatrix.length; i++){
				if(adjMatrix[currentVertex][i] == 1 && visited[i] == false){
					pendingVertex.add(i);
					visited[i] = true;
				}
			}
		}

		return visited[destination];
	}
}
