package boj;

import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static char[][] board;
	static int[][] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[M][N];
		dist = new int[M][N];
		for(int i = 0; i < M;i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		bfs();
		
		System.out.println(dist[M-1][N-1]);
		
	}
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		dist[0][0] = 0;
		q.offer(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int x = n[0], y = n[1];
			
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= M || ny >= N || nx < 0 | ny < 0) continue;
				
				int cost = board[nx][ny] == '1' ? 1 : 0;
				
				if(dist[x][y] + cost < dist[nx][ny]) {
					dist[nx][ny] = dist[x][y] + cost;
					if(board[nx][ny] == '0') {
						q.addFirst(new int[]{nx, ny});
					}else q.addLast(new int[] {nx, ny});
				}
				
			}
		}
	}
}
