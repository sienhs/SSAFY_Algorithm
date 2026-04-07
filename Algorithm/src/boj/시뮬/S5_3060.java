package boj.시뮬;

import java.util.*;
import java.io.*;

public class S5_3060 {
	// (index-1)+(index+1)+((index+3)%6)
	static int T;
	static int[] pig;
	static int totalCost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc < T+1;tc++) {
			long food = Integer.parseInt(br.readLine());
			totalCost = 0;
			pig = new int[6];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				pig[i] = Integer.parseInt(st.nextToken());
			}
			totalCost = Arrays.stream(pig).sum();
			int days = 1;
			while(totalCost <= food) {
				totalCost*=4;
				days++;
			}
			System.out.println(days);
		}
	}
	
}
