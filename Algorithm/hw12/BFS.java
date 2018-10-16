// File name: BFS.java
// Implement breadth first search on an adjacency matrix of a residual graph

import java.util.*;

public class BFS
{
	//Declare a list to store the adjacency matrix
	private int[][] graph;

	//Constructor with given adjacency matrix of the graph
	public BFS (int[][] arrivalList)
	{
		//Create the adjacency list of the graph
		graph = arrivalList;
	}

	//Run the BFS with first node
	public int[] runBFS (int firstNode, int number)
	{
		int u, v;
		boolean[] discovered = new boolean[number];
		//int[] from = {-1,-1,-1,-1,-1,-1,-1,-1}; //to store where each node is from
		int[] from = new int[number];
		int[] path = new int[number];
		//int[] nothing = {-2,-2,-2,-2,-2,-2,-2,-2}; // if there is no augmented path
		int[] nothing = new int[number];

		//Initialize
		for (u=0; u<number; u++){
			from[u] = -1;
			nothing[u] = -2;
		}

		//Initialize Q to be a FIFO queue with the first node
		LinkedList<Integer> FIFOqueue = new LinkedList<Integer>();
		FIFOqueue.add(firstNode);
		
		//While Q is not empty
		while (FIFOqueue.size() > 0){

			//Take a node u from Q
			u = FIFOqueue.remove();

			if (discovered[u] == false){

				//Set Discovered[u]=true
				discovered[u] = true;

				//output the number of the vertex visited at each step of the graph traversal
				//System.out.printf("%d ", u);

				//For each edge (u,v) incident to u
				for (v=0; v<number; v++){
					if (graph[u][v]!=0 && discovered[v] == false){
						FIFOqueue.add(v);

						//Remember where each node is from
						if (from[v] == -1){ 
							from[v]=u;
						}
					}
				}
			}
		}
		/*
		System.out.println("");

		System.out.printf ("from: ");
		for (v=0; v<number; v++){
			System.out.printf ("%d ", from[v]);
		}
		System.out.println("");
		*/
		if (from[number-1]==-1) //if there is no augmented path
			return nothing;
		else{
			path=findPath(from, number);
			return path;
		}

	}

	public int[] findPath (int[] from, int number)
	{
		//int[] reverse = {-1,-1,-1,-1,-1,-1,-1,-1};
		int[] reverse = new int[number];
		//int[] path = {-1,-1,-1,-1,-1,-1,-1,-1};
		int[] path = new int[number];
		int i, j;

		//initialize
		for (i=0; i<number; i++){
			reverse[i] = -1;
			path[i] = -1;
		}
		
		//using from[] to find a reverse path
		reverse[0]=number-1;
		i=number-1;
		j=1;
		while(i!=0){
			reverse[j]=from[i];
			j++;
			i=from[i];
		}

		/*
		System.out.printf ("reverse: ");
		for (i=0; i<number; i++){
			System.out.printf ("%d ", reverse[i]);
		}
		System.out.println();
		*/

		//using reverse[] to find the real path
		for (j=number-1, i=0; j>=0; j--){
			if (reverse[j]!=-1){
				path[i]=reverse[j];
				i++;
			}
		}
		/*
		System.out.printf ("path: ");
		for (i=0; i<number; i++){
			System.out.printf ("%d ", path[i]);
		}
		System.out.println("");
		*/

		return path;
	}
}



