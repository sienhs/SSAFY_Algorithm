package boj.DFS_BFS.백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_10971 {
	public static int N;
	public static int[][] citys;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		citys = new int[N][N];
		visited = new boolean[N];
		for(int i =0;i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				citys[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		visited[0] = true;
		dfs(1, 0, 0);
		System.out.println(minDistance);
	}
	public static int minDistance = Integer.MAX_VALUE;
	public static void dfs(int depth, int cost, int prev) {
		if(cost > minDistance) return;
		if(depth == N) {
			if(citys[prev][0] != 0) {
				cost+=citys[prev][0];
				minDistance = Math.min(cost, minDistance);
			}
		}
		for(int i = 0;i <N;i++) {
			if(!visited[i] && citys[prev][i] != 0) {
				visited[i] = true;
				dfs(depth+1, cost+citys[prev][i], i);
				visited[i] = false;
			}
		}
	}
}
