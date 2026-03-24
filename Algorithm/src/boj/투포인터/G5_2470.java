package boj.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int []arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length-1;
		int p1 = 0, p2 = 0;
		int M = Integer.MAX_VALUE;
		while(left < right) {
			
			int sum = Math.abs(arr[left] + arr[right]);
			if(sum < M) {
				M = sum;
				p1 = left;
				p2 = right;	
			}
			if(arr[left] + arr[right] < 0) left++;
			else right--;
		}
		System.out.println(arr[p1] + " " +arr[p2]);
	}
}
