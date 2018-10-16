// File name: MaxFlow.java
// Implement the basic Ford-Fulkerson algorithm discussed in class, and run it against the flow network shown below. 
// The program should display the augmenting path and the augmented flow amount each time augmented flow is added to the flow network. 

public class MaxFlow
{
	private int[][][] flow; //represented as an adjacency matrix
	private int[][] residual;
	private int[][] graph;
	private int number; //store the number of nodes

	
	public MaxFlow (int[][] inputgraph, int nodeNumber)
	{
		graph = inputgraph;
		number = nodeNumber;
	}
	
	public int[] runMaxFlow ()
	//public static void main (String[] args)
	{
		//Create the adjacency matrix of the graph
		//list[0] refers to s and list[1] refers to t
		//int[][] graph = {{0,0,10,5,15,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,4,0,9,15,0}, {0,0,0,0,4,0,8,0}, {0,0,0,0,0,0,0,30}, {0,10,0,0,0,0,15,0}, {0,10,0,0,0,0,0,15}, {0,10,0,6,0,0,0,0}};
		int i, j;
		int[] path = new int[number];
		int total=0;
		int[] set = new int[number-6];

		flow = new int[number][number][2]; //flow[i][j][0]=capacity, flow[i][j][0]=flow value
		//Initial flow in each edge
		for (i=0; i<number; i++){
			for (j=0; j<number; j++){
				flow[i][j][0]=graph[i][j];
				flow[i][j][1]=0;
			}
		}

		residual = graph;

		//Declare a BFS
		BFS bfs = new BFS(residual);
		path = bfs.runBFS(0, number);
		
		while (path[0]!=-2){ //There exists an augmenting path P in Gf
			Augment(path);
			bfs = new BFS(residual);
			path = bfs.runBFS(0, number);

			/*System.out.printf ("path: ");
			for (i=0; i<number; i++)
				System.out.printf ("%d ", path[i]);
			System.out.println();
			*/
			
		}

		for (i=0; i<number; i++){
			if (flow[0][i][1] != 0)
				total = total + flow[0][i][1];
		}
		//System.out.printf ("total flow value = %d\n", total);

		/* //print the flow
		for (i=0; i<number; i++){
			System.out.printf ("%2d = ", i);
			for (j=0; j<number; j++){
				System.out.printf ("%d ", flow[i][j][1]);
			}
			System.out.println();
		}*/

		for (i=1; i<number-6; i++){
			set[i]=0;
			for (j=number-6; j<number-1; j++){
				if (flow[i][j][1]==1){
					set[i]=j;
					break;
				}
			}
		}
		return set;
	}

	public void Augment (int[] path)
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
		//System.out.printf ("bottleneck=%d\n", bottleneck);

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
