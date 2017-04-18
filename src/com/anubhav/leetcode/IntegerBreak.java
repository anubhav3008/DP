package com.anubhav.leetcode;
//https://leetcode.com/problems/integer-break/#/description
public class IntegerBreak {

	public static void main(String[] args) {
		int ans=new IntegerBreak().integerBreak(6);
	//	System.out.println(ans);
	}
	
	 public int integerBreak(int n) {
	  int val[]=new int[n+1];
	  val[0]=0;
	  val[1]=1;
	  val[2]=1;
	  
	  
	  for(int i=3;i<=n;i++){
		  
		  for(int j=1;j<=Math.ceil(i/2);j++){
			  int m1=val[i-j]<i-j?i-j:val[i-j];
			  int m2=val[j]<j?j:val[j];
			  val[i]=Math.max(m1*m2, val[i]);
		  }
	//	 printArray(val);
	  }
	    
	 
	 return val[n];
	 }
	 
	 void printArray(int a[]){
		 for(int i: a){
			 System.out.print(i+" ");
		 }
		 System.out.println();
	 }

}
