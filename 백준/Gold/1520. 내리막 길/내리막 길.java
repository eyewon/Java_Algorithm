import java.io.*;
import java.util.*;

class Main {
	static int N,M;
	static int[][] map, dp;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static int dfs(int x, int y) {
		
		if(x==M-1 && y==N-1) { //도착지
			return 1;
		}
		
		if(dp[x][y] != -1) return dp[x][y]; //이미 계산한 경로
		
		dp[x][y]=0;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && nx <M && ny >=0 && ny < N) {
				if( map[nx][ny] < map[x][y]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N]; // dp[x][y] = (x,y)에서 도착점까지 이동할 수 있는 경로의 수
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; //아직 방문 안함
			}
		}

		dfs(0,0);
		System.out.println(dp[0][0]);
	}
}