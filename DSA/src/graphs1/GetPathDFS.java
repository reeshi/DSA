/*Given an undirected graph G(V, E) and two vertices v1 and v2(as integers),
 *find and print the path from v1 to v2 (if exists).
 *Print nothing if there is no path between v1 and v2.
  Find the path using DFS and print the first path that you encountered
  
  Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
 * */
package graphs1;
import java.util.*;
public class GetPathDFS {
	
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] adjMatrix = new int[v][v];

        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        boolean[] visited = new boolean[v];

        ArrayList<Integer> res = getPath(adjMatrix, source, destination, visited);
        if(res != null){
            for(int i=0; i<res.size(); i++){
                System.out.print(res.get(i) + " ");
            }
        }

    }

    public static ArrayList<Integer> getPath(int[][] adjMatrix, int source, int destination, boolean[] visited){
        if(destination >= adjMatrix.length){
            return null;
        }

        visited[source] = true;

        if(source == destination){
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(source);
            return bres;
        }

        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[source][i] == 1 && visited[i] == false){
                ArrayList<Integer> res = getPath(adjMatrix, i, destination, visited);
                if(res != null){
                    res.add(source);
                    return res;
                }
            }
        }

        return null;
    }
    
}
