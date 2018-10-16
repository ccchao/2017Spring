//File name: StartTimeComparator.java
//Implement a comparator for the priority queue of jobs

import java.util.*;

public class StartTimeComparator implements Comparator<Job>
{
	public int compare(Job first, Job second)
	{
		// sort the queue based on the start time of the jobs
		if (first.startTime < second.startTime)
			return -1;
		else if (first.startTime > second.startTime)
			return 1;
		else
			return 0;
	}
}


