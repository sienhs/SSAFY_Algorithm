package boj.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S3_2606 {
	static ArrayList<Integer> cv = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tr = new ArrayList<>();
	
	static void Virus(int n) {
		for(int node : tr.get(n)) {
			if(!(cv.contains(node))) {
				cv.add(node);
				Virus(node);
			} 
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 0;i <= N;i++) {
			tr.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		int coms = Integer.parseInt(st.nextToken());
		
		for(int i=0;i < coms;i++) {
			st = new StringTokenizer(br.readLine());
			int l1 = Integer.parseInt(st.nextToken());
			int l2 = Integer.parseInt(st.nextToken());
			tr.get(l1).add(l2);
			tr.get(l2).add(l1);
		}
		cv.add(1);
		Virus(1);
		System.out.println(cv.size()-1);
	}
	
}
