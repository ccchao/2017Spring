// File name: Knapsack.java
// Implement the knapsack algorithm discussed in class, and run it twice against the set of items shown below, once with W = 10 and once with W = 11. (W is the constraint on total weight.) 
// The program should output the content of the memoization table M[0..n][0..W] each time a row is filled. 
// Additionally, the program should output the items included in the optimal set and the resulting maximum total value of the items included.
// Use the "bookkeeping" approach to retrieve the resulting optimal set of items. Here, the bookkeeping approach means storing a record of the case chosen in each step of the bottom-up iterative filling of the memoization table and then simply backtracking from M[n,W] "picking up" the winning case in each intermediate step traced back.

import java.util.*;

public class Knapsack
{
	// input five items
	public static int[][] item= {{0,0}, {1,1}, {6,2}, {18,5}, {22,6}, {28,7}};
	public static int[][] M;
	public static int[][] bookkeeping;

	public static void main (String[] args)
	{	
		int total;

		total = memoization (10);
		System.out.printf ("Items included in the optimal set: ");
		Find_Optimal_Subset (5, 10);
		System.out.printf ("\nMaximum total value of the items included: %d\n\n", total);
		total = memoization (11);
		System.out.printf ("Items included in the optimal set: ");
		Find_Optimal_Subset (5, 11);
		System.out.printf ("\nMaximum total value of the items included: %d\n", total);

	}

	public static int memoization (int W)
	{
		int i, w, wi, n=5;
	
		// initialize the memoization table
		M = new int[6][W+1];
		bookkeeping = new int[6][W+1];

		System.out.printf ("W = %d\n", W);

		for (w=0; w<=W; w++){
			M[0][w] = 0;
			bookkeeping[0][w] = 0;
			System.out.printf ("%2d ", M[0][w]);
		}
		System.out.println();
		for (i=1; i<=n; i++){
			for (w=0; w<=W; w++){
				wi = item[i][1]; // current weight
				if (wi > w){
					M[i][w] = M[i-1][w];
					bookkeeping[i][w] = w;
				}
				else{ // find the maximum
					if (M[i-1][w] > item[i][0]+M[i-1][w-wi]){
						M[i][w] = M[i-1][w];
						bookkeeping[i][w] = w;
					}
					else{
						M[i][w] =  item[i][0]+M[i-1][w-wi];
						bookkeeping[i][w] = w-wi;
					}
				}
				System.out.printf ("%2d ", M[i][w]);		
			}
			System.out.println();
		}

		return M[n][W];
	}

	public static void Find_Optimal_Subset (int i, int w)
	{
		// bookkeeping
		while (i!=0 && w!=0){
			if (bookkeeping[i][w] == w){ // item i is not selected
				i--;
			}
			else{ // item i is selected
				System.out.printf ("%d ", i);
				w = bookkeeping[i][w];
				i--;
			}
		}


		/* post-processing
		int wi=item[i][1]; // the weight of current item i

		if (i==0)
			return;
		if (w>=wi && M[i][w] == item[i][0] + M[i-1][w-wi] ){ // item i is selected
			System.out.printf ("%d ", i);
			Find_Optimal_Subset (i-1, w-wi);
		}
		else // item i is not selected
			Find_Optimal_Subset (i-1, w);
		*/
	}
}





