package boj.위상정렬;

import java.util.*;
import java.io.*;


public class G2_1766 {
	public static int N, M;
	public static List<List<Integer>> works = new ArrayList<>();
	public static int[] inDegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegree = new int[N+1];
		for(int i = 0; i < N+1;i++) {
			works.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			works.get(A).add(B);
			inDegree[B]++;
		}
		
		priorityQueueTopolSort();
		
	}
	public static void priorityQueueTopolSort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		List<Integer> result = new ArrayList<>();
		for(int i = 1; i < N+1;i++) {
			if(inDegree[i] == 0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			result.add(current);
			for(int next : works.get(current)) {
				inDegree[next]--;
				
				if(inDegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		for(int temp : result) System.out.print(temp + " ");
	}
}