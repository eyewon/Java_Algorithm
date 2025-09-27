import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] cnt;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int year;

	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int cx = now[0];
			int cy = now[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny]>0 && !visited[nx][ny]) {
						q.add(new int[] {nx,ny});
						visited[nx][ny]= true;
					}
					if(map[nx][ny]==0) cnt[cx][cy]++;
				}
			}
		}
	}
	
	public static void after1year() {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				map[i][j] = map[i][j] < cnt[i][j]? 0:map[i][j]-cnt[i][j];
			}
		}
		year++;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		year=0;
		while(true) {
			visited = new boolean[N][M];
			cnt = new int[N][M];
			int ice=0; //빙산 덩어리 개수
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<M-1; j++) {
					if(map[i][j]>0 && !visited[i][j]) {
						bfs(i,j);
						ice++;
					}
				}
			}
			if(ice==0) {
				System.out.println(0);
				return;
			}
			if(ice>=2) {
				System.out.println(year);
				return;
			}
			after1year();
		}
		
	}
}
