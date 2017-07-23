package com.anubhav.leetcode;
//
public class BurstBaloon {

	public static void main(String args[]){

		int ans=new BurstBaloon().maxCoins(new int[]{3,1,5,8});
		System.out.println(ans);
	}
	public int maxCoins(int[] nums) {
		
		/* 
		 * removing all the zeros
		 */
		int num[]=new int [nums.length+2];
		num[0]=1;
		int n=1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				num[n]=nums[i];
				n++;
			}
		}
		num[n]=1;
		
		int burst[][]=new int[n+1][n+1];
		return burstbaloon(num, 0,n, burst);   
	}
	
	public int burstbaloon(int num[], int left, int right, int burst[][]){
		if(left ==right-1) return 0;
		if(burst[left][right]>0) return burst[left][right];
		int ans=0;
		for(int i=left+1;i<right;i++){
			ans= Math.max(ans, num[left]*num[i]*num[right] +
					burstbaloon(num, left, i, burst) + 
					burstbaloon(num, i, right, burst));
		}
		burst[left][right]=ans;
		return ans;
	}
}
