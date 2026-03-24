package boj.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S5_1343 {
	public static int dasom;
	public static Integer[] ar;
	public static int N, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ar = new Integer[N-1];
		st = new StringTokenizer(br.readLine());
		dasom = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			ar[i] = Integer.parseInt(st.nextToken());
		}
		boolean end = isWin();
		while(!end) {
			calcVote();
			end = isWin();
			
		}
		System.out.println(cnt);
		
	}
	public static void calcVote() {
		Arrays.sort(ar, Collections.reverseOrder());
//		System.out.println(Arrays.toString(ar));
		ar[0] --;
		dasom ++;
		cnt++;
	}
	public static boolean isWin() {
		for(int i =0;i < ar.length;i++) {
			if(ar[i] >= dasom) return false;
		}
		return true;
	}
}
