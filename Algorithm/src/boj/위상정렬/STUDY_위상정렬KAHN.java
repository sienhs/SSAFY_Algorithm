package boj.위상정렬;

import java.util.*;
import java.io.*;


public class STUDY_위상정렬KAHN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 노드의 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 진입차수들을 저장할 배열
		int [] inDegree = new int[N+1];
		

		// A가 B앞에 와야한다 or B를 하기위해서는 A를 먼저 해야한다.
		// graph.get(A).add(B);
		// inDegree[B]++;    <--- B로 들어오는 화살표가 생기면 진입차수(배열인덱스) 1 증가
		
		// 작업들을 저장할 2중 리스트
		List<List<Integer>> graph = new ArrayList<>();
		
		// 얘는 그냥 2중 리스트를 초기화를 위한 반복문
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 입력이 끝났으니 위상정렬 시작
		topolSort(N, inDegree, graph);
	}
	public static void topolSort(int N, int[] inDegree, List<List<Integer>> graph) {
		// 대기열
		Queue<Integer> q = new LinkedList<>();
		
		// 정렬된 결과를 담는 리스트
		List<Integer> result = new ArrayList<>();
		
		// TODO::01 처음 시작할 때, 진입 차수가 0인 노드를 모두 큐에 넣는다.
		for(int i = 1; i < N+1; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		// TODO::02 작업 선별 및 검증
		while(!q.isEmpty()) {
			// 1. 큐에서 작업을 하나 꺼낸다.
			int current = q.poll();
			
			// 2. 꺼낸 작업은 결과 리스트에 넣는다. << 결과를 큐에서 꺼내자마자 결과에 추가.
			result.add(current);
			
			// 3. 현재 노드와 연결된 다음 노드들의 진입차수를 1 뺀다. (퀘스트를 하나 깼으니 다음 퀘스트들의 선행조건에서 삭제해준다는 느낌)
			for (int next : graph.get(current)) {
				inDegree[next]--; // 진입차수 배열에서 노드번호를 인덱스 삼아서 뺀다.
				
				// 차감과 동시에 진입차수가 0이 된 노드가 있는지를 검사한다
				if (inDegree[next] == 0) {
					q.offer(next); // 다음 작업에다가 추가
				}
			}
		}
		
		// TODO::03 사이클 체크
		// 만약에 결과값 크기{result.size()}가 N과 다르다면, 그래프 안에 사이클이 있다는 것으로 간주
		if(result.size() != N) {
			System.out.println(-1); // 사이클이 있으므로 정렬이 불가능하다 (-1 출력)
		}else {
			// 사이클이 없다면 (N과 사이즈가 같다면) 결과를 출력
			System.out.println(result);
		}
	}
}
