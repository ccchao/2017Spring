// File name: Room.java
// Every room will contain at least one room

import java.util.*;

public class Room
{
	private PriorityQueue<Job> roomQueue;
	public int lastFinishTime;
	public int roomNumber;

	//constructor
	public Room (int number)
	{
		// Initialize lastFin of every classroom to -1 (< 0)
		lastFinishTime=-1;
		roomNumber=number;

		// implement the comparator for the priority queue of jobs
		Comparator<Job> comparator2 = new FinishTimeComparator();
		// create a priority queue for rooms to store all jobs in that room and sort jobs by finish time
		roomQueue = new PriorityQueue<Job>(10, comparator2);

	}

	//constructor
	public Room (Job firstJob, int number)
	{
		roomNumber=number;
		
		// implement the comparator for the priority queue of jobs
		Comparator<Job> comparator2 = new FinishTimeComparator();
		// create a priority queue for rooms to store all jobs in that room and sort jobs by finish time
		roomQueue = new PriorityQueue<Job>(10, comparator2);

		roomQueue.add(firstJob);
		lastFinishTime=firstJob.finishTime;
	}

	public void addJob (Job newJob)
	{
		roomQueue.add(newJob);
	}

	public Job pollJob ()
	{
		return roomQueue.poll();
	}
}
