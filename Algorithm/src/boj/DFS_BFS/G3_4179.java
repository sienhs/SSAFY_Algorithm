package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_4179 {
	public static class Node{
		int x, y;
		int whoami;
		int dist;
		public Node(int x, int y, int whoami, int dist) {
			this.x = x;
			this.y = y;
			this.whoami = whoami;
			this.dist = dist;
		}
	}
	public static int R, C;
	public static char[][] miro;
	public static boolean[][] visited;
	
	public static Queue<Node> q = new LinkedList<>();
	public static Node J;
	public static Node F;
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		miro = new char[R][C];
		visited = new boolean[R][C];
		
		for(int row = 0; row < R; row++) {
			String line = br.readLine();
			for(int col = 0; col < C;col++) {
				miro[row][col] = line.charAt(col);
				if(miro[row][col] == 'J') {
					J = new Node(row, col, 0, 0);
				}else if(miro[row][col] =='F') {
					q.offer(new Node(row, col, 1, 0));
					
				}
			}
		}
		bfs();
	}
	
	public static void bfs() {
		
		q.offer(J);
		visited[J.x][J.y] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			
			
			// 0 = jihun, 1 = fire
			
			if(n.whoami == 0) {
				if(x == 0 || x == R-1 || y == 0 || y == C-1) {
					System.out.println(n.dist + 1);
					return;
				}
			}
			
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= R || ny >= C || nx < 0|| ny < 0) continue;
				if(miro[nx][ny] == '#') continue;
				if(miro[nx][ny] == 'F') continue;
				
				if(n.whoami == 1) {
					miro[nx][ny] = 'F';
					q.offer(new Node(nx, ny, 1, 0));
				}else {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, 0, n.dist+1));
					}
				}
				
					
			}
			
			
		}
		System.out.println("IMPOSSIBLE");
	}
}
