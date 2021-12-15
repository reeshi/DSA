// this algorithm is also used to find minimum spanning tree from the given graph.
// time complexity --> O(V square).
package graphs2;

import java.util.Scanner;

public class PrimsAlgorithm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int e = sc.nextInt();

		int[][] adjMatrix = new int[n][n];

		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();

			adjMatrix[v1][v2] = weight;
			adjMatrix[v2][v1] = weight;
		}

		primsAlgorithm(adjMatrix);

	}

	public static void primsAlgorithm(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		int[] weight = new int[n];

		// source - vertex 0
		parent[0] = -1;
		weight[0] = 0;
		for(int i=1; i<n; i++) {
			weight[i] = Integer.MAX_VALUE;
		}

		for(int i=0; i<n; i++) {
			int minVertex = findMinVertex(visited, weight);
			visited[minVertex] = true;
			// explore the neighbors of minimum vertex
			for(int j=0; j<n; j++) {
				if(adjMatrix[minVertex][j] != 0 && !visited[j]) {
					if(weight[j] > adjMatrix[minVertex][j]) {
						// update values
						weight[j] = adjMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}

		// print the MST
		for(int i=1; i<n; i++) {
			if(i < parent[i]) {
				System.out.println(i + " " + parent[i] + " " + weight[i]);
			}else {
				System.out.println(parent[i] + " " + i + " " + weight[i]);
			}
		}
	}

	public static int findMinVertex(boolean[] visited, int[] weight) {
		int minVertex = Integer.MAX_VALUE;
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && (minVertex == Integer.MAX_VALUE || weight[i] < weight[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}


}
