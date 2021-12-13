//store graphs using adjancency matrix.
package graphs1;
import java.util.*;

public class Graphs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the no. of vertices ");
		int n = sc.nextInt();
		System.out.println("Enter the no. of edges ");
		int e = sc.nextInt();

		int[][] adjMatrix = new int[n][n];

		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}

		// print the graph
		//		for(int i=0; i<n; i++) {
		//			for(int j=0; j<n; j++) {
		//				System.out.print(adjMatrix[i][j] + " ");
		//			}
		//			System.out.println();
		//		}
		System.out.println("DFS");
		dfTraversal(adjMatrix);

		System.out.println();

		System.out.println("BFS");
		bfTraversal(adjMatrix);

	}

	// Breadth first traversal.
	// time complexity is O(v square) where v is total vertices.
	public static void bfTraversal(int[][] adjMatrix) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		boolean[] visited = new boolean[adjMatrix.length];
		// to handle also disconnected graphs case
		for(int i=0; i<adjMatrix.length; i++) {
			if(visited[i] == false) {
				
				pendingVertices.add(0);
				visited[0] = true;

				while(!pendingVertices.isEmpty()) {
					int currentVertex = pendingVertices.poll();
					System.out.print(currentVertex + " ");

					for(int j=0; j<adjMatrix[0].length; j++) {
						if(adjMatrix[currentVertex][j] == 1 && visited[j] == false) {
							pendingVertices.add(j);
							visited[j] = true;
						}
					}

				}
				
			}
		}

	}

	//Depth first traversal.
	// time complexity is O(v square) where v is total vertices.
	public static void dfTraversal(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		// to handle also disconnected graphs case
		for(int i=0; i<adjMatrix.length; i++) {
			if(visited[i] == false) {
				dfTraversalHelper(adjMatrix, i, visited);
			}
		}
	}

	// Helper function for Depth first traversal.
	private static void dfTraversalHelper(int[][] adjMatrix, int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");

		for(int i=0; i<adjMatrix.length; i++) {
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				dfTraversalHelper(adjMatrix, i, visited);
			}
		}

	}

}
