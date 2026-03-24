package boj.DFS_BFS._01_BFS;

import java.util.*;
import java.io.*;

public class G4_2665 {
	static int N;
	static char[][] board;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		dist = new int[N][N];
		
		
		for(int i =0;i < N; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		bfs();
		
		System.out.println(dist[N-1][N-1]);
	}
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static int minChanged = 2499; // 2498
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		dist[0][0] = 0;
		q.offer(new int[] {0, 0}); // x y color
		
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int x = n[0]; int y = n[1];
	
			for(int t = 0; t < 4; t++) {
				
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
				
				int cost = (board[nx][ny] == '1') ? 0 : 1;
				
				
				if(dist[x][y] + cost < dist[nx][ny]) {
					dist[nx][ny] = dist[x][y] + cost;
					if(cost == 0) {
						q.addFirst(new int[] {nx, ny});
					}else q.addLast(new int[] {nx, ny});
				}
				
			}
			
			
		}
	}

}
