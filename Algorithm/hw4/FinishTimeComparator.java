//File name: FinishTimeComparator.java
//Implement a comparator for the priority queue of jobs

import java.util.*;

public class FinishTimeComparator implements Comparator<Job>
{
	public int compare(Job first, Job second)
	{
		// sort the queue based on the finish time of the jobs
		if (first.finishTime < second.finishTime)
			return -1;
		else if (first.finishTime > second.finishTime)
			return 1;
		else
			return 0;
	}
}


