import java.io.*;
import java.util.*;

class Main {
	static int M, N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		
		visited[x][y] = true;
		queue.add(new int[] {x, y});
		dist[x][y] = 1;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx >=0 && nx < N && ny>=0 && ny < M) {
					if(!visited[nx][ny] && map[nx][ny]==1) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny]= true;
						dist[nx][ny] = dist[cx][cy] + 1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		dist = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		bfs(0,0);
		System.out.println(dist[N-1][M-1]);
	}
}