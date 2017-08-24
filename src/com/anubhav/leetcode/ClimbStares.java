package com.anubhav.leetcode;

public class ClimbStares {
	public static void main(String args[]){
		int ans=new ClimbStares().climbStairs(4);
		System.out.println(ans);
	}
	
	public int climbStairs(int n) {
        int s1=1;
        int s2=2;
        if(n<=1) return 1;
        if(n==2) return 2;
        int ans=0;
        for(int i=3;i<=n;i++){
        	ans=s1+s2;
        	s1=s2;
        	s2=ans;
        }
        return ans;
    }

}
