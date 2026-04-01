package boj.구현;

import java.io.*;
import java.util.*;

public class G5_21608 {
	static class Student{
		int sn;// studentNumber
		int[] table;
		int[] loveStudents;
		int happy;
		
		public Student(int sn, int[] ls) {
			this.sn = sn;
			this.loveStudents = ls;
			this.table = new int[2];
		}
		
		public int calcHappy() {
			int love = 0;
			
			int row = this.table[0];
			int col = this.table[1];
			
			for(int t = 0; t < 4; t++) {
				int nr = row + dx[t];
				int nc = col + dy[t];
				if(nr >= N || nc >= N || nr < 0 || nc < 0 ) continue;
				
				for(int i : this.loveStudents) if(board[nr][nc] == i) love++;
			}
			
			if(love == 0) return 0;
			return (int)Math.pow(10, love-1);
		}
		public void setTable(int[] tb) {
			this.table = tb;
		}
	}
	static int N;
	static int[][] board;
	static List<Student> stus = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		for(int i =0; i < N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int[] ls = new int[4];
			for(int j = 0; j < 4; j++) {
				ls[j] = Integer.parseInt(st.nextToken());
			}
			stus.add(new Student(sn, ls));
		}
		
		for(Student s : stus) {
			int[] table = searchTask(s);
			board[table[0]][table[1]] = s.sn;
			s.setTable(table);
		}

		int total = 0;
		for(Student s : stus) {
			total += s.calcHappy();
		}
		System.out.println(total);
	}
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};

	public static int[] searchTask(Student s){
		List<int[]> result = new ArrayList<>();
		int[][] loves = new int[N][N];
		int[][] emptys = new int[N][N];
		int[] ls = s.loveStudents;
		
		for(int row = 0; row < N;row++) {
			for(int col = 0; col < N; col++) {
				if(board[row][col] != 0) continue;
				int empty = 0;
				int love = 0;
				for(int t = 0; t < 4; t++) {
					int nr = row+dx[t];
					int nc = col+dy[t];
					
					if(nr >= N || nc >= N || nr < 0 || nc < 0 ) continue;
					
					if(board[nr][nc] == 0) empty++;
					for(int i : ls) if(board[nr][nc] == i) love++;
					
					
					
				}
				emptys[row][col] = empty;
				loves[row][col] = love;				
			}
		}
		
		
		// 좋아하는 사람 수 중 max값 찾기
		int max = 0;
		for(int i = 0; i < N;i++) for(int j = 0; j < N;j++) max = Math.max(max, loves[i][j]);
		
		
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < N;j++) {
				if(board[i][j] != 0) continue;
				if(loves[i][j] == max) {
					result.add(new int[] {i, j});
				}
			}
		}
		if(result.isEmpty()) System.out.println("loves is Empty.");
		
		// 1번 조건을 만족하는 칸이 여러개일 경우
		// 2번 조건 진행 (비어있는 칸이 가장 많은 칸)
		if(result.size() > 1) {
			int emptyMax = 0;
			for(int i = 0; i < result.size();i++) {
				int row = result.get(i)[0];
				int col = result.get(i)[1];
				emptyMax = Math.max(emptyMax, emptys[row][col]);
			}
			
			List<int[]> temp = new ArrayList<>();
			for(int i = 0; i < result.size();i++) {
				int row = result.get(i)[0];
				int col = result.get(i)[1];
				
				if(emptys[row][col] == emptyMax) {
					temp.add(new int[] {row, col});
				}
			}
			result = temp;
			
			if(temp.size() > 1) { // ROW
				int minRow = Integer.MAX_VALUE;
				for(int i = 0; i < temp.size();i++) {
					minRow = Math.min(minRow, temp.get(i)[0]);
				}
				List<int[]> minRows = new ArrayList<>();
				for(int i = 0; i < temp.size();i++) {
					if(temp.get(i)[0] == minRow) {
						minRows.add(temp.get(i));
					}
				}
				
				result = minRows;
				if(minRows.size() > 1) { // 값이 1개 인것이 반드시 보장된다.
					int minCol = Integer.MAX_VALUE;
					int[] colLoc = new int[2];
					for(int i = 0; i < minRows.size();i++) {
						if(minRows.get(i)[1] < minCol) {
							minCol = minRows.get(i)[1];
							colLoc = minRows.get(i);
						}
					}
					return colLoc;
					
				}
			}
		}
		
		return result.get(0);
	}
	
	public static void test(int[][] testArr) {
		for(int[] arr : testArr) {
			for(int i : arr) System.out.print(i + " ");
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}
