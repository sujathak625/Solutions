import java.util.ArrayList;
import java.util.TreeSet;


public class NthLargest {
	public static void main(String[] args) {

		int[] array = { 0, 5, 7, 34, 20, 3, 44 };

		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		// Loop over the array
		for (int i = 0; i < array.length; i++) {

			// If we've found a new highest number...
			if (array[i] > highest) {

				// ...shift the current highest number to second highest
				secondHighest = highest;

				// ...and set the new highest.
				highest = array[i];
			} else if (array[i] > secondHighest)
				// Just replace the second highest
				secondHighest = array[i];
		}
		System.out.println("secondHighest"+secondHighest);
	}
	

	}   
		    
		


