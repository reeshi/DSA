// kruskal algorithm is used to find minimum spanning tree from the given graph 
// time complexity --> ElogE + EV, where E and  V are edges and vertices respectively.
package graphs2;

import java.util.Arrays;
import java.util.Scanner;

// we create edge class because for this algorithm we need array of edge
// so we will implement edge list each edge contains
// vertices1 , vertices2 and weight
class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int weight;

	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class KruskalAlgorithm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // vertices
		int e = sc.nextInt(); // edges

		Edge edges[] = new Edge[e];

		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();

			edges[i] = new Edge(v1, v2, weight);
		}

		Edge[] mst = kruskalAlgorithm(edges, n);
		
		for(int i=0; i<mst.length; i++) {
			if(mst[i].v1 <= mst[i].v2) {
				System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
			}else {
				System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);
			}
		}
	}

	//kruskal algorithm
	public static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
		Arrays.sort(edges);

		int[] parent = new int[n];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}

		Edge[] mst = new Edge[n-1];
		int count = 0, i=0;
		while(count != n-1) {
			Edge currentEdge = edges[i++];
			int v1Parent = findParent(parent, currentEdge.v1);
			int v2Parent = findParent(parent, currentEdge.v2);

			if(v1Parent != v2Parent) {
				mst[count] = currentEdge;
				count++;
				parent[v1Parent] = v2Parent;
			}
		}
		
		return mst;
	}

	public static int findParent(int[] parent, int v) {

		while(v != parent[v]) {
			v = parent[v];
		}

		return v;
	}

}
