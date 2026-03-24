package boj.DP;

import java.util.ArrayList;
import java.util.Scanner;

public class S2_11060 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int [] arr = new int[N];
		for (int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int []dp = new int[N];
		
		for(int i = 0;i<N;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for(int i = 0; i < N;i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			for(int j = 1;j <= arr[i]; j++) {
				if(i+j < N) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}
		System.out.println(dp[N-1] == Integer.MAX_VALUE ? "-1" : dp[N-1]);
	}
}
