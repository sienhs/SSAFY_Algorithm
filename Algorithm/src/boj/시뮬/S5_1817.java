package boj.시뮬;

import java.util.*;
import java.io.*;
public class S5_1817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		Queue<Integer> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N;i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		int bukkit = 0;
		int boxCount = 1;
		while(!q.isEmpty()) {
			int num = q.poll();
			if(bukkit+num<=M) {
				bukkit+=num;
			}else {
				boxCount++;
				bukkit=num;
			}
		}
		System.out.println(boxCount);
	}
}
