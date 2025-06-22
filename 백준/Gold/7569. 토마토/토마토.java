import java.io.*;
import java.util.*;

class Main {
	static int N, M, H;
	static int[][][] box;
	static int[][][] dist;
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {1, -1, 0, 0, 0, 0};
	
	public static void bfs(Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int ch = cur[0];
			int cx = cur[1];
			int cy = cur[2];
			
			for(int i=0; i<6; i++) {
				int nh = ch + dh[i];
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nh>=0 && nh<H && nx>=0 && nx<N && ny>=0 && ny <M) {
					if(box[nh][nx][ny] == 0) {
						box[nh][nx][ny]=1;
						queue.add(new int[] {nh, nx, ny});
						dist[nh][nx][ny] = dist[ch][cx][cy] + 1;
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
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		dist = new int[H][N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					
					if(box[h][i][j] == 1) {
						queue.add(new int[] {h, i, j});
					}
				}
			}
		}
		
		bfs(queue);
		int max = -1;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[h][i][j]==0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, dist[h][i][j]);
				}
			}
		}
		
		System.out.println(max);
	}
}