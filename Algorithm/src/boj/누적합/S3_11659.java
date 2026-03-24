package boj.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] S = new long[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i =1;i<N+1;i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int j = 0;j < M;j++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int sta = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			
			sb.append(S[ed]-S[sta-1]).append("\n");
			
			System.out.print(sb);
		}
		
	}
}
