package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_5648 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc < T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			List<Dot> list = new ArrayList<>();
			List<Collision> colls = new ArrayList<>(); // 종합 정보 통합 리스트
			for(int i = 0; i < N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int trace = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				list.add(new Dot(x, y, trace, energy));
			}
			// trace가 서로 마주보고 있어야함 0 1, 2 3
			for(int i=0;i < N;i++) {
				for(int j = i+1;j <N;j++) {
					if(i!=j) {
						int T1 = list.get(i).trace;
						int T2 = list.get(j).trace;
						int ix = list.get(i).x; int iy = list.get(i).y;
						int jx = list.get(j).x; int jy = list.get(j).y;
						int dx = jx - ix;
						int dy = jy - iy;
						int absDx = Math.abs(dx);
						int absDy = Math.abs(dy);

						// 가로세로 
						if (dx == 0) { // 세로 일직선 (x좌표 동일)
						    
						    if (dy > 0 && T1 == 0 && T2 == 1) colls.add(new Collision(absDy / 2.0, i, j));
						    
						    else if (dy < 0 && T1 == 1 && T2 == 0) colls.add(new Collision(absDy / 2.0, i, j));
						} 
						else if (dy == 0) { // 가로 일직선 (y좌표 동일)
						    
						    if (dx > 0 && T1 == 3 && T2 == 2) colls.add(new Collision(absDx / 2.0, i, j));
						    
						    else if (dx < 0 && T1 == 2 && T2 == 3) colls.add(new Collision(absDx / 2.0, i, j));
						}
						else if (absDx == absDy) {// 수직 직각 충돌
						    double time = (double)absDx; 
						    
						    if (dx > 0 && dy > 0) {
						        if ((T1 == 0 && T2 == 2) || (T1 == 3 && T2 == 1)) colls.add(new Collision(time, i, j));
						    }else if (dx < 0 && dy > 0) {
						        if ((T1 == 0 && T2 == 3) || (T1 == 2 && T2 == 1)) colls.add(new Collision(time, i, j));
						    }else if (dx < 0 && dy < 0) {
						        if ((T1 == 1 && T2 == 3) || (T1 == 2 && T2 == 0)) colls.add(new Collision(time, i, j));
						    }else if (dx > 0 && dy < 0) {
						        if ((T1 == 1 && T2 == 2) || (T1 == 3 && T2 == 0)) colls.add(new Collision(time, i, j));
						    }
						}
					}
				}
			}
			// 서로 충돌하는 case들의 충돌시간과 충돌하는 원소들의 list의 index값을 dotsIdx와 brTimes에 저장함
			
			int totalEnergy=0;
			boolean[] isDead = new boolean[N];
			// 아래는 충돌시간순으로 재정렬하고 에너지값을 저장해야함
			Collections.sort(colls);
			
			for(int i = 0; i < colls.size();) {
				double currentTime = colls.get(i).time;
				Set<Integer> burst = new HashSet<>();
				int j=i;
				while(j < colls.size() && Double.compare(colls.get(j).time, currentTime) == 0) {
					Collision c = colls.get(j);
					if(!isDead[c.dot1Idx] && !isDead[c.dot2Idx]) {
						burst.add(c.dot1Idx);
						burst.add(c.dot2Idx);	
					}
					j++;
				}
				for(int dotIdx : burst) {
					if(!isDead[dotIdx]) {
						totalEnergy += list.get(dotIdx).energy;
						isDead[dotIdx] = true;
					}
				}
				i=j;
			}
			
			
			System.out.println("#"+tc+" "+totalEnergy);
		}
		
		
	}
}
class Collision implements Comparable<Collision>{
	double time;
	int dot1Idx;
	int dot2Idx;
	
	public Collision(double time, int dot1Idx, int dot2Idx) {
		this.time = time;
		this.dot1Idx = dot1Idx;
		this.dot2Idx = dot2Idx;
	}
	
	@Override
	public int compareTo(Collision o) {
		// TODO Auto-generated method stub
		return Double.compare(this.time, o.time);
	}
	
}
class Dot{
	int x; 
	int y;
	int trace;
	int energy;
	public Dot(int x,int y, int trace, int energy) {
		this.x = x;
		this.y = y;
		this.energy = energy;
		this.trace = trace;
	}

	
}