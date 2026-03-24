package boj.위상정렬;

import java.util.*;
import java.io.*;


public class G3_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 노드 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 작업 량
		int M = Integer.parseInt(st.nextToken());
		
		// 진입차수 배열 0은 안쓰고 N+1로 만듬
		int[] inDegree = new int[N+1];
		
		// 작업 저장 2중리스트
		List<List<Integer>> works = new ArrayList<>();
		
		// 2중 리스트 초기화
		for(int i = 0; i < N+1;i++) works.add(new ArrayList<>());
		
		// 작업 입력받기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			works.get(A).add(B);
			inDegree[B]++;
		}
		
		
		/////////////// 위상 정렬
		// 대기열
		Queue<Integer> q = new LinkedList<>();

		// 결과값 저장 리스트
		List<Integer> result = new ArrayList<>();
		
		for(int i = 1; i < N+1;i++) {
			// inDegree(진입차수)가 0인 애들 모두 큐에 넣기(초기설정)
			if(inDegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			// q에서 하나 꺼내서
			int current = q.poll();
			
			// 결과값 저장 
			result.add(current);
			
			// 다음 작업 순차적으로 꺼내기
			for(int next : works.get(current)) {
				// 다음 작업들의 진입 차수를 1씩 줄이기
				inDegree[next]--;
				
				// 근데 줄이고 나니까 진입차수가 0이 되면 다음 큐에 추가
				if(inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		// 위상 정렬이 끝났으니 출력
		for(int i : result) System.out.print(i + " ");
		
	}
}