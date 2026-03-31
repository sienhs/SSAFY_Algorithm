package SAMSUNG_A;

import java.util.*;
import java.io.*;

public class G4_4485_보급로백준 {
	public static int N;
	public static int[][] board;
	public static int[][] dist;
	static final int INF = Integer.MAX_VALUE / 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = 0;
		while((N = Integer.parseInt(br.readLine()))!= 0) {
			board = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			System.out.println("Problem " + ++testcase+": "+dijkstra());
			
		}
		
		
		
		
	}
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	public static class Node{
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static int dijkstra() {
		for(int[] arr : dist) Arrays.fill(arr, INF);
		dist[0][0] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.time - b.time);
		pq.offer(new Node(0,0,0));
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int x = n.x, y = n.y;
			int time = n.time;
			
			if(time > dist[x][y]) continue;
			
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
				
				int newTime = time + board[nx][ny];
				if(newTime < dist[nx][ny]) {
					dist[nx][ny] = newTime;
					pq.offer(new Node(nx, ny, newTime));
				}
			}
		}
		
		
		return dist[N-1][N-1] + board[0][0];
	}
}
