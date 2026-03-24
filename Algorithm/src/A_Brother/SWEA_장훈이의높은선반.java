package A_Brother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_장훈이의높은선반 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<T+1;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] people = new int[N];
			st = new StringTokenizer(br.readLine());
			int total = 0;
			for(int i = 0; i < N;i++) {
				people[i] = Integer.parseInt(st.nextToken());
				total+=people[i];
			}
			boolean[] dp = new boolean[total+1];
			dp[0] = true;
			for(int p : people) {
				for(int i = total; i >= p;i--) {
					if(dp[i-p]) dp[i] = true;
				}
			}
			
			int result = 0;
			for(int i = B;i <= total;i++) {
				if(dp[i]) {
					result = i -B;
					break;
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
