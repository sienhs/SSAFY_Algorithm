package A_Brother;

import java.util.Scanner;

public class A_17070 {
	public static int room[][];
	public static boolean visited;
	public static int status;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		room = new int[N][N];
		
		
		for(int i = 0;i < N; i++) {
			for(int j = 0; j < N; j++) {
				room[i][j] = sc.nextInt();
			}
		}
		// 입력끝
		
		int startX = 1, startY = 2;
		// 현재 진행 방향 오른쪽 = 0 대각선 = 1 아래 = 2
		// 대각선 이동시 x-1, y+1 이 0이여야함
		// 오른쪽 이동시 y+1이 0이여야함
		// 아래쪽 이동시 x+1이 0이여야함
		// 현재 상태에서 이동가능한 방향을 찾고, 목표지점인지 검사 아니면 계속 진행 visited가 끝에 다다르면 0출력

	}
	public void pushPipe(int x, int y) {
		
		boolean pos[] = new boolean[3];
		if(status == 0) {
			if(room[x][y+1] == 0) {
				pos[0] = true;
			}
		}
		
	}
}
