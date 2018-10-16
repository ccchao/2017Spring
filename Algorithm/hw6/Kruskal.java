// File name: Kruskal.java
// Implement the Kruskal’s minimum spanning tree algorithm (shown below) using disjoint sets of nodes and show the trace of the algorithm against the graph shown below. 
// Use any data structure to represent a graph; an edge list is fine. 
// Implement disjoint sets as a forest (i.e., set of trees), where each tree represents one subset in the disjoint sets.
// Employ union heuristics when merging two trees, that is, connect the shorter tree as subtree of the longer tree; if the tree heights are the same, then connect the root node with the smaller number to the root node with the larger number.
// Apply path compression to provide a shortcut to the root after the Find operation. 
// For the program run output, print the iteration number (e.g., i) and the result of Find and Union every time they are called (e.g., “Find(1) returns 3”,”Find(2) returns 2”, “Union(3, 2) done”) in each iteration.

import java.util.*;

public class Kruskal
{
	//private static List<LinkedList<Integer>> sets;
	private static int[] parent;
	private static int[] height;

	public static void main (String[] args)
	{
		int i, j;
		int u, v, root1, root2;
		Edge edge;


		// show the graph and sort edges in an increasing order of weight
		Graph graph = new Graph();

		// initialize the tree without any edges
		LinkedList<Integer> tree = new LinkedList<Integer>();

		// MakeUnionFind(V)
		parent = new int[9]; //record its parent
		height = new int[9]; //record its height
		for (i=0; i<9; i++){
			parent[i]=i;
			height[i]=i;
		}

		// for each edge in the sorted order
		for (i=1; i<=15; i++){
			System.out.printf("i=%d // ", i);

			// select the edge with minimum weight
			edge = graph.poll();
			u = edge.first;
			v = edge.second;
			
			root1 = Find(u);
			System.out.printf("Find(%d) returns %d. // ", u, root1);
			root2 = Find(v);
			System.out.printf("Find(%d) returns %d. ", v, root2);

			if (root1 != root2){
				tree.add(edge.weight);
				Union(root1,root2);
				System.out.printf("// Union(%d, %d) done", root1, root2);
			}
			System.out.println();
		}

	}

	public static int Find (int child)
	{
		int currentChild=child;
		//int count=1;
		
		// find the root
		while (parent[currentChild]!=currentChild){
			currentChild = parent[currentChild];
		}
		
		PathCompression(child, currentChild);
	
		return currentChild;
	}

	public static void Union (int first, int second)
	{
		// connect the shorter tree as subtree of the longer tree
		if (height[first] < height[second]){
			parent[first] = second;
		}
		else if (height[first] > height[second]){
			parent[second] = first;
		}
		// connect the root node with the smaller number to the root node with the larger number
		else if (first < second){
			parent[first] = second;
		}
		else{
			parent[second] = first;
		}
	}

	public static void PathCompression (int child, int root)
	{
		int currentChild;
		int count=1;

		// path compression
		parent[child] = root;
		parent[parent[child]] = root;


		// calculate the height of the root
		currentChild=child;
		while (parent[currentChild]!=currentChild){
			currentChild = parent[currentChild];
			count++;
		}
		height[currentChild]=count;
	}
}


