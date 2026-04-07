package boj.시뮬;

import java.io.*;
import java.util.*;

public class G4_20056 {
	static int N, M, K;
	static List<Fireball>[][] board;
	static final int[] dr = {-1, -1,  0,  1, 1,  1,  0, -1};
	static final int[] dc = { 0,  1,  1,  1, 0, -1, -1, -1};
	static List<Fireball> fbs = new ArrayList<>();
	static class Fireball{
		int row, col, mass, speed, direction;
		public Fireball(int r, int c, int m, int s, int d) {
			this.row = r;
			this.col = c;
			this.mass = m;
			this.speed = s;
			this.direction = d;
		}
		public void move() {
			for(int i =0; i < speed;i++) {
				int nr = row + dr[direction];
				int nc = col + dc[direction];
				
				if(nr >= N) nr = nr%N;
				if(nr < 0) nr = N-1;
				if(nc >= N) nc = nc%N;
				if(nc < 0) nc = N-1;
				
				row = nr;
				col = nc;
			}
			board[row][col].add(this);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new ArrayList[N][N];
		
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < N;j++) {
				board[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fbs.add(new Fireball(r, c, m, s, d));
		}
		for(int i = 0; i < K;i++) {
			for(int cli = 0; cli < N;cli++) {
				for(int clj = 0; clj < N;clj++) {
					board[cli][clj] = new ArrayList<>();
				}
			}
			move();
			fbs = new ArrayList<>();
			for(int r = 0; r < N;r++) {
				for(int c = 0; c < N;c++) {
					if(board[r][c].size()>=2) {
						fbs.addAll(sumFireball(board[r][c]));
					}else if(board[r][c].size() == 1) {
						fbs.add(board[r][c].get(0));
					}
				}
			}
			
		}
		int resultMass = 0;
		for(Fireball fb : fbs) {
			resultMass+=fb.mass;
		}
		System.out.println(resultMass);
	}
	public static List<Fireball> sumFireball(List<Fireball> list) {
		int row=list.get(0).row, col = list.get(0).col;
		int totalMass = 0;
		int totalSpeed = 0;
		int hol = 0;
		int jak = 0;
		for(Fireball fb : list) {
			totalMass+=fb.mass;
			totalSpeed+=fb.speed;
			if(fb.direction%2==0) jak++;
			else hol++;
		}
		int[] newDirection;
		if(hol > 0 && jak > 0) newDirection = new int[] {1, 3, 5, 7};
		else newDirection = new int[] {0,2,4,6};
		
		
		List<Fireball> newFbs = new ArrayList<>();
		
		if(totalMass/5 == 0) return newFbs; // 질량이 0이면 소멸(빈 리스트 반환)
		
		for(int dir : newDirection) {
			newFbs.add(new Fireball(row, col,totalMass/5, totalSpeed/list.size(),dir));
		}
		return newFbs;
 	}
	public static void move() {
		Queue<Fireball> q = new LinkedList<>();
		q.addAll(fbs);
		while(!q.isEmpty()) {
			Fireball fb = q.poll();
			fb.move();
		}
		
	}
}
