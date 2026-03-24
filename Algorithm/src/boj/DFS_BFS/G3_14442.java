package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_14442 {
	
	public static int N, M, K;
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
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
		boolean[][][] visited = new boolean[11][N][M];
		
		q.offer(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			////////////////////////////
			// 노드 불러오기
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			
			if(x == N-1 && y == M-1) return n.dist; // 엔드포인트
			
			int hmBreak = n.hmBreak;
			int dist = n.dist;
			///////////////////////////
			
			
			for(int t = 0; t< 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
				
				if(map[nx][ny] == 1) {
					if(hmBreak < K && !visited[hmBreak][nx][ny]) {
						q.offer(new Node(nx, ny, hmBreak+1, dist+1));
						
						visited[hmBreak][nx][ny] = true;
					}else {
						continue;
					}
				}else {
					if(!visited[hmBreak][nx][ny]) 
					q.offer(new Node(nx, ny, hmBreak, dist+1));
					visited[hmBreak][nx][ny] = true;
				}				
			}
		}
		
		return -1;
		
		
	}
	public static class Node {
		int x, y, dist;
		int hmBreak;
		public Node(int x, int y, int hmBreak, int dist) {
			this.x = x;
			this.y = y;
			this.hmBreak = hmBreak;
			this.dist = dist;
		}
	}
	
	
	
}
