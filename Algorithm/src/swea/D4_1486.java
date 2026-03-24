package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class D4_1486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc < T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			empolys = new int [N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N;i++) {
				empolys[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(empolys);

			for(int i = 0; i < N;i++) {
				multiSet(i, 0);
			}
			System.out.println("#"+tc+" "+min);
		}
	}
	public static int N;
	public static int B;
	public static int [] empolys;
	public static int min = Integer.MAX_VALUE;
	public static void multiSet(int startIdx, int sum){
		if(sum - B >= min) return;
		if(startIdx == N) {
			if(sum >= B) {
				min = Math.min(min, sum-B);
			}
			return;
		}
		multiSet(startIdx+1, sum + empolys[startIdx]);
		multiSet(startIdx+1, sum);
	}
}
