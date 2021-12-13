/*An island is a small piece of land surrounded by water .
 *A group of islands is said to be connected 
 *if we can reach from any given island to any other island in the same group .
 * Given V islands (numbered from 1 to V) and E connections or edges between islands.
 *  Can you count the number of connected groups of islands
 * */
package graphs1;

public class Islands {
	
    public static int numConnected(int[][] adjMatrix, int n) {

        boolean[] visited = new boolean[n];
        
        int count = 0;
        for(int i=0; i<adjMatrix.length; i++){
            if(!visited[i]){
                count++;
                dfTraversal(adjMatrix, i, visited);
            }
        }
        
        return count;
    }
    
    public static void dfTraversal(int[][] adjMatrix, int source, boolean[] visited){
        visited[source] = true;
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[source][i] == 1 && visited[i] == false){
                dfTraversal(adjMatrix, i, visited);
            }
        }
    }
}
