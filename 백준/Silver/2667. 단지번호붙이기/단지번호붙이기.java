import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int map[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int cnt;

	public static void dfs2D(int x, int y) {
		visited[x][y] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny <N) {
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					dfs2D(nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String[] st = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		int totalCnt = 0;
		ArrayList<Integer> cntList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					// 새로운 단지 발견
					cnt = 0;
					dfs2D(i,j);
					cntList.add(cnt);
					totalCnt ++;
				}
			}
		}
		Collections.sort(cntList);
		StringBuilder sb = new StringBuilder();
		sb.append(totalCnt).append("\n");
		for(int i=0; i<totalCnt; i++) {
			sb.append(cntList.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}