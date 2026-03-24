package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_5215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int items [][] = new int[N][2];
			
			
			for(int i = 0;i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				items[i][0] = Integer.parseInt(st.nextToken());
				items[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// Limit 이하로 조합이 가능 모든 경우의수를 저장 <칼로리조합>
			// power set?
			ArrayList<Integer> arr = new ArrayList<>();
			int maxScore=0;
			for(int i = 1; i < (1 << items.length);i++) {
				ArrayList<Integer> buck = new ArrayList<>();
				int score = 0;
				int calorie = 0;
				for(int j = 0; j<items.length;j++) {
					if((i & (1 <<j)) != 0) {
						score+=items[j][0];
						calorie+=items[j][1];
					}
					if(calorie <= L) {
						maxScore = Math.max(maxScore, score);
					}
					
				}
			}
			System.out.println("#"+tc+" "+maxScore);
			
			// 모든 경우의 수 중에서 맛의 점수가 가장 높은 경우의 수의 인덱스 번호를 출력 <칼로리조합>[idx]
			// 
			
			
			
			
			
		}
	}
}
