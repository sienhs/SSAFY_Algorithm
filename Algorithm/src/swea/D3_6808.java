package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_6808 {
	
	static ArrayList<Integer> myCard = new ArrayList<>();
	static ArrayList<Integer> rvCard = new ArrayList<>();
	static ArrayList<Integer> rvStep = new ArrayList<>(
			Arrays.asList(0,0,0,0,0,0,0,0,0)
			);
	static boolean[] visited = new boolean[9];
	static int win, lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	myCard.clear();
        	rvCard.clear();
        	win =0;
        	lose =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 9; i++) {
                myCard.add(Integer.parseInt(st.nextToken()));
            }
            for(int j = 1; j < 18+1; j++) {
            	if(!myCard.contains(j)) rvCard.add(j);
            	
            }
            
            perm(0);
            
            System.out.println("#"+tc+" "+win+" "+lose);
            
            
            
        }
	}
	static void perm(int dep) {
		if(dep == 9) {
			int my =0, rv =0;
			for(int i = 0; i < 9; i++) {
				if(myCard.get(i) > rvStep.get(i)) my+=(myCard.get(i) + rvStep.get(i));
				else rv+=(myCard.get(i) + rvStep.get(i));
			}
			if(my > rv) win ++;
			else if(rv > my) lose++;
			return;
		}
		for(int i =0; i <9;i++) {
			if(!visited[i]) {
				visited[i] = true;
				rvStep.set(dep, rvCard.get(i));
				perm(dep + 1);
				visited[i] = false;
				
			}
		}
		
	}
}
