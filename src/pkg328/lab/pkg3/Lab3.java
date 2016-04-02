package pkg328.lab.pkg3;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab3 {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	double quickAvg = 0, insertAvg = 0;
	int n = 10000, numLoops = 30; //SIZE OF ARRAY
	ArrayList<Integer> arr = new ArrayList();
	Random rand = new Random();

//        System.out.println("What size do you want your array?");
//	n = input.nextInt();
	
	//run the sorts 30 times
	for (int j = 0; j < numLoops; j++) {
	   
	    //~~~~~~~~~~~~~~~~~~~~~~~QUICK SORT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	    //initialize array with n number of elements
	    for (int i = 0; i < n; i++) {
		arr.add(7000 - rand.nextInt(14000));
	    }
	    //run quicksort and calculate time
	    double quickTime = System.nanoTime();
	    Sorter.quickSort(arr);
	    quickTime = (System.nanoTime() - quickTime) / 1000000;
	    quickAvg += quickTime;
//	    System.out.println("Quicksort Runtime: " + quickTime + "ms");

	    
	    //~~~~~~~~~~~~~~~~~~~~INSERTION SORT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	    //initialize array with n number of elements
	    for (int i = 0; i < n; i++) {
		arr.set(i, 7000 - rand.nextInt(14000));
	    }
	    //run insertion sort and calculate time
	    double insertTime = System.nanoTime();
	    Sorter.insertionSort(arr);
	    insertTime = (System.nanoTime() - insertTime) / 1000000;
	    insertAvg += insertTime;
//	    System.out.println("Insertion Sort Runtime: " + insertTime + "ms\n");
	}
	
	//CALCULATE AVERAGE RUN TIME OF EACH
	quickAvg = quickAvg / 30;
	insertAvg = insertAvg / 30;
	System.out.println("The average runtime of QUICK Sort was: " + quickAvg + "ms");
	System.out.println("The average runtime of INSERTION Sort was: " + insertAvg + "ms");
    }
}
