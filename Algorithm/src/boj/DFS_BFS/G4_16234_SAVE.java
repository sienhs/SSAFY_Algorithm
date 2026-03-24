package boj.DFS_BFS;

import java.util.*;
import java.io.*;

public class G4_16234_SAVE {
	public static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int N, L, R;
	public static int[][] map;
	public static List<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list.add(new Node(0,0));
		while(!list.isEmpty()) {
			list = new ArrayList<>();
			// 더 검사할 나라가 있는지 탐색
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(map[i][j] >= L && map[i][j] <= R) {
						boolean isOk = false;
						for(int t = 0; t < 4;t++) {
							int nx = i + dx[t];
							int ny = j + dy[t];
							
							if(nx >= N || ny >= N || nx < 0 || ny < 0 || map[nx][ny] < L || map[nx][ny] > R) continue;
							isOk = true;
						}
						if(isOk) list.add(new Node(i, j));
					}
					// 인구이동이 필요한 나라가 2개 이상 있다면.
					dfs();
				}
			}
		}
		
	}
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	public static int days = 0;
	public static void dfs() {
		Queue<Node> q = new LinkedList<>();
		
		// 사전에 찾아놓은 국경선 후보들
		if(list.isEmpty()) return;
		for(Node v : list) {
			q.offer(v);
			List<Node> link = new ArrayList<>();
			visited = new boolean[N][N];
			visited[v.x][v.y] = true;
			
			while(!q.isEmpty()) {
				Node n = q.poll();
				int x = n.x;
				int y = n.y;
				
				for(int t = 0; t < 4; t++) {
					int nx = x + dx[t];
					int ny = y + dy[t];
					
					if(nx >= N || ny >= N || nx < 0 || ny < 0 || map[nx][ny] < L || map[nx][ny] > R) continue;
					if(visited[nx][ny]) continue;
					
					q.offer(new Node(nx, ny));
					link.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
			
			// 인구이동(평균화)
			int total = 0;
			for(Node avg : link) {
				total+=map[avg.x][avg.y];
			}
			total /= link.size();
			for(Node avg : link) {
				map[avg.x][avg.y] = total;
			}
			
		}
		days++;
	}
}
