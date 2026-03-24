package edutree;
import java.util.Scanner;

public class Day3_금채굴하기{
	public static int n;
	public static int[][] grid = new int [20][20];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        int mGold = 0;
        for(int i = 0; i < n; i ++) {
        	for(int j = 0; j < n;j ++) {
        		
        		for(int k = 0; k < n+1 ;k++) {
        			
        			int g = getGold(i, j, k);
        			
        			int cost = k*k + (k+1) * (k+1);
        			if(g * m >= cost) mGold = Math.max(mGold, g);
        			
        		}
        	}
        }
        System.out.println(mGold);
        
        
    }
	public static int getGold(int row, int col, int k) {
		int stage = 0;
		for(int i = 0; i < n;i++) {
			for(int j = 0; j < n;j++) {
				if(Math.abs(row-i)+Math.abs(col-j) <= k) {
					stage += grid[i][j];
				}
			}
		}
		return stage;
	}
}

