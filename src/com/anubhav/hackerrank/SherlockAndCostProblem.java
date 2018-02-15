package com.anubhav.hackerrank;


	
	import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

	//https://www.hackerrank.com/challenges/sherlock-and-cost/problem
	public class SherlockAndCostProblem {
	    static int cost(int[] arr) {
	    	int n= arr.length;
	    	int high=0;
	    	int low=0;
	    	for(int i=1;i<n;i++) {
	    		int m1=0; //low to low 1-1
	    		int m2=arr[i-1]-1; //high to low
	    		int m3=arr[i]-1; //low to high
	    		int m4= Math.abs(arr[i]-arr[i-1]); //high to high
	    	    
	    		int newhigh = Math.max(low+m3, high+m4);
	    		int newlow=Math.max(low+m1, high+m2);
	    		
	    		
	    		high=newhigh;
	    		low=newlow;
	    		
	    	//	System.out.println(high+" "+low);
	    	}
	    	return Math.max(high, low);
	     }

	 
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int[] arr = new int[n];
	            for(int arr_i = 0; arr_i < n; arr_i++){
	                arr[arr_i] = in.nextInt();
	            }
	            int result = cost(arr);
	            System.out.println(result);
	        }
	        in.close();
	    }
	}


