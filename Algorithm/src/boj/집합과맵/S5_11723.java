package boj.집합과맵;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

import java.util.Set;
import java.util.StringTokenizer;

public class S5_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int x;
			switch(word) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				set.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) set.remove(x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				sb.append(set.contains(x) ? "1\n" : "0\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) set.remove(x);
				else set.add(x);
				break;
			case "all":
				set.clear();
				for(int j = 1; j < 21;j++) set.add(j);
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
