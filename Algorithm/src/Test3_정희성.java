import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3_정희성 {
	public static char[][] place;
	public static int robinX, robinY;
	public static int H, W, N;
	public static int trace;
	public static int robinEye;
							//D U R L
							//0 1 2 3
 	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void move() {
		place[robinX][robinY] = '.';
		int nx = robinX+dx[trace];
		int ny = robinY+dy[trace];
		
		if(nx >= H || ny >= W || nx < 0 || ny < 0) return;
		if(place[nx][ny]=='#' || place[nx][ny]=='-' || place[nx][ny] =='*') return;
		
		robinX = nx;
		robinY = ny;
		switch(trace) {
		case 0:
			place[nx][ny] ='v';
			break;
		case 1:
			place[nx][ny] ='^';
			break;
		case 2:
			place[nx][ny] ='>';
			break;
		case 3:
			place[nx][ny] ='<';
			break;
		}
		
	}
	public static void shot() {
		int nx = robinX;
		int ny = robinY;
		
		while(true) {
			nx = nx + dx[trace];
			ny = ny + dy[trace];
			if(nx >= H || ny >= W || nx < 0 || ny < 0) break;
			if(place[nx][ny]=='#') break;
			
			if(place[nx][ny]=='*') {
				place[nx][ny] = '.';
				break;
			}
			
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		//---------솔루션 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			place = new char[H][W];
			
			for(int i = 0; i < H;i++) {
				String s = br.readLine();
				for(int j = 0; j < W; j++) {
					place[i][j] = s.charAt(j);
					if(place[i][j]=='^') {
						robinX = i;
						robinY = j;
						trace = 1;
					}else if(place[i][j]=='v') {
						robinX = i;
						robinY = j;
						trace = 0;
					}else if(place[i][j]=='<') {
						robinX = i;
						robinY = j;
						trace = 3;
					}else if(place[i][j]=='>') {
						robinX = i;
						robinY = j;
						trace = 2;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			
			String commands = br.readLine();
			
			
			
			//D U R L
			//0 1 2 3
			
			for(int i = 0;i < N;i++) {
				char C = commands.charAt(i);
				switch(C) {
				case 'U':
					trace = 1;
					move();
					break;
				case 'D':
					trace = 0;
					move();
					break;
				case 'L':
					trace = 3;
					move();
					break;
				case 'R':
					trace = 2;
					move();
					break;
				case 'S':
					shot();
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			for(int i = 0;i < H;i++) {
				for(int j =0;j<W;j++) {
					sb.append(place[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}

}
