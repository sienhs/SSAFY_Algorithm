package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2206 {
	
	public static int N, M;
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		
		
		System.out.println(bfs());
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[2][N][M];
		
		q.offer(new Node(0, 0, false, 1));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			if(x == N-1 && y == M-1) return n.dist;
			boolean isBreak = n.isBreak;
			int dist = n.dist;
			for(int t = 0; t< 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
				
				int status = isBreak ? 1 : 0;
				if(map[nx][ny] == 1) {
					if(!isBreak && !visited[1][nx][ny]) {
						q.offer(new Node(nx, ny, true, dist+1));
						visited[1][nx][ny] = true;
					}else {
						continue;
					}
				}else {
					if(!visited[status][nx][ny]) 
					q.offer(new Node(nx, ny, isBreak, dist+1));
					visited[status][nx][ny] = true;
				}
				// 	아래로 벽을 부쉈는지 안부쉈지에 따라 다음 노드부터의 값을 true, false로 주기
				
				
				
				
			}
			
			
		}
		
		return -1;
		
		
	}
	public static class Node {
		int x, y, dist;
		boolean isBreak = false;
		public Node(int x, int y, boolean isBreak, int dist) {
			this.x = x;
			this.y = y;
			this.isBreak = isBreak;
			this.dist = dist;
		}
	}
	
	
	
}
