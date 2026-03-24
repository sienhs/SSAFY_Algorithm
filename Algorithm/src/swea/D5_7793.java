package swea;

import java.io.*;
import java.util.*;
public class D5_7793 {
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
	
	public static Queue<Node> q;
	public static Node J;
	public static Node F;
	public static Node D;
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			miro = new char[R][C];
			visited = new boolean[R][C];
			
			for(int row = 0; row < R; row++) {
				String line = br.readLine();
				for(int col = 0; col < C;col++) {
					miro[row][col] = line.charAt(col);
					if(miro[row][col] == 'S') {
						J = new Node(row, col, 0, 0);
					}else if(miro[row][col] =='*') {
						q.offer(new Node(row, col, 1, 0));	
					}else if(miro[row][col] == 'D') {
						D = new Node(row, col, 0, 0);
					}
				}
			}
			
			q.offer(J);
			visited[J.x][J.y] = true;
			
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			bfs();
			System.out.println(sb);
		}
		
		
	}
	
	public static void bfs() {

		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			
			
			// 0 = jihun, 1 = fire
			
//			if(n.whoami == 0) {
//				if(x == D.x && y == D.y) {
//					sb.append(n.dist + 1);
//					return;
//				}
//			}
			
			for(int t = 0; t < 4; t++) {
				int nx = x + dx[t];
				int ny = y + dy[t];
				
				if(nx >= R || ny >= C || nx < 0|| ny < 0) continue;
				
				if(miro[nx][ny] == 'X') continue;
				
				
				if(n.whoami == 1) {
					if(miro[nx][ny] == '.' || miro[nx][ny] == 'S') {
						miro[nx][ny] = '*';
						q.offer(new Node(nx, ny, 1, 0));
					}
					
				}else {
					if(miro[nx][ny] == 'D') {
						sb.append(n.dist + 1);
						return;
					}
					if(miro[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, 0, n.dist+1));
					}
				}
				
					
			}
			
			
		}
		sb.append("GAME OVER");
	}
}
