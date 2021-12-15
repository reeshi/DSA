// this algorithm is used to fing the shortest path from source to destination in a given graph.
package graphs2;

import java.util.Scanner;

public class DijkstrasAlgorithm {

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
		
		dijkstrasAlgorithm(adjMatrix);

	}
	
	public static void dijkstrasAlgorithm(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean[] visited = new boolean[n];
		int distances[] = new int[n];
		// source and vertex 0
		distances[0] = 0;
		for(int i=1; i<n; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<n; i++) {
			int minVertex = findMinVertex(visited, distances);
			visited[minVertex] = true;
			// explore the neighbors of minimum vertex.
			for(int j=0; j<n; j++) {
				if(adjMatrix[minVertex][j] != 0 && !visited[j]) {
					if(distances[j] > distances[minVertex] + adjMatrix[minVertex][j]) {
						distances[j] = distances[minVertex] + adjMatrix[minVertex][j];
					}
				}
			}
		}
		
		// print shortest path
		for(int i=1; i<n; i++) {
			System.out.println(i + " " + distances[i]);
		}
	}

	private static int findMinVertex(boolean[] visited, int[] distances) {
		int minVertex = Integer.MAX_VALUE;
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && (minVertex == Integer.MAX_VALUE || distances[i] < distances[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

}
