// File name: BFS.java
// Implement two graph traversal algorithms, 
// one using breadth-first search order and one using depth-first search order, 
// and run each of them against the adjacency list representation of the graph shown below. 
// Run each program twice, first starting with the vertex 1 and, second, starting with the vertex 8. 
// In each run, the program should output the number of the vertex visited at each step of the graph traversal.

import java.util.*;

public class BFS
{
	//Declare a list to store the adjacency list
	private int[][] list;

	//Constructor with given adjacency list of the graph
	public BFS (int[][] arrivalList)
	{
		//Create the adjacency list of the graph
		list = arrivalList;
	}

	//Run the BFS with first node
	public void runBFS (int firstNode)
	{
		int u;
		boolean[] discovered = new boolean[9];

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
				System.out.printf("%d ", u);

				//For each edge (u,v) incident to u
				for (int v : list[u]){
					if (discovered[v] == false){
						FIFOqueue.add(v);
					}
				}
			}
		}
		System.out.println("");
	}
}



