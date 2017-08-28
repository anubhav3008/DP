package com.anubhav.leetcode;

public class MaximumSubarray {

	public static void main(String[] args) {
		int ans=new MaximumSubarray().maxSubArray(new int[]{-2,4,-3,10});
		System.out.println(ans);
	}
	
	public int maxSubArray(int[] nums) {
		int ans=0;
		int val=0;
		int i=0;
		int max=Integer.MIN_VALUE;
		while(i<nums.length){
			while(val>=0 && i<nums.length){
				val=val+nums[i];
				ans=Math.max(val, ans);
				max=Math.max(max, nums[i]);
				i++;	
				
			}
			val=0;
		}
		if(ans==0) return max;
		return ans;
        
    }

}
