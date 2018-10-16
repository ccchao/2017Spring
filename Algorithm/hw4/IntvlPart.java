// File name: IntvlPart.java
// Implement the interval partitioning algorithm discussed in class and run it against the problem instance shown below. 
// In this problem instance, there are 10 jobs, labeled a through j, with the start time and end time shown on the timeline at the bottom.
// The program should output (1) the room allocated each time a new job is booked during the run and (2) the list of all jobs allocated to each room after the run.

import java.util.*;
import java.lang.String;

public class IntvlPart
{
	public static void main (String[] args)
	{
		int i, flag=0;

		// number of allocated classrooms	
		int rooms=0;
		Room earliestFinishRoom;
		Job currentJob;
	
		// implement the comparator for the priority queue of jobs
		Comparator<Job> comparator = new StartTimeComparator();
		// create a priority queue to store all jobs and sort jobs by start time
		PriorityQueue<Job> jobsQueue = new PriorityQueue<Job>(10, comparator);
		// add all jobs into the priority queue
		jobsQueue.add(new Job('a', 0, 3));
		jobsQueue.add(new Job('b', 0, 7));
		jobsQueue.add(new Job('c', 0, 3));
		jobsQueue.add(new Job('d', 4, 7));
		jobsQueue.add(new Job('e', 4, 10));
		jobsQueue.add(new Job('f', 8, 11));
		jobsQueue.add(new Job('g', 8, 11));
		jobsQueue.add(new Job('h', 10, 15));
		jobsQueue.add(new Job('i', 12, 15));
		jobsQueue.add(new Job('j', 12, 15));
		

		// a queue to store all rooms that are allocated
		// implement the comparator for the priority queue of jobs
		Comparator<Room> comparator3 = new RoomFinishTimeComparator();
		// create a priority queue for rooms to store all jobs in that room and sort jobs by finish time
		PriorityQueue<Room> allRooms = new PriorityQueue<Room>(10, comparator3);

		// prepare the first room
		allRooms.add(new Room(0));
		rooms++;
		
		for (i=0; i<10; i++){
			// choose a job to process
			currentJob = jobsQueue.poll();

			//System.out.printf("Current job: %c %d %d\n", currentJob.label, currentJob.startTime, currentJob.finishTime);
			printTime(currentJob);

			// search all rooms 
			Iterator<Room> roomList = allRooms.iterator();
			while (roomList.hasNext()) {
				earliestFinishRoom = roomList.next();

				// current job is compatible with a room
				if (currentJob.startTime >= earliestFinishRoom.lastFinishTime){
					// add this job to a room
					earliestFinishRoom.addJob(currentJob);
					// change the last finish time
					earliestFinishRoom.lastFinishTime=currentJob.finishTime;

	
					System.out.printf("This job is allocated to an existing room %d\n\n", earliestFinishRoom.roomNumber);
					flag=1;
					break;
				}
			}
			// this job is not compatible with any room
			if (flag==0){
				// add this job to a new room
				earliestFinishRoom = new Room(currentJob, rooms);
				
				// add this new room to the room list
				allRooms.add(earliestFinishRoom);
				rooms++;

				System.out.printf("This job is allocated to a new room %d\n\n", earliestFinishRoom.roomNumber);
			}
			flag=0;
		}

		System.out.printf("The total number of rooms: %d\n", rooms);
		while ((earliestFinishRoom = allRooms.poll()) != null){
			System.out.printf("Room %d: ", earliestFinishRoom.roomNumber);
			while ((currentJob = earliestFinishRoom.pollJob()) != null){
				System.out.printf("%c ", currentJob.label);
			}
			System.out.println();
		}
		
	}

	public static void printTime (Job job)
	{
		String[] printList={"9","9:30","10","10:30","11","11:30","12","12:30","1","1:30","2","2:30","3","3:30","4","4:30"};
		System.out.printf("Current job: %c %s %s\n", job.label, printList[job.startTime], printList[job.finishTime]);
	}

}

