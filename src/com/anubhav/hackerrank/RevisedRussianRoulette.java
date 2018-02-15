package com.anubhav.hackerrank;
import java.util.Scanner;

public class RevisedRussianRoulette {
	
	
	static int[] revisedRussianRoulette(int[] doors) {
		int ans[]=new int[2];
		int i=0, count=0;
		while(i<doors.length) {
			if(doors[i]==1) {
				count++;
				i++;
			}
			i++;
		}
        ans[0]=count;
        int ones=0;
        for(i=0;i<doors.length;i++) {
        	if(doors[i]==1) {
        		ones++;
        	}
        }
        ans[1]=ones;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
