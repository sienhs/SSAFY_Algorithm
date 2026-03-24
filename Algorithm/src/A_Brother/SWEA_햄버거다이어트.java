package A_Brother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트 {
	public static int L;
	public static int N;
	public static int[][] items;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			items = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				items[i][0] = Integer.parseInt(st.nextToken()); // 맛
				items[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			int [] dptable = new int[L+1];
			for(int i = 0; i < N;i++) {
				int taste = items[i][0];
				int kcal = items[i][1];
				for(int curKcal = L; curKcal>=kcal;curKcal--) {
					dptable[curKcal] = Math.max(dptable[curKcal], dptable[curKcal - kcal] + taste);
				}
			}
			
			System.out.println("#"+tc+" "+dptable[L]);
			
			
		}
		
	}
	
}
