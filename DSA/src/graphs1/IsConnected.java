/*Given an undirected graph G(V,E), check if the graph G is connected graph or not
 * 
 * Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.

 * */
package graphs1;
import java.util.*;
public class IsConnected {
	
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
        
        boolean ans = isConnected(adjMatrix);
		System.out.println(ans);
        
    }
    
    public static boolean isConnected(int[][] adjMatrix){
        if(adjMatrix.length == 0){
            return true;
        }
        
        Queue<Integer> pendingVetex = new LinkedList<>();
        boolean[] visited = new boolean[adjMatrix.length];
        
        pendingVetex.add(0);
        visited[0] = true;
        
        while(!pendingVetex.isEmpty()){
            int currentVertex = pendingVetex.poll();
            
            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && visited[i] == false){
                    pendingVetex.add(i);
                    visited[i] = true;
                }
            }
        }
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == false){
                return false;
            }
        }
        
        return true;
    }
    
}
