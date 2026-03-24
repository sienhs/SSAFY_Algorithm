package boj.DFS_BFS;

import java.util.*;
import java.io.*;
public class S1_2178 {
	public static int N, M;
	public static char[][] miro;
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			miro[i] = br.readLine().toCharArray();
		}
		
		bfs();
		
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 1});
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
				if(miro[nx][ny] == '0') continue;
				if(visited[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				cnt++;
				
			}
			
		}
		System.out.println(cnt);
	}
}
