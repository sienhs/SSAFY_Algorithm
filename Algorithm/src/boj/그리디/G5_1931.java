package boj.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] meeting = new int[N][2];
		
		for(int i =0;i < N;i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		
		Arrays.sort(meeting, (o1, o2)->{
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
			
		});
		
		int cnt = 0;
		int endTime = 0;
		for(int i = 0;i < N;i++) {
			if(meeting[i][0] >= endTime) {
				endTime = meeting[i][1];
				cnt ++;
			}
		}
		System.out.println(cnt);
		
		/////////
	}
}
