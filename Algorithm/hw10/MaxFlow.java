// File name: MaxFlow.java
// Implement the basic Ford-Fulkerson algorithm discussed in class, and run it against the flow network shown below. 
// The program should display the augmenting path and the augmented flow amount each time augmented flow is added to the flow network. 

public class MaxFlow
{
	public static int[][][] flow;
	public static int[][] residual;

	public static void main (String[] args)
	{
		//Create the adjacency matrix of the graph
		//list[0] refers to s and list[1] refers to t
		int[][] graph = {{0,0,10,5,15,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,4,0,9,15,0}, {0,0,0,0,4,0,8,0}, {0,0,0,0,0,0,0,30}, {0,10,0,0,0,0,15,0}, {0,10,0,0,0,0,0,15}, {0,10,0,6,0,0,0,0}};
		int i, j;
		int[] path = new int[8];
		int total=0;

		flow = new int[8][8][2]; //flow[i][j][0]=capacity, flow[i][j][0]=flow value
		//Initial flow in each edge
		for (i=0; i<8; i++){
			for (j=0; j<8; j++){
				flow[i][j][0]=graph[i][j];
				flow[i][j][1]=0;
			}
		}

		residual = graph;

		//Declare a BFS
		BFS bfs = new BFS(residual);
		path = bfs.runBFS(0);
		
		while (path[0]!=-2){ //There exists an augmenting path P in Gf
			Augment(path);
			bfs = new BFS(residual);
			path = bfs.runBFS(0);

			System.out.printf ("path: ");
			for (i=0; i<8; i++)
				System.out.printf ("%d ", path[i]);
			System.out.println();
			
			
		}

		for (i=0; i<8; i++){
			if (flow[0][i][1] != 0)
				total = total + flow[0][i][1];
		}
		System.out.printf ("total flow value = %d\n", total);
	}

	public static void Augment (int[] path)
	{
		int i, j, bottleneck=100, first, second;

		//Find the bottleneck of the path
		for (i=0; path[i+1]!=-1; i++){
			first = path[i];
			second = path[i+1];
			if (residual[first][second] < bottleneck){
				bottleneck = residual[first][second];
			}
		}
		System.out.printf ("bottleneck=%d\n", bottleneck);

		//for each edge in the path
		for (i=0; path[i+1]!=-1; i++){
			first = path[i];
			second = path[i+1];

			//forward edge
			residual[first][second] = residual[first][second] - bottleneck;

			//reverse edge
			residual[second][first] = residual[second][first] + bottleneck;

			if (flow[first][second][0]!=0) //forward edge
				flow[first][second][1] = flow[first][second][1] + bottleneck;
			else //reverse edge
				flow[first][second][1] = flow[first][second][1] - bottleneck;

		}
	}
}
