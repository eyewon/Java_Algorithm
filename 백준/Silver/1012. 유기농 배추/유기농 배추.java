import java.io.*;
import java.util.*;

class Main {
	static int M, N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx <M && ny>=0 && ny <N) {
				if(!visited[nx][ny] && map[nx][ny] == 1)
					dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //가로길이 
			N = Integer.parseInt(st.nextToken()); //세로길이
			int K = Integer.parseInt(st.nextToken()); //배추 수
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			int cnt=0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}