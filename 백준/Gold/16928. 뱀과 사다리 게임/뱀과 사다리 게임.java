import java.io.*;
import java.util.*;

class Main {
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];
	static int[] dist = new int[101];
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		dist[1]=0;
		visited[1]=true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == 100) {
				System.out.println(dist[cur]);
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next = cur+i;
				if(next <= 100 && board[next]!=0) {
					visited[next] = true;
					next = board[next];
				}
				if(next <= 100 && !visited[next]) {
					queue.add(next);
					visited[next] = true;
					dist[next] = dist[cur] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}
		
		bfs();
	}
}