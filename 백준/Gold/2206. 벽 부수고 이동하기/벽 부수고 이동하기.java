import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[][] map;
	static int[][][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {1,1,0});
		dist[1][1][0] = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			int cw = cur[2]; // 벽을 부쉈는지 		
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx>0 && nx<=N && ny>0 && ny<=M) {
					if(map[nx][ny] == 1 && cw == 1) continue;
					
					if(map[nx][ny] == 1 && dist[nx][ny][0]==0){
						queue.add(new int[] {nx, ny, 1});
						dist[nx][ny][1] = dist[cx][cy][0] + 1;
					} else if(map[nx][ny] == 0 && dist[nx][ny][cw]==0) {
						queue.add(new int[] {nx, ny, cw});
						dist[nx][ny][cw] = dist[cx][cy][cw] + 1;
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
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1][2];
		
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j+1] = input.charAt(j)-'0';
			}
		}
		bfs();
		int result = -1;
		if(dist[N][M][0] !=0 ) result = dist[N][M][0];
		if(dist[N][M][1] != 0) result = (result == -1) ? dist[N][M][1] : Math.min(result, dist[N][M][1]);
		System.out.println(result);

	}
}