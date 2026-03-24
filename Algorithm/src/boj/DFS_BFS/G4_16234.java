package boj.DFS_BFS;

import java.util.*;


import java.io.*;

public class G4_16234 {
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
		
		while(true) {
			isMoved = false;
			dfs();
			if(!isMoved) break;
			days++;
		}
		
		
		System.out.println(days);
	}
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	public static int days = 0;
	public static boolean isMoved;
	public static void dfs() {
		
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					List<Node> link = new ArrayList<>();
					Queue<Node> q = new LinkedList<>();
					Node start = new Node(i, j);
					q.offer(start);
					link.add(start);
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Node n = q.poll();
						int x = n.x;
						int y = n.y;
						
						for(int t = 0; t < 4; t++) {
							int nx = x + dx[t];
							int ny = y + dy[t];
							
							if(nx < N && ny < N && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
								int diff = Math.abs(map[x][y] - map[nx][ny]);
								if(diff >= L && diff <= R) {
									q.offer(new Node(nx, ny));
									link.add(new Node(nx, ny));
									visited[nx][ny] = true;
								}
							}
							
							
							
						}
					}
					if(link.size() > 1) {
						isMoved = true;
						int total = 0;
						for(Node avg : link) {
							total+=map[avg.x][avg.y];
						}
						total = total / link.size();
						for(Node avg : link) {
							map[avg.x][avg.y] = total;
						}	
					}
					
					
				}
			}
		}
	}
}
