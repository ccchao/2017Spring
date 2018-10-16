// File name: Graph.java
// Implement two graph traversal algorithms, 
// one using breadth-first search order and one using depth-first search order, 
// and run each of them against the adjacency list representation of the graph shown below. 
// Run each program twice, first starting with the vertex 1 and, second, starting with the vertex 8. 
// In each run, the program should output the number of the vertex visited at each step of the graph traversal.

public class Graph
{
	public static void main (String[] args)
	{
		//Create the adjacency list of the graph
		int[][] list = {{}, {2,3}, {1,3,4,5}, {1,2,5,7,8}, {2,5}, {2,3,4,6}, {5}, {3,8}, {3,7}};

		//Declare a BFS
		BFS bfs = new BFS(list);

		//Run BFS starting from 1 and 8
		System.out.println("BFS starting from 1:");
		bfs.runBFS(1);
		System.out.println("BFS starting from 8:");
		bfs.runBFS(8);

		//Declare a DFS
		DFS dfs = new DFS(list);

		//Run DFS starting from 1 and 8
		System.out.println("DFS starting from 1:");
		dfs.runDFS(1);
		System.out.println("DFS starting from 8:");
		dfs.runDFS(8);


		return;
	}
}









