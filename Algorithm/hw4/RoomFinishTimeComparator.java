//File name: RoomFinishTimeComparator.java
//Implement a comparator for the priority queue of jobs

import java.util.*;

public class RoomFinishTimeComparator implements Comparator<Room>
{
	public int compare(Room first, Room second)
	{
		// sort the queue based on the finish time of the jobs
		if (first.lastFinishTime < second.lastFinishTime)
			return -1;
		else if (first.lastFinishTime > second.lastFinishTime)
			return 1;
		else
			return 0;
	}
}


