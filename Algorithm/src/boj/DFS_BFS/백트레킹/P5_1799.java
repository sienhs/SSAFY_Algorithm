package boj.DFS_BFS.백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

public class P5_1799 {
	public static int N;
	public static int[][] pan;
	public static List<int[]> black;
	public static List<int[]> white;
	public static int total;
	public static int max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		pan = new int[N][N];

		black = new ArrayList<>();
		white = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				pan[i][j] = temp;
				if (temp == 1) {
					if((i+j)%2==0) black.add(new int[] { i, j });
					else white.add(new int[] {i, j});
				}
			}
		}
		max = 0;
		findMaxBishop(0, 0, black);
		total += max;
		max = 0;
		findMaxBishop(0, 0, white);
		total += max;
		System.out.println(total);
	}

	public static void findMaxBishop(int idx, int cnt, List<int[]> color) {
		if (idx == color.size()) {
			max = Math.max(max, cnt);
			return;
		}
		int x = color.get(idx)[0];
		int y = color.get(idx)[1];

		if (isSafe(x, y)) {
			pan[x][y] = 2;
			findMaxBishop(idx + 1, cnt + 1, color);
			pan[x][y] = 1;
		}
		findMaxBishop(idx + 1, cnt, color);
	}

	// 좌하 우상 우하 좌상
	public static int[] dx = { 1, -1, 1, -1 };
	public static int[] dy = { -1, 1, 1, -1 };

	public static boolean isSafe(int x, int y) {
		boolean result = true;
		for (int t = 0; t < 4; t++) {
			int nx = x, ny = y;
			while (true) {
				// 체스판 끝에 도달하면 break
				if (nx >= N || ny >= N || nx < 0 || ny < 0)
					break;

				// 한쪽 길로 쭉 가다가 비숍을 만나면 false
				if (pan[nx][ny] == 2)
					result = false;

				// 아무것도 없으면 계속 이동
				nx = nx + dx[t];
				ny = ny + dy[t];

			}
		}
		// 모든 대각선 방향에 방해받지 않는다면 비숍 배치
		return result;

	}

}
