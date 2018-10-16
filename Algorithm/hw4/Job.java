// File name: Job.java
// Every job contains a label, the start time, and the finish time.

public class Job
{	
	public char label;
	public int startTime;
	public int finishTime;

	//constructor
	public Job ()
	{	
		label='x';
		startTime=0;
		finishTime=0;
	}

	//constructor
	public Job (char l, int s, int f)
	{
		label=l;
		startTime=s;
		finishTime=f;
	}
}



