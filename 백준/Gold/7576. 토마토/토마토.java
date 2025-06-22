import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[][] box;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs(Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			visited[cx][cy] = true;
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny <M) {
					if(!visited[nx][ny] && box[nx][ny] == 0) {
						visited[nx][ny] = true;
						box[nx][ny]=1;
						queue.add(new int[] {nx, ny});
						dist[nx][ny] = dist[cx][cy] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		visited = new boolean[N][M];
		dist = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		bfs(queue);
		int max = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, dist[i][j]);
			}
		}
		System.out.println(max);
	}
}