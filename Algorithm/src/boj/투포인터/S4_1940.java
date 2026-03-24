package boj.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		int []arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length-1;
		int cnt = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum == M) {
				cnt++;
				left++;
				right--;
			}else {
				if(sum < M) {
					left++;					
				}else{
					right--;
				}
			}
		}
		System.out.println(cnt);
	}
}
