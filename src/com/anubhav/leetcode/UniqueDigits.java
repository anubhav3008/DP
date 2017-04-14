package com.anubhav.leetcode;
//https://leetcode.com/problems/count-numbers-with-unique-digits/#/description
public class UniqueDigits {

	public static void main(String[] args) {
		int n=new UniqueDigits().countNumbersWithUniqueDigits(11);
		System.out.println(n);

	}
	
 
	 public int countNumbersWithUniqueDigits(int n) {
	        if(n==0) return 1;
			 if(n==1) return 10;
		      	if(n>10) n=10;
			 	int s[]=new int[n+1];
			 	int m[]=new int[n+1];
			 	m[0]=1;m[1]=9;m[2]=81;
			 	int start=8;
			 	for(int i=3;i<=n;i++){
			 		m[i]=m[i-1]*start;
			 		start--;
			 	}
			 	s[1]=9;
			 	for(int i=2;i<=n;i++){
			 		s[i]=s[i-1]+m[i];
			 	}
		        return s[n]+1;
		  }

}
