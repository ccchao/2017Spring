// File name: Graph.java
// Insert all edges into this graph.

import java.util.*;

public class Graph
{
	public PriorityQueue<Edge> graph; 

	// constructor
	public Graph ()
	{
		// implement the comparator for the priority queue of jobs
		Comparator<Edge> comparator = new EdgeComparator();

		graph = new PriorityQueue<Edge>(15, comparator);

		graph.add(new Edge(1,2,9));
		graph.add(new Edge(1,6,14));
		graph.add(new Edge(1,7,15));
		graph.add(new Edge(2,3,24));
		graph.add(new Edge(3,6,18));
		graph.add(new Edge(3,5,2));
		graph.add(new Edge(3,8,19));
		graph.add(new Edge(3,4,6));
		graph.add(new Edge(4,5,11));
		graph.add(new Edge(4,8,7));
		graph.add(new Edge(5,6,30));
		graph.add(new Edge(5,7,20));
		graph.add(new Edge(5,8,16));
		graph.add(new Edge(6,7,5));
		graph.add(new Edge(7,8,44));
		
		/*
		Edge test=new Edge();
		for (int i=0; i<15; i++){
			test=graph.poll();
			System.out.printf("%d ",test.weight);
		
		}
		*/
	}

	public Edge poll ()
	{
		return graph.poll();
	}
}

