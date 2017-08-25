package com.anubhav.leetcode;
//https://leetcode.com/problems/partition-equal-subset-sum/description/
public class EqualPartition {

	public static void main(String[] args) {
		boolean ans=new EqualPartition().canPartition(new int[]{1,5,11,5});
		System.out.println(ans);

	}
	
	 public boolean canPartition(int[] nums) {
	     int s=0;  
		 for(int i=0;i<nums.length;i++){
	    	   s+=nums[i];
	       }
		 if(s%2!=0) return false;
		 int targetSum=s/2;
		 int dp[][]=new int[nums.length+1][targetSum+1];
	 
		 return canPartition(nums.length,targetSum,dp, nums);
	 
	 }
	 //dp => 0 means not calculated
	 //  => 1 means => true
	 // -1 means false
	 public boolean canPartition(int m,int target, int dp[][], int nums[]){
		 if(target<0 || m<0) {
			 return false;
		 }
		 if(target==0) {
			 dp[m][target]=1;
			 return true;
		 }
		 if(dp[m][target]!=0) return dp[m][target]==1;
		 boolean canPartition=false;
		 if(m>=1)
			 canPartition=canPartition(m-1, target-nums[m-1], dp, nums) || canPartition(m-1, target, dp, nums) ;
		 else
			 canPartition=canPartition(m-1, target, dp, nums) ;
		 if(canPartition) 
			 dp[m][target]=1;
		 else 
			 dp[m][target]=-1;
		 return dp[m][target]==1;
		 
	 }
	 

}
