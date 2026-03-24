package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc < T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int [] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int result = -1;
			for(int i=0;i<N-1;i++) {				
				for(int j =0;j<i+1;j++) {
					if(arr[i]+arr[j] <= M) {
						result = Math.max(result, arr[i] + arr[j]);
					}
				 
				}
				
			}
			System.out.println("#"+tc+" "+result);
			
		}
		
	}
}
