package boj.DFS_BFS;

import java.util.*;
import java.io.*;
public class G5_7576 {
	public static int M, N;
	public static int[][] tomato;
	public static Queue<Node> q = new LinkedList<>();
	public static class Node{
		int x, y,d;
		public Node(int x, int y,int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		
		for(int i = 0;i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) q.offer(new Node(i, j, 0));
				
			}
		}
		
		System.out.println(bfs());
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int bfs() {
		int answer = 0;
		while(!q.isEmpty()) {
			
			Node t = q.poll();
			int x = t.x; int y = t.y; answer = t.d;
			
			for(int trace = 0; trace <4;trace++) {
				int nx = x + dx[trace];
				int ny = y + dy[trace];
				
				if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
				if(tomato[nx][ny] != 0) continue;
				
				tomato[nx][ny] = 1;
				q.offer(new Node(nx, ny, answer+1));
			}
			
		}
		for(int[] i : tomato) {
			for(int j : i) {
				if(j == 0) return -1;
			}
		}
		
		return answer;
	}
}
