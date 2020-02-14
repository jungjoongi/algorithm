package com.jungjoongi.algorithm.step01;

public class Array {

    /*
        배열 swap 알고리즘
     */

    public static void main(String[] args) {
    	
    	int[] beforeSwapArray = {1,6,2,3,5,12,53,7234,123,5,12};
    	System.out.print("befor :: ");
    	for(int i = 0; i < beforeSwapArray.length; i++) {
    		System.out.print(beforeSwapArray[i] + " ");
    	}
    	System.out.println("\n");
    	
    	System.out.print("after :: ");
    	int[] afterSwapArray = beforeSwapArray;
    	reverseArray(afterSwapArray);
    	for(int i = 0; i < afterSwapArray.length; i++) {
    		System.out.print(afterSwapArray[i] + " ");
    	}
    	System.out.println("\n");

    }
    
    
    static void reverseArray(int[] arr) {
    	int length = arr.length;
    	for (int i = 0; i < length / 2; i++) {
    		swap(arr, i, length-1);
    	}
    }
    
    static void swap(int[] arr, int cursor, int length) {
    	int temp = arr[cursor];
    	arr[cursor] = arr[length-cursor];
    	arr[length-cursor] = temp;
    }
    
    
/*
 * Result *******************************
 * befor :: 1 6 2 3 5 12 53 7234 123 5 12 
 * after :: 12 5 123 7234 53 12 5 3 2 6 1 
 * **************************************
 */

    
}
