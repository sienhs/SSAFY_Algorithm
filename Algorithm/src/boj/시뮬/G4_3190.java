package boj.시뮬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_3190 {
	public static int N, K, L;
	public static class Node{
		int x, y;
		public Node(int x, int y, int info) {
			this.x = x;
			this.y = y;
		}
	}
	public static int[][] board;
	public static Queue<int[]> turn = new LinkedList<>();
	public static Queue<int[]> bam = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		K = Integer.parseInt(br.readLine());
		
		for(int i =0; i < K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			
			board[tempX-1][tempY-1] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i =0; i < L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int waitSec = Integer.parseInt(st.nextToken());
			int direction = st.nextToken().charAt(0);
			turn.offer(new int[] {waitSec, direction});
		}
		start();

	}
	//							 0이 기본값
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void start() {
		int x = 0; int y = 0;
		int trace = 0;
		int time = 0;
		board[x][y] = 2;
		bam.offer(new int[] {x, y});
		while(true) {
			time++;
			int nx = x + dx[trace];
			int ny = y + dy[trace];
			
			
			if(nx >= N || ny >= N || nx < 0 || ny < 0 || board[nx][ny] == 2) break;
			
			if(board[nx][ny] != 1) {
				int[] tail = bam.poll();
				board[tail[0]][tail[1]] = 0;
			}
			board[nx][ny] = 2;
			bam.offer(new int[] {nx, ny});
			x = nx; y = ny;
			
			if(!turn.isEmpty() && turn.peek()[0] == time) {
				int[] nextMove = turn.poll();
				switch(nextMove[1]) {
				case 'D':
					trace = (trace +1)%4;
					break;
				case 'L':
					trace = (trace+3)%4;
					break;
				}
			}
		}
		System.out.println(time);
	}
}
