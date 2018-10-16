//File name: EdgeComparator.java
//Implement a comparator for the priority queue of edgess

import java.util.*;

public class EdgeComparator implements Comparator<Edge>
{
	public int compare(Edge first, Edge second)
	{
		// sort the queue based on the weights of edges
		if (first.weight < second.weight)
			return -1;
		else if (first.weight > second.weight)
			return 1;
		else
			return 0;
	}
}


