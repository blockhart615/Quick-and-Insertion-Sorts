/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg328.lab.pkg3;

import java.util.ArrayList;

/**
 *
 * @author Brett
 */
public class Sorter {
    
    /**
     * perform Quicksort
     * @param arr - array to be sorted
     * @return sorted arraylist
     */
    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
	if (arr.size() < 2) {
	    return arr;
	}

	ArrayList<Integer> left = new ArrayList();
	ArrayList<Integer> right = new ArrayList();
	ArrayList<Integer> equal = new ArrayList();
	ArrayList<Integer> choosePivot = new ArrayList();

	//Create and choose pivot
	choosePivot.add(arr.get(0));
	choosePivot.add(arr.get(arr.size() / 2));
	choosePivot.add(arr.get(arr.size() - 1));
	insertionSort(choosePivot);
	int pivot = choosePivot.get(1);

	//creates subarrays
	for (Integer i : arr) {
	    if (i < pivot) {
		left.add(i);
	    } else if (i > pivot) {
		right.add(i);
	    } else if (i == pivot) {
		equal.add(i);
	    }
	}
	
	//recursively call quicksort on left subarray
	left = quickSort(left);
	//add elements that are equal to the pivot to the end of left array
	for (Integer i : equal) {
	    left.add(i);
	}
	//recursively call quicksort on right subarray
	right = quickSort(right);
	
	//clear original array, and populate it 
	//with contents of left, equal, and right subarrays.
	arr.clear();
	for (Integer i : left) {
	    arr.add(i);
	}
	for (Integer i : right) {
	    arr.add(i);
	}
	return arr;
    }

    /**
     * Perform Insertion Sort
     * @param arr
     * @return 
     */
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arr) {
	for (int i = 0; i < arr.size(); i++) {
	    int copyNumber = arr.get(i);
	    int j = i;
	    while (j > 0 && copyNumber < arr.get(j - 1)) {
		arr.set(j, arr.get(j - 1));
		j--;
	    }
	    arr.set(j, copyNumber);
	}
	return arr;
    }
    
    
}
