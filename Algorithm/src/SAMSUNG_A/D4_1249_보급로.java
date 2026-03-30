package SAMSUNG_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class D4_1249_보급로 {
	public static int N;
	public static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1;tc++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				board[i] = str.toCharArray();
			}
			
			System.out.println("#"+tc+" "+bfs());
		}
	}
	public static boolean[][] visited;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0});
		visited[0][0] = true;
		int minTime = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];
			int time = cur[2];
			
			if(x == N-1 && y ==N-1) {
				minTime = Math.min(minTime, time);
			}
			
			for(int t = 0; t < 4;t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
				if(visited[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny, time+(int)board[nx][ny]- '0'});
				visited[nx][ny] = true;
			}
		}
		return minTime;
	}
}
