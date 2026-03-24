package boj.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11728_cover {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] left = new int[N];
		int[] right = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < N; i++) left[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < M; i++) right[i] = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : merge(left, right)) sb.append(i).append(" ");
		System.out.println(sb);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length+right.length];
		int l = 0, r = 0, k = 0;
		while(l < left.length && r < right.length) {
			if(left[l] <= right[r]) {
				result[k++] = left[l++];
			}else {
				result[k++] = right[r++];
			}
		}
		while(l < left.length) {
			result[k++] = left[l++];
		}while(r < right.length) {
			result[k++] = right[r++];
		}
		return result;
	}
}