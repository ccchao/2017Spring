// File name: Edge.java
// Every edge contains two nodes and the weight.

public class Edge
{
	public int first;
	public int second;
	public int weight;

	// constructor
	public Edge (int a, int b, int w)
	{
		first=a;
		second=b;
		weight=w;
	}

	// constructor
	public Edge ()
	{
		first=0;
		second=0;
		weight=0;
	}
}


