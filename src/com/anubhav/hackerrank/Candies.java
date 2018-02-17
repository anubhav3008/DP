package com.anubhav.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/candies/problem


public class Candies {

	static long candies(long n, long[] a) {

		long dp[]= new long[(int) n];

		long i=1;
		dp[0]=1;
		while(i<n) {
			if(a[(int) i]>a[(int) (i-1)]) {
				dp[(int) i]=dp[(int) (i-1)]+1;
				i++;
			}
			else {
				long start=i-1;
				while(i < n && a[(int) i]<=a[(int) (i-1)]) {
					i++;
				}
				long j=i-1;
				dp[(int) j]=1;
				j--;
				while(j>=start) {
					if(j!=start) {
						if(j+1 <  n && a[(int) j]==a[(int) (j+1)]) {
							dp[(int) j]=1;
						}
						else
							dp[(int) j]=dp[(int) (j+1)]+1;
					}
					else {
						if(start==0 && a[(int) j]==a[(int) (j+1)]) {
							dp[(int) j]=1;
						}
						else
						{
							dp[(int) j]=Math.max(dp[(int) j], dp[(int) (j+1)]+1);
							
						}
					
					}
					j--;
				}
			}
		}
		long sum=0;
		for(long j=0;j<n;j++) {
	//		System.out.println(dp[(int)j]);
			sum+=dp[(int) j];
		}
		return sum;


	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long[] arr = new long[(int) n];
		for(long arr_i = 0; arr_i < n; arr_i++){
			arr[(int) arr_i] = in.nextLong();
		}
		long result = candies(n, arr);
		System.out.println(result);
		in.close();
	}

}
