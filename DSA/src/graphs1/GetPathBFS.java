/*Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers),
 *find and print the path from v1 to v2 (if exists).
 *Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
 * */
package graphs1;
import java.util.*;
public class GetPathBFS {
	
    public static void main(String[] args) {

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
        
        ArrayList<Integer> res = getPathBFS(adjMatrix, source, destination);
        
        if(res != null){
            for(int i: res){
                System.out.print(i + " ");
            }
        }
        
    }
    
    public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int source, int destination){
        
        Queue<Integer> pendingVertex = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[adjMatrix.length];
        
        pendingVertex.add(source);
        visited[source] = true;
        map.put(source, -1);
        
        boolean isPath = false;
        while(!pendingVertex.isEmpty()){
            int currentVertex = pendingVertex.poll();
            
            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && visited[i] == false){
                    pendingVertex.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);
                    if(i == destination){
                        isPath = true;
                        break;
                    }
                }
            }
            
            if(isPath){
                break;
            }
        }
        
        if(isPath){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(destination);
            int parent = map.get(destination);
            while(parent != -1){
            	res.add(parent);
                parent = map.get(parent);
            }
            
            return res;
        }else{
            return null;
        }

    }
    
}
