package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2667 {
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static List<Integer> danjis = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i ++) {
			String s = br.readLine();
			for(int j = 0; j < N; j ++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N ;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(danjis.size());
		Collections.sort(danjis);
		for(int i : danjis) System.out.println(i);
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void bfs(int x, int y) {
		if(visited[x][y]) return;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visited[x][y] = true; // 방문처리
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			
			
			cnt ++; // 넓이 증가
			
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if (nx >= N|| ny >= N || nx < 0 || ny < 0 ) continue; // out of index 검사
				
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
				
			}
		}
		danjis.add(cnt);
			
	}
}
