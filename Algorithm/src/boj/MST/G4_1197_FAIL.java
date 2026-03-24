package boj.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class G4_1197_FAIL {
	public static class Line implements Comparable<Line>{
		int currentNode;
		int targetNode;
		int weight;
		public Line(int cn, int tn, int weight) {
			this.currentNode = cn;
			this.targetNode = tn;
			this.weight = weight;
		}
		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	public static int V, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		List<Line> lines = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int cn = Integer.parseInt(st.nextToken());
			int tn = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			lines.add(new Line(cn, tn, weight));
		}
		// 입력 끝
		PriorityQueue<Line> pq = new PriorityQueue<>();
		Collections.sort(lines);
		pq.offer(lines.get(0));
		while(!pq.isEmpty()) {
			
		}
		
	}
	
	public static Queue<Line> selected = new LinkedList<>();
	public static boolean isCycle() {
		HashSet<Integer> set = new HashSet<>();
		while(!selected.isEmpty()) {
			Line l = selected.poll();
			set.add(l.targetNode);
		}
		if(set.size() == V) return false;
		return false;
	}
}
