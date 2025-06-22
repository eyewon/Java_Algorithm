import java.io.*;
import java.util.*;

class Main {
	static int I;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
	
	public static void bfs(int startX, int startY, int endX, int endY) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		dist[startX][startY] = 0;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cX = current[0];
			int cY = current[1];
			
			if(cX == endX && cY == endY) {
				System.out.println(dist[endX][endY]);
				return;
			}
			
			for(int i=0; i<8; i++) {
				int nX = cX + dx[i];
				int nY = cY + dy[i];
				if(nX>=0 && nX<I && nY>=0 && nY<I) {
					if(!visited[nX][nY]) {
						queue.add(new int[]{nX, nY});
						visited[nX][nY] = true;
						dist[nX][nY] = dist[cX][cY] + 1;
					} 
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			I = Integer.parseInt(br.readLine()); //체스판 크기 
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			dist = new int[I][I];
			visited = new boolean[I][I];
			
			bfs(startX, startY, endX, endY);
		}
	}
}