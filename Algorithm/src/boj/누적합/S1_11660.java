package boj.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_11660 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long [][] base = new long[N + 1][N + 1];
		
		
		for(int j=1;j<=N;j++) {
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				base[j][i] = base[j][i -1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0;j<M;j++) {
			long r = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i =x1;i<=x2;i++) {
				r += base[i][y2] - base[i][y1 -1];			
			}
			System.out.println(r);
		}
		
	}
}
/*
 * 
 * 	public static List<ArrayList<Integer>> base = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int j=0;j<N;j++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				
				arr.add(sc.nextInt());
			}
			base.add(arr);
		}
		
		for(int j=0;j<M;j++) {
			int r = 0;
			int stX = sc.nextInt();
			int stY = sc.nextInt();
			int edX = sc.nextInt();
			int edY = sc.nextInt();
			
			for(int i =stY-1;i<edY;i++) {
				for(int l=stX-1;l<edX;l++) {
					r += base.get(i).get(l);
				}			
			}
			System.out.println(r);
		}
	}
 * */
