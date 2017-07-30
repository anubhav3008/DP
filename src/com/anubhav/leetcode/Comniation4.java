package com.anubhav.leetcode;


//https://leetcode.com/problems/combination-sum-iv/#/description
public class Comniation4 {

	public static void main(String[] args) {
		int ans=new Comniation4().combinationSum4(new int[]{1,2,3}, 4);
		System.out.println(ans);

	}
	
	
	   public int combinationSum4(int[] nums, int target) {
		   
		   int f[]=new int[target+1];
		   f[0]=1;
		   
		   for(int i=1;i<=target;i++){
			   for(int j=0;j<nums.length;j++){
				   if(i-nums[j]>=0)
					   f[i]+=f[i-nums[j]];
			   }
		   }
		   
		   return f[target];
		
	    }
	   
	   
}
