package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DN_2115_T {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc < T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			// M 선택가능 개수
			// C 최대 수량 제한
			
			int tong[][] = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					
					tong[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(Arrays.deepToString(tong));
//			int maxs[] = new int[N];
			int scores[][] = new int [N][N-M];
			for(int i = 0;i < N;i++) {
//				int maxsum =0; // 최대합 임시 저장
				
				int sc =0; // 한칸의 점수 저장
				for(int j=0; j < M;j++) {
//					maxsum += tong[i][j];
					if(tong[i][j] - C <= 0) { // 한 칸의 꿀 - C가 0보다 작거나 같으면 채취가능.
						
					}
				}
				
				
//				maxs[i] = maxsum;
				for(int j=M;j < N-M;j++) {
//					maxsum += tong[i][j] - tong[i][j-M];
//					maxsum = Math.max(maxs[i], maxsum);
				}
//				maxs[i] = maxsum;
			}
		}
		
	}
}
