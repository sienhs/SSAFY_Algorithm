package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7569 {
	public static int height, row, col;
	public static int [][][] Toms;
	public static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		Toms = new int[height][row][col];
		
		boolean searchedTomato = false;
		for(int h = 0; h < height;h++) {
			for(int r = 0; r < row; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < col; c++) {
					int temp = Integer.parseInt(st.nextToken());
					Toms[h][r][c] = temp;
					if(temp == 1) q.offer(new Node(h, r, c));
					if(temp == 0) searchedTomato = true;
				}
			}
		}
		if(searchedTomato) System.out.println(changeTomatoStatus());
		else System.out.println(0);
	}
	public static int[] dr = {0,0,1,-1};
	public static int[] dc = {1,-1,0,0};
	public static int changeTomatoStatus() {
		int sec = 0;
		while(!q.isEmpty()) {
			sec ++;
			int qsize = q.size();
			
			for(int qs = 0; qs < qsize; qs++) {
				Node node = q.poll();
				int h = node.h;
				int r = node.r;
				int c = node.c;
				
				for(int t = 0; t < 4; t++) {
					int nr = r + dr[t];
					int nc = c + dc[t];
					
					if(nr >= row || nr < 0 || nc < 0 || nc >= col) continue;
					
					if(Toms[h][nr][nc] == 0) {
						Toms[h][nr][nc] = Toms[h][nr][nc] + 1;
						q.offer(new Node(h, nr, nc));
					}
				}
				if(h-1 >= 0) {
					if(Toms[h-1][r][c] == 0) {
						Toms[h-1][r][c] = Toms[h-1][r][c] + 1;
						q.offer(new Node(h-1, r, c));
					}
				}
				if(h+1 < height) {
					if(Toms[h+1][r][c] == 0) {
						Toms[h+1][r][c] = Toms[h+1][r][c] + 1;
						q.offer(new Node(h+1, r, c));
					}
					
				}
				
			}
		}
		int max = 0;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < row; j++) {
				for(int l = 0; l < col; l++) {
					if(Toms[i][j][l] == 0) return -1;
					if(Toms[i][j][l] > max) max = Toms[i][j][l];
				}
			}
		}
		return sec-1;
	}
	public static class Node {
		int h, c, r;
		public Node(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
}
