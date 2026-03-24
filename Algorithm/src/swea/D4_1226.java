package swea;


import java.util.Scanner;

public class D4_1226 {
	static int[] row = {-1, 0, 1, 0};
    static int[] col = { 0, 1, 0,-1};
    static int[][] map = new int[16][16];
    
	public static boolean isRoad(int r, int c) {
		if (map[r][c] == 3) return true;
		map[r][c] = 1;
		for(int s = 0; s < 4;s++) {
			int nr = r + row[s];
			int nc = c + col[s];
			
			if(nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && map[nr][nc] != 1) {
				if(isRoad(nr, nc)) return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();
            
            
            for (int i = 0; i < 16; i++) {
                String line = sc.next();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }	 
            
            int result = isRoad(1, 1) ? 1 : 0;
            System.out.println("#"+tc+" "+result);    	 
		}
		sc.close();
	}	
}			
			
			
			
			
