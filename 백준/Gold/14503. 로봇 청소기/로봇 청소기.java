import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] room;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, -0, -1};
	static int cnt;
	
	public static void dfs(int x, int y, int d) {
		if(room[x][y] == 0) {
			room[x][y] = 2; //청소 완료
			cnt++;
		}
		
		boolean flag = false;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<N && ny>=0 && ny<M && room[nx][ny]==0) {
				flag = true;
			}
		}
		
		if(flag) {
			int nd = d;
			for(int i=0; i<4; i++) {
				nd = (nd-1+4) % 4;
				int fx = x + dx[nd];
				int fy = y + dy[nd];
				if(room[fx][fy]==0) {
					dfs(fx, fy, nd);
					break;
				}
			}
		}else {
			int bx = x-dx[d];
			int by = y-dy[d];
			if(room[bx][by]!=1) {
				dfs(bx, by, d);
			}else {
				return;
			}
		}
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt=0;
		dfs(r, c, d);
		System.out.println(cnt);
	}
}
