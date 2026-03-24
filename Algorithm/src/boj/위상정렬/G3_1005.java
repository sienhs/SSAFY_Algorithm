package boj.위상정렬;

import java.util.*;
import java.io.*;


public class G3_1005 {
	public static int N, M, W;
	public static int[] inDegree;
	public static int[] remain;
	public static List<List<Integer>> works;
	public static boolean[] isComplete;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 노드 개수
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc < T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			// 작업 량
			M = Integer.parseInt(st.nextToken());
			
			///////////////////////////////////////
			inDegree = new int[N+1];
			remain = new int[N+1];				// 건설완료 최소시간 저장  
			isComplete = new boolean[N+1];		// 건설 완료 여부
			works = new ArrayList<>();			// 작업 저장 2중리스트
			
			//////////////////////////////////////
			// 건설완료 시간 입력
			st = new StringTokenizer(br.readLine()); 
			for(int i = 1;i < N+1; i++) remain[i] = Integer.parseInt(st.nextToken());
			
			// 작업 저장 리스트 초기화
			for(int i = 0; i < N+1;i++) works.add(new ArrayList<>());
			
			// 작업 입력받기
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				works.get(A).add(B);
				inDegree[B]++;
			}
			
			W = Integer.parseInt(br.readLine());
			// 위상정렬 시작
			System.out.println(topolSort());
		}
	}
	public static int topolSort() {
		Queue<Integer> q = new LinkedList<>();
		int[] totalTime = new int[N+1];
		
		for(int i = 1; i < N+1;i++) {
			// inDegree(진입차수)가 0인 애들 모두 큐에 넣기(초기설정)
			if(inDegree[i] == 0) {
				q.offer(i);
				totalTime[i] = remain[i];
			}
		}
		
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int next : works.get(current)) {
				// 다음 작업들의 진입 차수를 1씩 줄이기
				totalTime[next] = Math.max(totalTime[next], totalTime[current] + remain[next]);
				inDegree[next]--;
				
				// 근데 줄이고 나니까 진입차수가 0이 되면 다음 큐에 추가
				if(inDegree[next] == 0) {
					q.offer(next);
				}
			}
			
		}
		
		// 위상 정렬이 끝났으니 출력
		
		return totalTime[W];
	}
}