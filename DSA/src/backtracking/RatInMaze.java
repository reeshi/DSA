package backtracking;

public class RatInMaze {

	public static void main(String[] args) {
		
		int[][] maze = {{1,0,1}, {1,0,1}, {1,1,1}};
		
		System.out.println(ratInAMazePathExist(maze, 0, 0, new int[3][3]));
		
		ratInMazePrintAllThePaths(maze, 3, 0, 0, new int[3][3]);

	}

	//Find whether any path exist that rat can follow to reach its destination
	public static boolean ratInAMazePathExist(int maze[][], int i, int j, int path[][]){
		if(i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == 0 || path[i][j] == 1){
			return false;
		}

		if(i == maze.length-1 && j == maze.length-1){
			return true;
		}

		path[i][j] = 1;

		//top
		boolean path1 = ratInAMazePathExist(maze, i-1, j, path);
		if(path1){
			return true;
		}

		// right
		boolean path2 = ratInAMazePathExist(maze, i, j+1, path);
		if(path2){
			return true;
		}

		// down
		boolean path3 = ratInAMazePathExist(maze, i+1, j, path);
		if(path3){
			return true;
		}

		// left
		boolean path4 = ratInAMazePathExist(maze, i, j-1, path);
		if(path4){
			return true;
		}


		return false;
	}

	//Find and print all paths that rat can follow to reach its destination
	public static void ratInMazePrintAllThePaths(int maze[][], int n, int i, int j, int[][] path){
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
			return;
		}

		path[i][j] = 1;

		if(i == n-1 && j == n-1){

			for(int p=0; p<n; p++){
				for(int q=0; q<n; q++){
					System.out.print(path[p][q] + " ");
				}
			}
			System.out.println();
			path[i][j] = 0;
			return;

		}                

		//Top                                          
		ratInMazePrintAllThePaths(maze, n, i-1, j, path);

		// right
		ratInMazePrintAllThePaths(maze, n, i, j+1, path);

		// down
		ratInMazePrintAllThePaths(maze, n, i+1, j, path);

		// left
		ratInMazePrintAllThePaths(maze, n, i, j-1, path);

		path[i][j] = 0;

	}

}
