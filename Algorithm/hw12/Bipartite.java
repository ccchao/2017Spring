// File name: Bipartite.java
// Implement solving a maximum bipartite matching problem as a max flow problem.
// Specifically, write a program that constructs a flow network corresponding to a bipartite graph and run the Ford-Fulkerson algorithm. 
// Run your program against each of the two bipartite graphs shown below, and display the resulting set of edges belonging to the maximum bipartite matching.

public class Bipartite
{
	public static void main (String[] args)
	{
		//input bipartite graph is represented as an adjacency list
		//1'->6, 2'->7, 3'->8, 4'->9, 5'->10
		int[][] graph1 = {{},{6,7},{7},{6,8,9},{7,10},{7,10}, {1,3},{1,2,4,5},{3},{3},{4,5}};
		//1'->7, 2'->8, 3'->9, 4'->10, 5'->11
		int[][] graph2 = {{},{8},{7},{8},{7,9,10},{8,10},{9,11}, {2,4},{1,3,5},{4,6},{4,5},{6}};
		int[][] graph;
		int[] set;
		String[] printEdge = {"1'","2'","3'","4'","5'"};
		String result = "Resulting set of edges: {";
		int i,flag=0,max;
		
		//=====first graph=====
		graph = construct(graph1, 10);
		MaxFlow maxflow = new MaxFlow(graph, 10+2); //after adding s and t, there are 12 nodes
		set = maxflow.runMaxFlow();

		/*
		for (i=0; i<6; i++)
			System.out.printf ("%d ", set[i]);
		System.out.println();
		*/
		
		max=0;
		for (i=0; i<6; i++){
			if (set[i]!=0){
				max++;
				if (flag==1)
					result = result + ",";
				else
					flag=1;
				result = result + Integer.toString(i) + "-" + printEdge[set[i]-6];
			}
		}
		result = result + "}";
		System.out.printf ("===First Graph===\nMax Matching: %d\n", max);
		System.out.println(result);


		//=====second graph======
		graph = construct(graph2, 11);
		maxflow = new MaxFlow(graph, 11+2); //after adding s and t, there are 12 nodes
		set = maxflow.runMaxFlow();

		/*
		for (i=0; i<6+1; i++)
			System.out.printf ("%d ", set[i]);
		System.out.println();
		*/
		result="Resulting set of edges: {";;
		max=0;
		flag=0;
		for (i=0; i<6+1; i++){
			if (set[i]!=0){
				max++;
				if (flag==1)
					result = result + ",";
				else
					flag=1;
				result = result + Integer.toString(i) + "-" + printEdge[set[i]-7];
			}
		}
		result = result + "}";
		System.out.printf ("===Second Graph===\nMax Matching: %d\n", max);
		System.out.println(result);
	}

	public static int[][] construct (int[][] inputGraph, int number)
	{
		int i, j;

		int[][] graph = new int[number+2][number+2];

		//Add s. s points to 1 to 10-5=5 or 11-5=6
		graph[0][0]=0;
		for (i=1; i<=number-5; i++)
			graph[0][i]=1; //connected with s
		for (; i<=number+1; i++)
			graph[0][i]=0; //not connected with s

		//Change the undirected edges to directed edges for only node 1 to node 5
		for (i=1; i<=number-5; i++){
			for (j=0; j<=number+1; j++)
				graph[i][j]=0; //initialize
			for (int k : inputGraph[i])
				graph[i][k] = 1; //left to right
		}

		//Add t. Connect 1'~5' to t
		for (; i<=number; i++){
			for (j=0; j<number; j++)
				graph[i][j]=0;
			graph[i][number+1]=1;
		}
		
		//t doesn't point to any node
		for (i=0; i<=number+1; i++)
			graph[number+1][i]=0;

		/* //print the graph
		for (i=0; i<=number+1; i++){
			System.out.printf ("%2d = ", i);
			for (j=0; j<=number+1; j++){
				System.out.printf ("%d ", graph[i][j]);
			}
			System.out.println();
		}*/

		number = number+2; //total number of nodes after adding s and t
		
		return graph;
	}
}
