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
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				board[i] = str.toCharArray();
			}
			
			System.out.println("#"+tc+" "+bfs());
		}
	}

	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static final int INF = Integer.MAX_VALUE / 2;
	
	public static class Node{
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static int bfs() {
		int[][] dist = new int[N][N];
		for(int[] arr : dist) Arrays.fill(arr, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
		pq.offer(new Node(0,0,0));
		dist[0][0] = 0;
		
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int x = n.x, y = n.y;
			int time = n.time;
			
			if(time > dist[x][y]) continue;
			
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
				
				int newTime = time + board[nx][ny]-'0';
				
				if(newTime < dist[nx][ny]) {
					dist[nx][ny] = newTime;
					pq.offer(new Node(nx, ny, newTime));
				}
			}
		}
		
		
		
		
		return dist[N-1][N-1];
	}
}
