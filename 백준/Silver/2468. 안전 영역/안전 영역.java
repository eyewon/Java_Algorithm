import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void dfs(int x, int y, int rain) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(!visited[nx][ny] && map[nx][ny] > rain)
					dfs(nx, ny, rain);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		int max = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) max = map[i][j];
			}
		}
		
		int rain = 0;
		int max_area = 0;
		while(rain <= max) {
			int area = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>rain && !visited[i][j]) {
						dfs(i, j, rain);
						area++;
					}
				}
			}
			if(max_area < area) max_area = area;
			rain++;
		}
		System.out.println(max_area);
	}
}
