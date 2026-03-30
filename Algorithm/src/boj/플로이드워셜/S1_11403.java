package boj.플로이드워셜;

import java.util.*;
import java.io.*;

public class S1_11403 {
	static int N, M;
	static boolean[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dist = new boolean[N][N];
		
		
		
		// 인접행렬 입력
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0;j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				dist[i][j] = input == 1? true : false;
			}
		}
		for(int k = 0; k < N;k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N;j++) {
					if(dist[i][k] && dist[k][j]) {
						dist[i][j] = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(boolean[] arr : dist) {
			for(boolean n : arr) {
				if(n) sb.append(1);
				else sb.append(0);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}