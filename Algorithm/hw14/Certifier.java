// File name: Certifier.java
// Consider the certifier for the 3-Satisfiability problem (3-SAT) studied in class. The definition of the problem, certificate, and certifier are listed below.
//
// 3-SAT. Given a CNF formula, is there a satisfying truth assignment?
// Certificate. An assignment t of truth values to the n Boolean variables.
// Certifier. An algorithm which checks if, for the given assignment t, each clause has at least one true literal.
//
// Given the CNF formula encoded in your program as a String “(NOT x1 OR x2 OR x3) AND (x1 OR NOT x2 OR x3) AND (x1 OR x2 OR x4) AND (NOT x1 OR NOT x3 OR NOT x4)”, the program should certify if each of the following certificates is a satisfying truth assignment or not.
// (Encode each certificate as a String and parse it in your program code.) 
// Additionally, analyze the running time complexity of the certifier you implemented and submit a written report. Note that the running time complexity should be polynomial.
//
// (x1=1, x2=1, x3=0, x4=1)
// (x1=1, x2=1, x3=1, x4=1)
// (x1=0, x2=0, x3=0, x4=1)
// (x1=0, x2=1, x3=0, x4=1)

import java.util.*;

public class Certifier
{
	public static void main (String[] args)
	{
		String formula = "(NOT x1 OR x2 OR x3) AND (x1 OR NOT x2 OR x3) AND (x1 OR x2 OR x4) AND (NOT x1 OR NOT x3 OR NOT x4)";
		int[][] assignment = {{1,1,0,1}, {1,1,1,1}, {0,0,0,1}, {0,1,0,1}};

		int n=4; // number of variables
		int k=4; // number of clauses


		int i, x1, x2, x3, x4, j;
		String[] clause = new String[k];

		for (i=0; i<4; i++){ // number of certificates is not evaluated for the running time
			x1 = assignment[i][0];
			x2 = assignment[i][1];
			x3 = assignment[i][2];
			x4 = assignment[i][3];

			Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(formula);
     			while(m.find()) {
     				System.out.println(m.group(1));    
    			}
			/*
			for (j=0; j<k; j++){
				clause = formula.split("\\([.*+]\\)");
				System.out.println(clause[j]);
			}
			*/

			
		}

	}

	
}
