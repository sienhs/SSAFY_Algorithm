package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class G5_16928 {
	public static int[][] board = new int[10][10];
	public static int N, M;
	public static int[][] stairs;
	public static int[][] snakes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stairs = new int[N][2];
		snakes = new int[M][2];
		for(int i = 0;i <N;i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i][0] = Integer.parseInt(st.nextToken());
			stairs[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i <M;i++) {
			st = new StringTokenizer(br.readLine());
			snakes[i][0] = Integer.parseInt(st.nextToken());
			snakes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(minVisited, Integer.MAX_VALUE);
		dfs(1, 0);
		System.out.println(min);
		
	}
	public static int min = Integer.MAX_VALUE;
	public static int[] minVisited = new int[101];
	public static void dfs(int curLocation, int count) {
		if(count >= minVisited[curLocation]) {
			return;
		}
		if(curLocation == 100) {
			min = Math.min(min, count);
			return;
		}
		
		minVisited[curLocation] = count;
		
		for(int dice = 1; dice <= 6; dice++) {
			
			int loc = curLocation + dice;
			if(loc > 100) continue;
			for(int i = 0; i < N;i++) {
				if(loc == stairs[i][0]) {
					loc = stairs[i][1];
					
				}
			}
			for(int i = 0; i < M;i++) {
				if(loc == snakes[i][0]) {
					loc = snakes[i][1];
				}
			}
			
			dfs(loc, count+1);
			
		}
	}
}
