import java.io.*;
import java.util.*;

public class Main {
	static int H, M, N;
	static int[][][] box;
	static int[] dh = {-1,1,0,0,0,0};
	static int[] dx = {0,0,0,0,-1,1};
	static int[] dy = {0,0,1,-1,0,0};
	static int[][][] dist;
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[k][i][j]==1) {
						q.add(new int[] {k, i, j});
						dist[k][i][j]=0;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ch = now[0];
			int cx = now[1];
			int cy = now[2];
			for(int i=0; i<6; i++) {
				int nh = ch + dh[i];
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nh>=0 && nh <H && nx>=0 && nx<N && ny>=0 && ny<M) {
					if(box[nh][nx][ny]==0) {
						box[nh][nx][ny]=1;
						q.add(new int[] {nh, nx, ny});
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
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				Arrays.fill(dist[i][j], -1);
			}
		}
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();

		int max=-1;
		for(int h=0; h<H; h++) {
			for(int x=0; x<N; x++) {
				for(int y=0; y<M; y++) {
					if(box[h][x][y]==0) {
						System.out.println(-1);
						return;
					}
					if(max < dist[h][x][y]) {
						max = dist[h][x][y];
					}
				}
			}
		}
		System.out.println(max);
	}
}
